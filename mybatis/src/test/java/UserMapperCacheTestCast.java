import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

public class UserMapperCacheTestCast {

    @Test
    public void testFindById(){
        /* mybaits默认开始一级缓存，在同一个sqlsession中查询同一个对象多次，只有第一次是从数据库中获得的数据，其他都是从缓存中获取的 */

       /* SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByid(1);
        System.out.println(user);
        User user1 = userMapper.findByid(1);
        System.out.println(user1);
        sqlSession.close();*/

       /*二级缓存
       *   将被缓存的对象序列化，注意的是属性也必须序列化
       *   在mapper.xml中添加<cache/>节点
       *   二级缓存再同一个sqlsessionFactory生产的sqlsession之间是共享的*/
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByid(1);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession1 = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

        User user1 = userMapper1.findByid(1);
        System.out.println(user1);

        sqlSession.close();
    }

}
