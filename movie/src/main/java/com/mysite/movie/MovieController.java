package com.mysite.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/movie")
public class MovieController {
    @Autowired
    MovieServices movieServices;

    @Autowired
    KafkaServices kafkaServices;
    @PostMapping
    public String movieCheck(@RequestBody MovieReq movieRequest){
        System.out.println(movieRequest);
        log.info("Sprawdzam film " + movieRequest.title());

        if (!movieRequest.email().isEmpty()){
            kafkaServices.sendKafkaMessage(movieRequest.email());
        }

        return movieServices.saveMovie(movieRequest);
    }
}
