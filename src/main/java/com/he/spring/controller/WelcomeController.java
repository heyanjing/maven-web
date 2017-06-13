package com.he.spring.controller;

import com.alibaba.fastjson.JSON;
import com.he.spring.shiro.util.Shiros;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping(value = {"/", ""})
    public String index(Model model) {
        log.info("去往登陆也");
        model.addAttribute("sessionId",Shiros.getSessionId());
        model.addAttribute("session", JSON.toJSONString(Shiros.getSession()));
        return "/shrio/index";
    }

    @RequestMapping(value = {"/page1/", "/page1"})
    public String page1() {
        return "/shrio/page1";
    }

    @RequestMapping(value = {"/page2/", "/page2"})
    public String page2() {
        return "/shrio/page2";
    }
    @RequestMapping(value = {"/page3/", "/page3"})
    public String page3() {
        return "/shrio/page3";
    }


}
