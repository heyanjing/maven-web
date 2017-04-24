package com.he.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by heyanjing on 2017/4/24 15:41.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:/spring/*.xml"})
public class PersonControllerTest {
    @Autowired
    private WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void before() {
        //可以对所有的controller来进行测试
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        //仅仅对单个Controller来进行测试
        // mockMvc = MockMvcBuilders.standaloneSetup(new MeunController()).build();
    }

    @Test
    public void findAll() throws Exception {
        ResultActions actions =  this.mockMvc.perform(get("/person//findAll"));
        System.out.println(status());//
        actions.andExpect(status().isOk());
    }

}