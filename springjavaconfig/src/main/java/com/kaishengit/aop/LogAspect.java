package com.kaishengit.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect    //该注解表示为通知类
public class LogAspect {

    @Pointcut("execution(* com.kaishengit.service.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " before Advice");
    }
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " afterReturning Advice ->" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " afterReturning Advice ->" + e.getMessage());
    }

    @After(value = "pointcut()")
    public void  after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " after Advice");
    }

    @Around("pointcut()")
    public Object aroundAdivce(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
