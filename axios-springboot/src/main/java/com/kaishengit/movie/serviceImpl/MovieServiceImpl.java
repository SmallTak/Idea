package com.kaishengit.movie.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.movie.MovieService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    /**
     * 查询所有电影并分页
     *
     * @param pageNo
     * @Author Reich
     * @Date: 2018/5/17 13:07
     */
    @Override
    public PageInfo<Movie> findAllMovie(Integer pageNo) {
        PageHelper.startPage(pageNo, 9);
        List<Movie> movieList = movieMapper.selectByExample(new MovieExample());
        return new PageInfo<>(movieList);
    }

    /**
     * 添加电影
     *
     * @param movie
     * @Author Reich
     * @Date: q 15:31
     */
    @Override
    public void addMovie(Movie movie) {


//        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
//        DateTime dateTime = dateTimeFormat.parseDateTime(movie.getReleaseYear());
//        movie.setReleaseYear(String.valueOf(dateTime.getYear()));
//
//        DateTime sendDate = dateTimeFormat.parseDateTime(movie.getSendTime());
//        movie.setSendTime(sendDate.toString());
        movieMapper.insert(movie);
    }

    /**
     * 通过id查找电影
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/17 16:41
     */
    @Override
    public Movie selectMovie(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新电影
     *
     * @param
     * @Author Reich
     * @Date: 2018/5/17 16:57
     */
    @Override
    public void updateMovie(Movie movie) {

        movieMapper.updateByPrimaryKeySelective(movie);

    }

    /**
     * 删除movie
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/17 17:45
     */
    @Override
    public void delMovie(Integer id) {

        movieMapper.deleteByPrimaryKey(id);

    }
}
