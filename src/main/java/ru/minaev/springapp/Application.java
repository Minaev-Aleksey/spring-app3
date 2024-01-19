package ru.minaev.springapp;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SpringBootApplication
public class Application {

    static final String QUEUE_NAME = "firstQueue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void Listen(String message) {
        System.out.println("Message read from firstQueue " + message);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}