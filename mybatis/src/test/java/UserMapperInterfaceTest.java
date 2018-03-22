import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperInterfaceTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init(){

        //true为自动提交事务
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        //动态代理 动态生成
        userMapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("胡歌");
        user.setAge(23);
        user.setPhoneNum("010777");

      userMapper.save(user);
      int id = user.getId();
        System.out.println(id);

    }

    @Test
    public void testFindByid(){

        User user = userMapper.findByid(2);
        System.out.print(user);

    }

    @Test
    public void testFindAll(){

        List<User> userList = userMapper.findAll();
        for (User user : userList){
            System.out.println(user);
        }

    }

    @Test
    public void testUpload(){
        User user = userMapper.findByid(5);
        user.setUserName("王菲");
        user.setPhoneNum("13461346731");
        int num = userMapper.update(user);
        System.out.println(num);

    }

    @Test
    public void testDel(){

       int num =  userMapper.delById(23);
        System.out.println(num);

    }

    @Test
    public void testFindPage(){

        Map<String, Integer> map = new HashMap<>();
        map.put("start", 0);
        map.put("size", 3);
        List<User> userList = userMapper.page(map);
        for (User user : userList){
            System.out.println(user);
        }

    }

    @Test
    public void testFindPage2(){

        List<User> userList = userMapper.page2(0,3);
        for (User user : userList){
            System.out.println(user);
        }

    }

    @Test
    public void testFindPage3(){

        List<User> userList = userMapper.page3(0,3);
        for (User user : userList){
            System.out.println(user);
        }

    }

    @After
    public void destory(){
        sqlSession.close();
    }

}
