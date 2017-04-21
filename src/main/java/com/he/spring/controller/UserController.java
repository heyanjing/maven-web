package com.he.spring.controller;

import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.entity.User;
import com.he.spring.service.UserService;
import com.he.spring.shiro.util.Shiros;
import com.he.spring.util.Cryptos;
import com.he.spring.util.Encodes;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login/", "/login"})
    public String login(String userName, String password, Model model) {
        Result result = Results.failure(1, "登陆失败");
//        if (!Shiros.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            try {
                Shiros.login(token);
                result = Results.success("登陆成功");
                model.addAttribute("result", result);
                return "/shrio/success";
            } catch (UnknownAccountException e) {
                result.setMsg("未知用户");
            } catch (LockedAccountException e) {
                result.setMsg("用户被锁定");
            } catch (AuthenticationException e) {
                result.setMsg("用户名密码错误");
            }
//        }
        model.addAttribute("result", result);
        return "redirect:" + "/";
    }

    @RequestMapping(value = {"/reg/", "/reg"})
    @ResponseBody
    public Result reg(String userName, String password) {
        Result result = Results.failure(1, "注册失败");
        String salt = Cryptos.generateSaltHexString(10);
        System.out.println(salt);
        byte[] md5s = Cryptos.digest(password.getBytes(Charset.forName("utf-8")), "MD5", salt.getBytes(Charset.forName("utf-8")), 1024);
        String md5Password = Encodes.encodeHex(md5s);
        byte[] sha1s = Cryptos.digest(password.getBytes(Charset.forName("utf-8")), "SHA1", salt.getBytes(Charset.forName("utf-8")), 1024);
        String sha1Password = Encodes.encodeHex(sha1s);
        User user = new User(userName, md5Password, sha1Password, salt, 99);
        this.userService.save(user);
        result = Results.success("注册成功");
        return result;
    }

    @RequestMapping(value = {"/logout/", "/logout"})
    public String logout() {
        Result result = Results.success("注销成功");
        Shiros.logout();
        return "redirect:" + "/";
    }

}
