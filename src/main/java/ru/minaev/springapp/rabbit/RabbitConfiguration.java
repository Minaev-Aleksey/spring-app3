package ru.minaev.springapp.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    private static final String QUEUE_NAME  = "firstQueue";
    private static final String EXCHANGE_NAME  = "testExchange";

    @Bean
    public Queue myQueue (){ return new Queue(QUEUE_NAME, true );
    }

    @Bean
    Exchange exchange (){
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("first.key").noargs();
    }
}