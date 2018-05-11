package com.kaishengit.springbootdemo.mapper;

import com.kaishengit.springbootdemo.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {


    Movie selectMairById(Integer id);

    List<Movie> findAllMovie();

}
