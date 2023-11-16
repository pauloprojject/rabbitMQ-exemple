package com.example.springbootrabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrabbitmq.dto.User;
import com.example.springbootrabbitmq.publisher.RabbitMqJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    
    @Autowired
    private RabbitMqJsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to rabbitMQ");
    }
}
