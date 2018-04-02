package com.kaishengit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.management.ObjectName;
import java.util.Arrays;

public class MyAdvice {

//    public void beforeAdvice(JoinPoint joinPoint){
//        //方法的名称
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println(methodName +  " 前置通知" + Arrays.asList(args));
//    }
//    public void afterAdvice(Object result){
//        System.out.println( "后置通知"  +  result);
//    }
//    public void exceptionAdvice(Exception e){
//        System.out.println("异常通知" + e.getMessage());
//    }
//    public void  finallyAdvice(){
//        System.out.println("最终通知");
//    }

    //环绕通知方法
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object result = null;

        try {
            System.out.println("Start...");
            result = joinPoint.proceed();
            System.out.println("after...");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Error...");
        } finally {
            System.out.println("End...");
        }

        return result;
    }

}
