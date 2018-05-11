package com.kaishengit.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.springbootdemo.entity.Movie;
import com.kaishengit.springbootdemo.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public Movie query(@PathVariable Integer id){
        return movieService.selectMovieById(id);
    }

    @GetMapping
    public PageInfo<Movie> fingAllMovie(@RequestParam(required = false,defaultValue = "1", name = "p")Integer pageNo){
        PageInfo<Movie> pageInfo = movieService.findAllMovie(pageNo);
        logger.info("查询全部电影：{}",pageInfo.getList().size());
        return pageInfo;
    }

}
