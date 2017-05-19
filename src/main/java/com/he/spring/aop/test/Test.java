package com.he.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/5/19 11:19.
 */
public class Test {
    public static void main(String[] args) {
    ApplicationContext ctx  = new ClassPathXmlApplicationContext("/test/aop.xml");
        ActionTest action = ctx.getBean("action", ActionTest.class);
        action.a();
        action.b();

    }

}
