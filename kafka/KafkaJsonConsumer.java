package com.interntraining.kafkalearning.kafka;

import com.interntraining.kafkalearning.model.UserClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "trainingTopic2", groupId = "vvcesustenance1")
    public void consume(UserClass userClass){
        logger.info(String.format("Json message recieved -> %s",userClass.toString()));
    }

}
