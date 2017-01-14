package com.omegapoint.latetuna.eventbus.client;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class EventClient {

    private final Producer<String, String> producer;

    public EventClient() {
        producer = createProducer();
    }

    public void send(String topic, String key, String value) {
        System.out.println(topic);
        producer.send(new ProducerRecord<String, String>(topic, key, value));
        producer.flush();
    }

    private Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092");
//        props.put("acks", "all");
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer<>(props);
    }
}