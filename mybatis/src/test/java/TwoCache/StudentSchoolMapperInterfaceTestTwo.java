package TwoCache;

import com.kaishengit.entity.Student;

import com.kaishengit.mapper.StudentMapperTwo;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentSchoolMapperInterfaceTestTwo {

    private SqlSession sqlSession;
    private StudentMapperTwo studentMapperTwo;
    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        studentMapperTwo = sqlSession.getMapper(StudentMapperTwo.class);
    }

    @Test
    public void testFindById(){

        Student student = studentMapperTwo.findById(2);
        System.out.println(student);
    }

    @Test
    public void testFindAll(){

        List<Student> studentList = studentMapperTwo.findAll();
        for (Student student : studentList){
            System.out.println(student);
        }
//
    }

    @After
    public void destory(){
        sqlSession.close();
    }


}

