package com.kaishengit.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.springbootdemo.entity.Movie;

public interface MovieService {

    /** 通过id查找单个电影
     *
     * @Author Reich
     * @Date: 2018/5/10 17:23
     */
    Movie selectMovieById(Integer id);

    /**查找所有电影 并使用分页
     *
     * @Author Reich
     * @Date: 2018/5/10 17:51
     */
    PageInfo<Movie> findAllMovie(Integer pageNo);
}



