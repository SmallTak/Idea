package com.kaishengit.controller;

import com.kaishengit.service.MovieService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Version;

@RestController
public class MovieController {

    @Reference(version = "1.0")
    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public String getMovieName(@PathVariable Integer id){
        return movieService.findMovieNameById(id);
    }

}
