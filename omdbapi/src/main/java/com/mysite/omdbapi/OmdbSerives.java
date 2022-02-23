package com.mysite.omdbapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbSerives {
    private final String APIKEY = "76fc1cff";
    private final String URL = "http://www.omdbapi.com/?apikey=" + APIKEY + "&t=";

    public OmdbResponse apiRequestMovie(String movie){

        RestTemplate restTemplate = new RestTemplate();
        OmdbResponse response = restTemplate.getForObject(URL + movie, OmdbResponse.class);
        System.out.println(response);
        System.out.println(response.imdbRating);
        return response;
    }
}
