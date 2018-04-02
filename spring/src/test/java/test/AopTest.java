package test;

import com.kaishengit.proxy.Player;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void aopTest(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop.xml");
        Player player = (Player) applicationContext.getBean("mp3");
        player.play("离人");
        System.out.println("------------------------");
        player.stop();
    }

}
