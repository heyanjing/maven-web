package com.he.spring;

import com.google.common.collect.Maps;
import com.he.spring.dao.SubjectDao;
import com.he.spring.entity.Subject;
import com.he.spring.util.Base64Utils;
import com.he.spring.util.Https;
import com.he.spring.util.Jsons;
import org.apache.shiro.codec.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/4/28 10:44.
 */
public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);


    public static void main(String[] args)throws Exception {
        log.info("我操");
        byte[] encode = Base64.encode("我操".getBytes("utf-8"));
        String s1 = Base64.decodeToString("我操");
        log.info(s1);
        String encode1 = Base64Utils.encode("我操sfdasdfasdf".getBytes("utf-8"));
        log.warn(encode1);
        byte[] decode1 = Base64Utils.decode("4AvVhmFLUs0KTA3Kprsdag==");
        String s = new String(decode1,"gbk");
        log.warn(s);


        byte[] decode = Base64.decode("4AvVhmFLUs0KTA3Kprsdag==");
        String s2= new String(decode,"gbk");
        log.info(s2);
    }


}
