package test;

import com.kaishengit.proxy.Sales;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import sun.misc.Cache;

import java.lang.reflect.Method;

public class SalesTest {

    @Test
    public void salesTest(){

        Enhancer enhancer = new Enhancer();
        //设置目标对象
        enhancer.setSuperclass(Sales.class);
        //设置代理对象的代理行为
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 添加代理行为
             * @param target 目标对象
             * @param method 目标的方法 一般不用
             * @param args 方法的参数
             * @param methodProxy 产生的子类方法代理
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                try {
                    System.out.println("test beFore...");
                    //执行父类中的方法
                    Object result = methodProxy.invokeSuper(target,args);
                    System.out.println("test after ...");
                    return result;
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Exception ...");
                    return null;
                }finally {
                    System.out.println("FinallyAdvice ...");
                }
            }
        });
        //产生代理对象
        Sales sales = (Sales) enhancer.create();
        sales.sale();


    }

}
