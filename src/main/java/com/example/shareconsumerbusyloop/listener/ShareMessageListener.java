package com.example.shareconsumerbusyloop.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ShareMessageListener {

    @KafkaListener(
            topics = "my-queue-topic",
            containerFactory = "shareKafkaListenerContainerFactory",
            groupId = "my-share-group"
    )
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received from queue: " + record.value());
        // Record is automatically acknowledged with ACCEPT
    }
}
