package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MovieMapper {

    /*参数类型为String，参数最好加注解@param("title")*/
    List<Movie> findByTitle(@Param("title") String title);
    List<Movie> findByParams(Map<String, Object> params);
    List<Movie> findByIdList(List<Integer> idList);
    void addMovie(List<Movie> list);

}
