package com.kaishengit.movie;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import org.springframework.stereotype.Service;


public interface MovieService {
    /**查询所有电影并分页h
     *
     * @Author Reich
     * @Date: 2018/5/17 13:07
     */
    PageInfo<Movie> findAllMovie(Integer pageNo);

    /**添加电影
     *
     * @Author Reich
     * @Date: q 15:31
     */
    void addMovie(Movie movie);

    /**通过id查找电影
     *
     * @Author Reich
     * @Date: 2018/5/17 16:41
     */
    Movie selectMovie(Integer id);

    /**更新电影
     *
     * @Author Reich
     * @Date: 2018/5/17 16:57
     */
    void updateMovie( Movie movie);

    /**删除movie
     *
     * @Author Reich
     * @Date: 2018/5/17 17:45
     */
    void delMovie(Integer id);
}
