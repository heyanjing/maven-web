package com.he.spring.aop;

import com.he.spring.util.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heyanjing on 2017/5/19 14:29.
 */
@Component
@Aspect
public class ServiceAspect {
    private static final Logger log = Logs.getLogger(ServiceAspect.class);

    @Pointcut("execution(* com.he.spring.service..*.*(..))")
    public void pointcut() {
    }
    //在目标方法开始之前执行
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("before前置通知");
        Signature signature = joinPoint.getSignature();
        String method = signature.getDeclaringTypeName() + "-->" + signature.getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        log.info(method);
        log.info(args.toString());
    }

    //在目标方法执行后执行（发生异常也执行） 不能获取目标方法执行后的结果
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("after后置通知");
    }

    //在目标方法正常执行(不出异常)完后执行，returnValue为目标方法的返回结果
    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("afterReturning返回通知");
    }

    //在目标方法执行时出现异常时执行，可以指定出现特定异常才执行
    @AfterThrowing(pointcut = "pointcut()", throwing = "e" )
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing异常通知");
    }
   /* @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        if (log.isInfoEnabled()) {
            log.info("before " + joinPoint);
        }
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        if (log.isInfoEnabled()) {
            log.info("after " + joinPoint);
        }
    }

    //配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            if (log.isInfoEnabled()) {
                log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            }
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            if (log.isInfoEnabled()) {
                log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            }
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning(pointcut = "pointcut()",returning = "returnValue")
    public void afterReturn(JoinPoint joinPoint,Object returnValue) {
        if (log.isInfoEnabled()) {
            log.info("afterReturn " + joinPoint);
        }
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        if (log.isInfoEnabled()) {
            log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
        }
    }*/

}
