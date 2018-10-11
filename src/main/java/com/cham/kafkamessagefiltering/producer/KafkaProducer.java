package com.cham.kafkamessagefiltering.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.tweet}")
    private String topic;

    public void send(String message){
        System.out.println("sending message to topic " + message);
        kafkaTemplate.send(topic, message);
    }
}
