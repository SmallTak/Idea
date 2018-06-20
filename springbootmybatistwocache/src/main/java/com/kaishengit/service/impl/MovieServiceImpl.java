package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.cache.RedisCacheHelper;
import com.kaishengit.controller.exception.NotFountException;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    public static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private RedisCacheHelper redisCacheHelper;

    @Autowired
    private MovieMapper movieMapper;

    /**
     * 查找所有的电影
     *
     * @Author Reich
     * @Date: 2018/6/18 21:59
     */
    @Override
    public PageInfo<Movie> findAllMovie(Integer pageNo) {
        PageHelper.startPage(pageNo, 10);
        return new PageInfo<>(movieMapper.selectByExample(new MovieExample()));
    }

    /**
     * 新增电影
     *
     * @param movie
     * @Author Reich
     * @Date: 2018/6/19 10:27
     */
    @Override
    public void insertMovie(Movie movie) {
       movieMapper.insertSelective(movie);
       logger.info("保存角色 {}",movie);
    }

    /**
     * 通过id查找movie
     *
     * @param id
     * @Author Reich
     * @Date: 2018/6/19 10:58
     */
    @Override
    @Cacheable
    public Movie findmoviebyid(Integer id) {

        String movieKey = "movie" + id;
        Movie movie = (Movie) redisCacheHelper.get(movieKey, Movie.class);
        if (movie == null){
            movie = movieMapper.selectByPrimaryKey(id);
            redisCacheHelper.set(movieKey, movie, 10);
            logger.info("查找电影 {}",movie);
            return movie;
        }

        return movie;
    }

    /**
     * 修改电影信息
     *
     * @param movie
     * @Author Reich
     * @Date: 2018/6/20 16:33
     */
    @Override
    public void updateMovie(Movie movie) {
        movieMapper.updateByPrimaryKeySelective(movie);
    }

    /**
     * 根据id删除电影
     *
     * @param id
     * @Author Reich
     * @Date: 2018/6/20 16:48
     */
    @Override
    public void delMovieById(Integer id) {
        Movie movie = movieMapper.selectByPrimaryKey(id);
        if (movie == null){
            throw new NotFountException();
        }

    }

    /**
     * 通过导演查找电影
     *
     * @param director
     * @Author Reich
     * @Date: 2018/6/20 22:47
     */
    @Override
    public List<Movie> findMovieByDirector(String director) {
        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria().andTitleEqualTo(director);
        List<Movie> movieList = movieMapper.selectByExample(movieExample);
        return movieList;
    }
}
