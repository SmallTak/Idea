package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.controller.resoult.ResponseBean;
import com.kaishengit.entity.Movie;
import com.kaishengit.movie.MovieService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseBean getMovie(@RequestParam(required = false, name = "p", defaultValue = "1") Integer pageNo) {
        PageInfo<Movie> pageInfo = movieService.findAllMovie(pageNo);
        return ResponseBean.success(pageInfo);
    }

    @PostMapping("/new")
    public  ResponseBean addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseBean.success();
    }

    @GetMapping("/{id}")
    public ResponseBean selectMovie(@PathVariable Integer id){
        Movie movie = movieService.selectMovie(id);
        return ResponseBean.success(movie);
    }

    @PutMapping("/{id}")
    public ResponseBean upodateMovie(@RequestBody Movie movie){
        movieService.updateMovie(movie);
        return  ResponseBean.success();
    }

    @DeleteMapping("/{id}")
    public ResponseBean delMovie(@PathVariable Integer id){
        movieService.delMovie(id);
        return ResponseBean.success();
    }

}
