package com.interntraining.kafkalearning.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //this annotation was made by spring to subscribe to a topic
    @KafkaListener(topics = "trainingTopic1", groupId = "vvcesustenance1")
    public void consumeMessage(String msg){
        logger.info(String.format("Message recieved -> %s", msg));
    }
}
