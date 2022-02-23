package com.mysite.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {
    @Autowired
    MailServices mailServices;

    @KafkaListener(topics = "first_kafka_topic", groupId = "groupId")
    void listener(String data){
      log.info("Odbieram dane w kafka listener {}", data);
      mailServices.sendEmail(data);

    }
}
