package com.he.spring.dao;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.he.spring.Subjects;
import com.he.spring.entity.Subject;
import com.he.spring.util.Https;
import com.he.spring.util.Jsons;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/4/24 15:09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-base.xml"})
public class SubjectDaoTest {
    private static final Logger log = LoggerFactory.getLogger(SubjectDaoTest.class);

    @Autowired
    SubjectDao subjectDao;

    @Test
    public void insertSubject() throws Exception {
        Map<String, Object> map = Maps.newHashMap();
        String ss = Https.get("http://data-test.timingbar.com/edu/org/orgTrainSubjects.js", map).split("=")[1];
        String s = "var orgTrainSubjectsStr={\"orgTrainSubjects\":[{\"id\":9513,\"orgId\":1520,\"orgCode\":\"4301010500\",\"projectId\":3,\"subjectId\":302,\"payType\":1,\"totalPrice\":100.0,\"isDeductLiveLearing\":null,\"years\":1,\"isExam\":1,\"isSendSms\":0,\"isMobileValidate\":0,\"isCheck\":0,\"isSelfReg\":null,\"isSchoolReg\":null,\"periods\":null,\"payTypeValue\":\"线下付费\",\"isExamValue\":\"是\",\"orgName\":\"长沙继续教育测试\",\"orgType\":4,\"idCards\":null,\"projectName\":null,\"subjectName\":null,\"times\":null},{\"id\":9514,\"orgId\":1520,\"orgCode\":\"4301010500\",\"projectId\":3,\"subjectId\":301,\"payType\":1,\"totalPrice\":100.0,\"isDeductLiveLearing\":null,\"years\":1,\"isExam\":1,\"isSendSms\":0,\"isMobileValidate\":0,\"isCheck\":0,\"isSelfReg\":null,\"isSchoolReg\":null,\"periods\":null,\"payTypeValue\":\"线下付费\",\"isExamValue\":\"是\",\"orgName\":\"长沙继续教育测试\",\"orgType\":4,\"idCards\":null,\"projectName\":null,\"subjectName\":null,\"times\":null}]};";
        s = s.split("=")[1];
        log.info("{}", s);


        Subjects subjects = Jsons.toBean(ss, Subjects.class);
        log.info("{}", subjects);
        List<Subject> subjectList = subjects.getOrgTrainSubjects();
        subjectDao.save(subjectList);

    }

    @Test
    public void getSubjectCode() throws Exception {
        List<Subject> subjectList = subjectDao.find("SELECT orgCode FROM `subject` GROUP BY orgCode", null);
        log.warn("组织长度:",subjectList.size());
        List<String> okCodeList = Lists.newArrayList();
        List<Subject> okSubject = Lists.newArrayList();
        for (Subject sub : subjectList) {
            Map<String, Object> map=Maps.newHashMap();
            map.put("code",sub.getOrgCode());
            map.put("pass","000000");
            String post = Https.post("http://edu.timingbar.com/login", map);
            if(post.contains("你好!")){
                log.warn(sub.getOrgCode());
                Subject subject = new Subject();
                subject.setOrgCode(sub.getOrgCode());
                subject.setOrgName(sub.getOrgName());
                okSubject.add(subject);
                okCodeList.add(sub.getOrgCode());
            }
        }
        log.warn("{}",okCodeList);
        log.error("{}", JSON.toJSONString(okSubject));
        subjectDao.save(okSubject);
    }
    @Test
    public void login() throws Exception {
        Map<String, Object> map=Maps.newHashMap();
        map.put("code","5000000000");
        map.put("pass","000000");
        String post = Https.post("http://edu.timingbar.com/login", map);
        if(post.contains("你好!")){
            log.warn("德行");
        }
        log.info(post);

    }


}