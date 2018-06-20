package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String Home(@RequestParam(required = false, name = "p", defaultValue = "1") Integer pageNo, Model model){
       PageInfo<Movie> pageInfo = movieService.findAllMovie(pageNo);
       model.addAttribute("page", pageInfo);
        return "movie/home";
    }

    @GetMapping("/{id}")
    public String movieEdit(@PathVariable Integer id, Model model){
        Movie movie = movieService.findmoviebyid(id);
        model.addAttribute("movie", movie);
        return "movie/edit";
    }

    @GetMapping("/new")
    public String addMovie(){
        return "movie/new";
    }
    @PostMapping("/new")
    public String addMovie(Movie movie){
        movieService.insertMovie(movie);
        return "redirect:/movie";
    }

}



