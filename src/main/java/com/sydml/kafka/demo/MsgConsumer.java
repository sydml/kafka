package com.sydml.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class MsgConsumer {
   private static final Logger logger = LoggerFactory.getLogger(MsgConsumer.class);

    @KafkaListener(topics = "test-topic", containerFactory = "kafkaListenerContainerFactory")
    public void processMsg(ConsumerRecord<?, ?> record) {
        logger.info("消费者开始消费 {}|{}|{}|{}", record.topic(), record.partition(), record.offset(), record.value());
    }
}
