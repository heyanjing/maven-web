package com.he.spring.aop;

import com.he.spring.util.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heyanjing on 2017/5/19 14:29.
 * <p>
 * before---->after---->afterReturning或者afterThrowing
 * 切入点有多个切面时，@Order指定优先级,顺序如下
 * ControllerAspect1----------------------------------before前置通知
 * ControllerAspect2----------------------------------before前置通知
 * ControllerAspect2----------------------------------after后置通知
 * ControllerAspect2----------------------------------afterReturning返回通知
 * ControllerAspect1----------------------------------after后置通知
 * ControllerAspect1----------------------------------afterReturning返回通知
 */
@Order(2)
@Component
@Aspect
public class ControllerAspect2 {
    private static final Logger log = Logs.getLogger(ControllerAspect2.class);

    @Pointcut("execution(* com.he.spring.controller..*.*(..))")
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
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("afterThrowing异常通知");
    }

    /*//相当与上面的四中，功能最强大但是很少用，,必须有返回值，返回值即为目标方法执行后的返回值
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            //前置通知
            log.info("前置通知");
            log.info(joinPoint.getSignature().getDeclaringTypeName() + "--->" + joinPoint.getSignature().getName());
            log.info(Arrays.asList(joinPoint.getArgs()));

            result = joinPoint.proceed();//目标方法被执行
            //后置通知
            log.info("后置通知");

        } catch (Throwable throwable) {
            //异常通知
            log.info("异常通知");
            throwable.printStackTrace();
        } finally {
            //返回通知
            log.info("返回通知");
            return result;
        }
    }*/


}
