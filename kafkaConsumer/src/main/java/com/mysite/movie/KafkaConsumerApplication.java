package com.mysite.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KafkaConsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }
}
