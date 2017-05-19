package com.he.spring.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/5/19 14:29.
 */
@Component
@Aspect
public class ServiceAspect {
    private static final Log log = LogFactory.getLog(ServiceAspect.class);

    @Pointcut("execution(* com.he.spring.service..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
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
    }

}
