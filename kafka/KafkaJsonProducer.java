package com.interntraining.kafkalearning.kafka;

import com.interntraining.kafkalearning.model.UserClass;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, UserClass> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, UserClass> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    } //when one parameterized constructor no need to @Autowire this is an update after spring 4....some version

    public void sendMessage(UserClass data){
        logger.info(String.format("Message sent ->%s",data.toString()));
        Message<UserClass> msg = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"trainingTopic2")
                .build();

        kafkaTemplate.send(msg);
    }
}
