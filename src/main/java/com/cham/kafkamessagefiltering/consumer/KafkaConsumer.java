package com.cham.kafkamessagefiltering.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${app.topic.tweet}")
    public void receive(String payload){
        System.out.println("Received message.. " + payload);
    }
}
