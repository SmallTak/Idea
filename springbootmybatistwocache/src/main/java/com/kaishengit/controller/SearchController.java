package com.kaishengit.controller;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String searchMovie(@RequestParam(required = false) String director, Model model){
        List<Movie> movieList = movieService.findMovieByDirector(director);
        model.addAttribute("movieList", movieList);
        return "movie/directorMovie";
    }

}
