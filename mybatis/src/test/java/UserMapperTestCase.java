import com.kaishengit.entity.User;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.Reader;
import java.security.PublicKey;
import java.util.List;

public class UserMapperTestCase {

    private  SqlSession sqlSession;

    @Before
    public void init(){
        //自动提交事务，在程序运行的时候通过SqlSessionFactoryUtil获得sqlSession
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
    }

    @Test
    public void testFindById()throws Exception{

        //操作数据库
        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findByid",2);
        System.out.println(user);
    }
    @Test
    public void testFindAll()throws Exception{

        //操作数据库
        List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
        for (User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void testsave()throws Exception{

        User user = new User();
        user.setUserName("赵小红");
        user.setAge(22);
        user.setPhoneNum("12332123");
        //操作数据库
        sqlSession.insert("com.kaishengit.mapper.UserMapper.save", user);
//        若在SqlSessionFactoryUtil中的getSqlSession方法中不设置自动提交则需要手动提交
//        sqlSession.commit();
//        sqlSession.rollback();  回滚
    }

    @Test
    public void testSave()throws Exception{

       User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findByid",4);
       user.setUserName("狗子");
       user.setAge(21);
       //操作数据库
        sqlSession.update("com.kaishengit.mapper.UserMapper.update", user);
    }

    @Test
    public void testDel()throws Exception{

        //操作数据库
        sqlSession.delete("com.kaishengit.mapper.UserMapper.delById", 6);
    }

    @After
    public void destroy(){
        sqlSession.close();
    }

}
