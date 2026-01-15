package com.example.shareconsumerbusyloop;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaShareConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ShareConsumerBusyLoopApplication {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
        props.put("group.id", "test-group");  // Shared consumer group ID
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        try (KafkaShareConsumer<String, String> consumer = new KafkaShareConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList("your-topic"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                // Do nothing
            }
        }
    }
}
