package com.kaishengit.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MOVIE-SERVICE-PROVIDER")
public interface MovieServiceClient {

    @GetMapping("/movie/{id}")
    String getMovieName(@PathVariable(name = "id") Integer id);

}
