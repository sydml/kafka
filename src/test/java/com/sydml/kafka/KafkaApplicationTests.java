package com.sydml.kafka;

import com.sydml.kafka.demo.MsgProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaApplicationTests {
    @Autowired
    private MsgProducer msgProducer;
    @Test
    void contextLoads() {
        msgProducer.send("test-message");
    }

}
