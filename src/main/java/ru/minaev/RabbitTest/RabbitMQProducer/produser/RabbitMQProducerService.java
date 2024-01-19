package ru.minaev.RabbitTest.RabbitMQProducer.produser;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);
}