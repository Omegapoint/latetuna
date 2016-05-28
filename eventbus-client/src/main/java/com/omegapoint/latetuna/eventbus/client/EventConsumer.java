package com.omegapoint.latetuna.eventbus.client;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class EventConsumer {

    private final KafkaConsumer<String, String> consumer;

    public EventConsumer(String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092");
        props.put("group.id", "consumer-tutorial");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));
    }

	public void consumeNewEvents() {
//        try {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(record.offset() + ": " + record.key() + " - " + record.value());
			}
//        } finally {
//            consumer.close();
//        }
    }
}
