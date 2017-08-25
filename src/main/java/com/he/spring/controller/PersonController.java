package com.he.spring.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.he.spring.bean.PersonBean;
import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.entity.Person;
import com.he.spring.service.PersonService;
import com.he.spring.shiro.util.Shiros;
import com.he.spring.util.Https;
import com.he.spring.util.Jsons;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    /**
     */
    @ResponseBody
    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test() {
        return "xx成功";
    }

    /**
     */
    @ResponseBody
    @RequestMapping(value = "/get")
    public Person xget(String id) {
        return personService.xget(id);
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public Object save() {
        Person person = new Person("name1", 13, new Date());
        person = personService.save(person);
        return person;
    }

    @ResponseBody
    @RequestMapping(value = "/saveAll")
    public List<Person> saveAll() {
        List<Person> list = Lists.newArrayList();
        for (int i = 1; i <= 50; i++) {
            Person person = new Person("name" + i, 10 + i, new Date());
            list.add(person);
        }
        return personService.saveAll(list);
    }

    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    @RequestMapping(value = "/savex")
    @ResponseBody
    public Result savex(HttpServletRequest request, HttpServletResponse response, String json) throws IOException {
        /*
		 *okgo.upjson 上传json
		String s=new String(getRequestPostBytes(request));
		System.err.println(s);*/

        Result reslut = Results.success();
        Person person = null;
        if (json != null) {
            person = Jsons.toBean(json, Person.class);
        } else {
            person = new Person("name1", 13, new Date());
        }
        person = personService.save(person);
        return reslut;
    }

    // @ModelAttribute(name = "person")
    // public Person newUser() {
    // return new Person(null, 200, new Date());
    // }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Object update(@Valid @ModelAttribute(name = "person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fes = result.getFieldErrors();
            for (FieldError fe : fes) {
                System.out.println(fe.getField() + "-------------->" + fe.getDefaultMessage());
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/findAll")
    public List<Person> findAll() {
        List<Person> ps = this.personService.findAllx();
        System.out.println(ps);
        return ps;
    }

    @ResponseBody
    @RequestMapping(value = "/findAllPersonBean")
    public List<PersonBean> findAllPersonBean() {
        List<PersonBean> pbs = this.personService.findAllPersonBean();
        System.out.println(pbs);
        return pbs;
    }

    @ResponseBody
    @RequestMapping(value = "/pageByName")
    //@CrossOrigin(origins ={"http://localhost:8909"} )//表示允许这个网站进行跨域访问这个url
    public Page<Person> pageByName(String name, String selectedIds, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        Page<Person> page = this.personService.pageByName(name, selectedIds, pageNumber, pageSize);
        Page<Person> page2 = this.personService.pageByName(name, selectedIds, pageNumber, pageSize);
        //if(true){
        //	throw  new RuntimeException("手动抛得异常");
        //}
//		System.out.println(page);
        Subject subject = Shiros.getSubject();
        log.warn("subject.isAuthenticated()"+subject.isAuthenticated());
        log.warn("subject.isRemembered()"+subject.isRemembered());
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/pageByNamex")
    public String pageByNamex(String url) {//后台将跨域信息返回给ajax
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", "name1");
        map.put("pageNumber", "1");
        map.put("pageSize", "2");
        try {
            String str = Https.post(url, map);
            log.info(str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // @ResponseBody
    // @RequestMapping(value = "/pageByName")
    // public Page<Person> getTotleNumber(String name, Integer pageNumber, Integer pageSize) {
    // Page<Person> page = this.personService.pageByName(name, pageNumber, pageSize);
    // return page;
    // }

    @ResponseBody
    @RequestMapping(value = "/pagePersonBeanByName")
    public Page<PersonBean> pagePersonBeanByName(String name, Integer pageNumber, Integer pageSize, Model model) {
        Page<PersonBean> page1 = this.personService.pagePersonBeanByName(name, pageNumber, pageSize);
        // model.addAttribute("page1", page1.getContent());
        // Page<Person> page2 = this.personService.pageByName(name, pageNumber, pageSize);
        // model.addAttribute("page2", page2);
        // List<Person> all = this.personService.findAll();
        // model.addAttribute("all", all);
        // return "/home";
        return page1;
    }
}
