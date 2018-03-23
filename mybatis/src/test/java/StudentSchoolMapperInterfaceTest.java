
import com.kaishengit.entity.Student;
import com.kaishengit.entity.Tag;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentSchoolMapperInterfaceTest {

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testFindById(){

        Student student = studentMapper.findById(2);
        System.out.println(student);
    }
    @Test
    public void testFindId(){

        Student student = studentMapper.findId(2);
        System.out.println(student);
    }

    @Test
    public void testFindAll(){

        List<Student> studentList = studentMapper.findAll();
        for(Student student : studentList){
            System.out.println(student);
        }
    }


    @Test
    public void testfindByIdTag(){

        Student student = studentMapper.findByIdTag(2);
        System.out.println(student);
        List<Tag> tagList = student.getTagList();
        for (Tag tag : tagList){
            System.out.println(tag);
        }

    }

    @After
    public void destory(){
        sqlSession.close();
    }


}

