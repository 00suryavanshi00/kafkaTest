package com.interntraining.kafkalearning.controller;

import com.interntraining.kafkalearning.kafka.KafkaJsonProducer;
import com.interntraining.kafkalearning.model.UserClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {
    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody UserClass curruser){
        kafkaJsonProducer.sendMessage(curruser);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }
}
