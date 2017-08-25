package com.he.spring.dao;

import com.he.spring.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by heyanjing on 2017/4/24 15:09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-base.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void findByName() throws Exception {
        List<User> list = userDao.findByName("何彦静");
        System.out.println(list);


    }

}