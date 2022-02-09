package com.sydml.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {
    private static final Logger logger = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String value){
        logger.info("send start-----------");
        kafkaTemplate.send("test-topic", value+"1");
        kafkaTemplate.send("test-topic", "key1", value+"2");
        logger.info("send end-----------");
    }
}

