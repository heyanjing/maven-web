package com.he.spring;

import com.he.spring.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by heyanjing on 2017/6/8 16:54.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class CommonTest {
    private static final Logger log = LoggerFactory.getLogger(CommonTest.class);

    @Autowired
    @Qualifier(value ="p2")
    Person p1;
    @Autowired
    Person p2;
    @Autowired
    Person person;

    @Test
    public void t1() {
        log.warn(p1.getName());
        log.warn(p2.getName());
        log.warn(person.getName());
    }
}