package com.he.spring.controller.ueditor;

import com.he.spring.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {
    private static final Logger log = LoggerFactory.getLogger(UeditorController.class);

    @RequestMapping(value = {"/index"})
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String result=null;
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            String rootPath = request.getServletContext().getRealPath("/");
            result= new ActionEnter(request, rootPath).exec();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
