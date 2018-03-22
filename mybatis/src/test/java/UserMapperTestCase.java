import com.kaishengit.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;

public class UserMapperTestCase {

    @Test
    public void testFindById()throws Exception{

        //加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        //创建sqlsessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

        //创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //操作数据库
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findByid",1);
        System.out.println(user);

        //关闭sqlsession
        sqlSession.close();
    }

}
