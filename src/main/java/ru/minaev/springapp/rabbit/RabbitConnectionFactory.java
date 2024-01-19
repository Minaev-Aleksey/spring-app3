//package ru.minaev.springapp.rabbit;
//
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.ConnectionFactory;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.FieldDefaults;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@EnableRabbit
//@Getter
//@Setter
//@Component
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class RabbitConnectionFactory {
//
//    @Value("${spring.rabbitmq.username}")
//    String userName;
//    @Value("${spring.rabbitmq.password}")
//    String password;
//    @Value("${spring.rabbitmq.host}")
//    String hostName;
//    @Value("${spring.rabbitmq.virtual-host}")
//    String virtualHost;
//    @Value("${spring.rabbitmq.port}")
//    Integer portNumber;
//
////
////ConnectionFactory factory = new ConnectionFactory();
////factory.setUserame(userName);
////factory.setPassword(password);
////factory.setVirtualHost(virtualHost);
////factory.setHost(hostName);
////factory.setPort(portNumber);
////
////    Connection conn;
//
//}
