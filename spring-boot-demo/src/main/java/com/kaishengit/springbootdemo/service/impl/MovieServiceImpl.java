package com.kaishengit.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.kaishengit.springbootdemo.cache.RedisCacheHelper;
import com.kaishengit.springbootdemo.entity.Movie;
import com.kaishengit.springbootdemo.mapper.MovieMapper;
import com.kaishengit.springbootdemo.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    /*@Autowired
    private RedisTemplate redisTemplate;
*/
    @Autowired
    private RedisCacheHelper redisCacheHelper;

    private Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

/*
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Movie.class));
//        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }
*/

    /**
     * 通过id查找单个电影
     *
     * @Author Reich
     * @Date: 2018/5/10 17:23
     */
    @Override
    @Cacheable("movie")
    public Movie selectMovieById(Integer id) {
        //使用本地缓存是释放
        return movieMapper.selectMairById(id);

        //使用redisCacheHelper工具类
        /*String movieKey = "movie" + id;
        Movie movie = (Movie) redisCacheHelper.get(movieKey, Movie.class);
        if (movie == null){
            movie = movieMapper.selectMairById(id);
            redisCacheHelper.set(movieKey, movie, 10);
            return movie;
        }
        return movie;*/

       /* String movieKey = "movie" + id;
        Movie movie = null;
        if (redisTemplate.opsForValue().get(movieKey) ==  null){
           movie = movieMapper.selectMairById(id);
//           redisTemplate.opsForValue().set(movieKey, new Gson().toJson(movie));
            redisTemplate.opsForValue().set(movieKey, movie);
        }else {
            String json = (String) redisTemplate.opsForValue().get(movieKey);
            movie = new Gson().fromJson(json, Movie.class);
        }
        return movie;*/
    }

    /**
     * 查找所有电影 并使用分页
     *
     * @param pageNo
     * @Author Reich
     * @Date: 2018/5/10 17:51
     */
    @Override
    public PageInfo<Movie> findAllMovie(Integer pageNo) {
        PageHelper.startPage(pageNo,10);
        List<Movie> movies = movieMapper.findAllMovie();
        return new  PageInfo<>(movies);
    }

    /** 热数据
     *
     * @Author Reich
     * @Date: 2018/5/11 10:49
     */
 /*   @PostConstruct
    public void initCache(){

        Movie movie = movieMapper.selectMairById(143);
        String movieKey = "movie" + movie.getId();
        redisCacheHelper.set(movieKey, movie, 10);
        logger.info("init {} product in cache ",2177);

    }
*/
}
