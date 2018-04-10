import com.kaishengit.entity.Movie;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class MovieMapperTest {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;

    @Before
    public void intit(){

        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }
    @After
    public void destory(){
        sqlSession.close();
    }

    @Test
    public void findAll(){
        List<Movie> movieList = movieMapper.findAll();
        for (Movie movie : movieList){
        System.out.println(movie);
    }
}

    @Test
    public void findByTitle(){

        List<Movie> movieList = movieMapper.findByTitle("%大话西游%");
        for (Movie movie : movieList){
            System.out.println(movie);
        }

    }
    @Test
    public void findByIdList(){

        List<Integer> idList = Arrays.asList(123,321,222);
        List<Movie> movieList = movieMapper.findByIdList(idList);
        for (Movie movie : movieList){
            System.out.println(movie);
        }
    }

    @Test
    public  void findByTitleAndDirector(){
        String title = "";//"%大话西游%";
        String director = "%周星驰%";

        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("director", director);
        List<Movie> movieList = movieMapper.findByParams(params);
        for (Movie movie : movieList){
            System.out.println(movie);
        }
    }

    @Test
    public void addMovie(){
        List<Movie> list = new ArrayList<>();
        Movie movie = new Movie();
        movie.setTitle("千与千寻");
        movie.setDirector("宫崎骏");
        movie.setRate(9.1F);

        Movie movie2 = new Movie();
        movie2.setTitle("龙猫");
        movie2.setDirector("宫崎骏");
        movie2.setRate(8.9F);
        list.add(movie);
        list.add(movie2);

        movieMapper.addMovie(list);
    }


}
