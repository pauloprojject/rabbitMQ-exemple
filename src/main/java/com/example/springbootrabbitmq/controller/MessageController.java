package com.example.springbootrabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrabbitmq.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    
    @Autowired
    private RabbitMqProducer producer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("message sent to rabbitMQ");
    }
}
