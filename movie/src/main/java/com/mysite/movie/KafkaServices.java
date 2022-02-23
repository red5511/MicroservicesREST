package com.mysite.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServices {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private final String kafkaTopic = "first_kafka_topic";

    public void sendKafkaMessage(String msg){
        kafkaTemplate.send(kafkaTopic, msg);
    }
}
