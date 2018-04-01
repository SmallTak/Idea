package test;

import com.kaishengit.proxy.Mp3;
import com.kaishengit.proxy.Mp3AdProxy;
import com.kaishengit.proxy.Mp3LogProxy;
import com.kaishengit.proxy.Player;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Mp3Test {

    @Test
    public void test(){

        Mp3 mp3 = new Mp3();
        Mp3LogProxy mp3LogProxy = new Mp3LogProxy(mp3);
        Mp3AdProxy mp3AdProxy = new Mp3AdProxy(mp3LogProxy);
        mp3AdProxy.play("You");
        //mp3.stop();
    }

    @Test
    public void test1(){


        final Mp3 mp3 = new Mp3();
        //获取目标对象的加载器
        ClassLoader loader = mp3.getClass().getClassLoader();
        //目标对象的接口数组
        Class[] classes = mp3.getClass().getInterfaces();

        Player player =(Player) Proxy.newProxyInstance(loader, classes, new InvocationHandler() {

             /**
             * 代理对象执行的方法
             * @param proxy 正在执行的代理对象，没什么用
             * @param method 客户端调用的方法（目标对象的方法）
             * @param args 方法的参数列表
             * @return 方法返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获得正在执行的方法名
                String methodName = method.getName();
                System.out.println("方法:"+methodName+"开始调用");
                //调用目标对象的方法
                Object result = method.invoke(mp3,args);
                System.out.println("方法:"+methodName+"调用结束");
                return result;
            }
        });

        player.play("You");
    }

}
