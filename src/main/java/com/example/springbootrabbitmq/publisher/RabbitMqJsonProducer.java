package com.example.springbootrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.springbootrabbitmq.dto.User;

@Service
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);

    @Autowired
    private RabbitTemplate template;

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent -> %s", user.toString()));
        template.convertAndSend(exchange, jsonRoutingKey, user);
    }
}
