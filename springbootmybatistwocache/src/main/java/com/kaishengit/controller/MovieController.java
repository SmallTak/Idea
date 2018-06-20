package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.controller.exception.NotFountException;
import com.kaishengit.controller.result.ResponseBean;
import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String Home(@RequestParam(required = false, name = "p", defaultValue = "1") Integer pageNo, Model model){
       PageInfo<Movie> pageInfo = movieService.findAllMovie(pageNo);
       model.addAttribute("pag",pageInfo.getTotal());
       model.addAttribute("pageInfo", pageInfo);
       return "movie/home";
    }




    @GetMapping("/{id}")
    public String movieEdit(@PathVariable Integer id, Model model){
        Movie movie = movieService.findmoviebyid(id);
        model.addAttribute("movie", movie);
        return "movie/detail";
    }

    @GetMapping("/{id}/edit")
    public String editMovie(@PathVariable Integer id, Model model){
        Movie movie = movieService.findmoviebyid(id);
        model.addAttribute("movie", movie);
        return "movie/edit";
    }

    @PostMapping("/{id}/edit")
    public String editMovie(Movie movie){
        movieService.updateMovie(movie);
        return "redirect:/movie";
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

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delMovie(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            movieService.delMovieById(id);
            return ResponseBean.success();
        }catch (NotFountException e){
            return ResponseBean.error(e.getMessage());
        }

    }

}



