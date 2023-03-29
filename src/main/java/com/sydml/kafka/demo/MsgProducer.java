package com.sydml.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@EnableScheduling
public class MsgProducer {
    private static final Logger logger = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicInteger atomicIntegerMax = new AtomicInteger(100);

    public void send(String value){
        logger.info("send start-----------");
        kafkaTemplate.send("test-topic", value);
        kafkaTemplate.send("test-topic", "key1", value+"2");
        logger.info("send end-----------");
    }

    @Scheduled(fixedDelay = 1000)
    public void send() {
        logger.info("send start-----------");
        kafkaTemplate.send("test", "test "+atomicInteger.getAndIncrement());
        kafkaTemplate.send("test", "key1", "test " + atomicIntegerMax.incrementAndGet());
        logger.info("send end-----------");
    }
}

