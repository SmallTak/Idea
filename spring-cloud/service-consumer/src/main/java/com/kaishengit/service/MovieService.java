package com.kaishengit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {


    @Autowired
    private RestTemplate template;
    //演示hystrix
    public String getMovieNameById(Integer id){

        String url = "http://MOVIE-SERVICE-PROVIDER/movie/{1}";
        return template.getForObject(url, String.class,id);

    }

}
