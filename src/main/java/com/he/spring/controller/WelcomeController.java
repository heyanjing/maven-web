package com.he.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {


    @RequestMapping(value = {"/", ""})
    public String index() {
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


}
