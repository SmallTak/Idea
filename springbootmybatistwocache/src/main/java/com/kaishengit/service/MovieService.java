package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;

public interface MovieService {

    /**查找所有的电影
     *
     * @Author Reich
     * @Date: 2018/6/18 21:59
     */
    PageInfo<Movie> findAllMovie(Integer page);

    /**新增电影
     *
     * @Author Reich
     * @Date: 2018/6/19 10:27
     */
    void insertMovie(Movie movie);

    /**通过id查找movie
     *
     * @Author Reich
     * @Date: 2018/6/19 10:58
     */
    Movie findmoviebyid(Integer id);
}
