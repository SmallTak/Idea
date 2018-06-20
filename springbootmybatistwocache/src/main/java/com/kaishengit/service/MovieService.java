package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;

import java.util.List;

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

    /**修改电影信息
     *
     * @Author Reich
     * @Date: 2018/6/20 16:33
     */
    void updateMovie(Movie movie);

    /**根据id删除电影
     *
     * @Author Reich
     * @Date: 2018/6/20 16:48
     */
    void delMovieById(Integer id);

    /**通过导演查找电影
     *
     * @Author Reich
     * @Date: 2018/6/20 22:47
     */
    List<Movie> findMovieByDirector(String director);
}
