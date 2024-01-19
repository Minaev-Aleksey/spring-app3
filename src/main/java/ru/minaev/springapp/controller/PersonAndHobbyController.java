package ru.minaev.springapp.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.minaev.springapp.entity.PersonAndHobbyEntity;
import ru.minaev.springapp.repo.PersonAndHobbyRepo;

import java.io.Serializable;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
public class PersonAndHobbyController {

    @Autowired
    PersonAndHobbyRepo personAndHobbyRepo;

    RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "testExchange";

    @GetMapping("main")
    public String main(Map<String, Object> model) {
        Iterable<PersonAndHobbyEntity> personAndHobbyEntities = personAndHobbyRepo.findAll();
        model.put("personandhobby", personAndHobbyEntities);
        return "main";
    }

    @PostMapping("main")
    public String createPersonAndHobby(
            @RequestParam String name
            , @RequestParam int age
            , @RequestParam String hobby
            , Map<String, Object> model
    ) {
        PersonAndHobbyEntity personAndHobbyEntity = PersonAndHobbyEntity.makeDefault(name, age, hobby);
        personAndHobbyRepo.save(personAndHobbyEntity);

        Iterable<PersonAndHobbyEntity> personAndHobbyEntities = personAndHobbyRepo.findAll();
        model.put("personandhobby", personAndHobbyEntities);


            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "first.key", personAndHobbyEntity);
            log.info(personAndHobbyEntity + " is send!");

        return "main";
    }

    @PostMapping("filter")
    public String filterPersonAndHobby(
            @RequestParam String filter
            , Map<String, Object> model) {
        Iterable<PersonAndHobbyEntity> personAndHobbyEntities;
        if (filter != null && !filter.isEmpty()) {
            personAndHobbyEntities = personAndHobbyRepo.findByHobby(filter);
        } else {
            personAndHobbyEntities = personAndHobbyRepo.findAll();
        }
        model.put("personandhobby", personAndHobbyEntities);
        return "main";
    }

}