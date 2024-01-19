package ru.minaev.springapp.repo;

import org.springframework.data.repository.CrudRepository;
import ru.minaev.springapp.entity.PersonAndHobbyEntity;

import java.util.List;

public interface PersonAndHobbyRepo extends CrudRepository<PersonAndHobbyEntity, String> {

    List<PersonAndHobbyEntity> findByHobby (String hobby);

}
