import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
/*
 *
 * @author 周云飞
 * @date 2018/3/26
 */
public class MovieExampleCaseText {

    private SqlSession sqlSession;
    private MovieMapper movieMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }
    @After
    public void destory(){
        sqlSession.close();
    }
    @Test
    public void insert(){
        Movie movie = new Movie();
        movie.setTitle("不再犹豫");
        movie.setRate(9.0f);
        movie.setReleaseYear("2001");

        //下面这种插入形式的values很全
//        int num = movieMapper.insert(movie);
        //这种插入的values则只有三个
        int num = movieMapper.insertSelective(movie);
        System.out.println(num);
    }
    @Test
    public void findById(){
        Movie movie = movieMapper.selectByPrimaryKey(132);
        System.out.println(movie);
    }
    @Test
    public void findListOr(){
        MovieExample example = new MovieExample();

        example.createCriteria().andDirectorLike("%大%").;
        //查看2017~2018之间评分再大于等于9.6的影视
//        example.or().andRateGreaterThanOrEqualTo(9.6f);
//        example.or().andReleaseYearBetween("2017","2018");

        example.or().andRateGreaterThanOrEqualTo(9.6f);
        example.or().andReleaseYearEqualTo("2017");
        //去重复
        example.setDistinct(true);
        //排序规则
        example.setOrderByClause("release_year desc");
        List<Movie> movieList = movieMapper.selectByExample(example);
        for (Movie movie : movieList){
            System.out.println(movie);
        }
    }
    @Test
    public void findListByDriector(){
        MovieExample example = new MovieExample();
        //查找卡梅隆导演的电影评分在9.0以上的包括9.0
        example.createCriteria().andDirectorLike("%卡梅隆%").andRateGreaterThanOrEqualTo(9.0f);


        List<Movie> movieList = movieMapper.selectByExample(example);
        for (Movie movie : movieList){
            System.out.println(movie);
        }
    }
    @Test
    public void findAll(){
        MovieExample example = new MovieExample();
        List<Movie> movieList = movieMapper.selectByExample(example);
        for (Movie movie : movieList){
            System.out.println(movie);
        }
    }
    @Test
    public void page(){
//        PageHelper.offsetPage(1,10);
        PageHelper.startPage(1,10);
        MovieExample example = new MovieExample();
        List<Movie> movieList = movieMapper.selectByExample(example);
//        for (Movie movie : movieList){
//            System.out.println(movie);
//        }
        PageInfo<Movie> pageInfo = new PageInfo<>(movieList);
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getPages());
    }
    @Test
    public void updateById() {
        Movie movie = movieMapper.selectByPrimaryKey(776);
        movie.setRate(9.1F);
        movieMapper.updateByPrimaryKey(movie);
    }
    @Test
    public void UpdateByDirector(){
        MovieExample example = new MovieExample();
        example.createCriteria().andDirectorLike("%周星驰%");
        Movie movie = new Movie();
        movie.setReleaseYear("2019");
        movieMapper.updateByExampleSelective(movie,example);
    }

}
