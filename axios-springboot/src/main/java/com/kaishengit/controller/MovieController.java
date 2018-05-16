package com.kaishengit.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {

    @GetMapping("/{id}")
    public Map<String,String> getMovie(@PathVariable Integer id) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "阿甘正传");
        map.put("rate", "9.5");
        map.put("author", "Jack");
        return map;
    }
}
