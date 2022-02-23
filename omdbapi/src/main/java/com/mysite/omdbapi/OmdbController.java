package com.mysite.omdbapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/omdb")
@Slf4j
public class OmdbController {

    @Autowired
    private OmdbSerives omdbSerives;


    @PostMapping()
    public OmdbResponse omdbApiRequest(@RequestBody MovieReq movie){
        log.info("Sprawdzam film {}", movie);
        OmdbResponse response = omdbSerives.apiRequestMovie(movie.title());

        return response;
    }

}
