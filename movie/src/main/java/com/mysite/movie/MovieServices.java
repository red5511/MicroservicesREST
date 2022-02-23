package com.mysite.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MovieServices {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MovieRepo movieRepo;
    public String saveMovie(MovieReq movieRequest){
        String url = "http://OMDBAPI:8081/api/omdb/";
        OmdbResponse omdbResponse = restTemplate.postForObject(url, movieRequest, OmdbResponse.class);
        log.info("Odbieram dane: tytul - {}, rating - {}", omdbResponse.title, omdbResponse.imdbRating);

        if (!omdbResponse.title.isEmpty())
        {
            Movie movie = Movie.builder().title(movieRequest.title()).rating(Double.parseDouble(omdbResponse.imdbRating)).build();
            movieRepo.save(movie);
            System.out.println(movie);
        }

        if (!omdbResponse.imdbRating.isEmpty()) {
            if (Double.parseDouble(omdbResponse.imdbRating) > 5)
                return "Polecamy film " + omdbResponse.title + " jako że otrzymał satysfakcjonujaca ocene uzytkownikow rowna " + omdbResponse.imdbRating;
            else return "Nie polecamy filmu " + omdbResponse.title + " jako że otrzymał niesatysfakcjonujaca ocene uzytkownikow rowna " + omdbResponse.imdbRating;

        }

        return "Brak danych w bazie";
    }
}
