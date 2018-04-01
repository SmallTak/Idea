package service;

import com.kaishengit.service.OtherService;
import com.kaishengit.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {

    @Test
    public void studentServiceTest(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioctest.xml");
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
        studentService.save();

      /*  OtherService otherService = (OtherService) applicationContext.getBean("otherService");
        otherService.show();*/

    }


}
