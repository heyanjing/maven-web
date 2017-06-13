package com.he.spring.controller;

import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.controller.util.Controllers;
import com.he.spring.entity.User;
import com.he.spring.service.UserService;
import com.he.spring.shiro.util.Shiros;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/user")
public class UserController extends Controllers {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login/", "/login"})
    public String login(String userName, String password, Model model) {
        Result result = Results.failure(1, "登陆失败");
        log.info("进入login");
        if (!Shiros.isAuthenticated()) {
            log.info("开始认证");
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            try {
                Shiros.login(token);
                result = Results.success("登陆成功");
                model.addAttribute("result", result);
                //return "/shrio/success";
                Session session = Shiros.getSession();
                if (session.getAttribute("userKey") == null) {
                    session.setAttribute("userKey", "我操你妹" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }

                return redirect("/home");
            } catch (UnknownAccountException e) {
                result.setMsg("未知用户");
            } catch (LockedAccountException e) {
                result.setMsg("用户被锁定");
            } catch (AuthenticationException e) {
                result.setMsg("用户名密码错误");
            }finally {
                log.info("认证结束，结果为{}", result);
            }
        }
        log.info("没认证，结果为{}", result);

        model.addAttribute("result", result);
        return redirect("/");
    }

    @RequestMapping(value = {"/reg/", "/reg"})
    @ResponseBody
    public Result reg(@Valid User user, BindingResult br) {
        Result result = Results.failure(1, "注册失败");
        if (br.hasErrors()) {
            result.setData(br.getAllErrors());
        }


        /*
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
        return result;*/
        return result;
    }

    @RequestMapping(value = {"/logout/", "/logout"})
    public String logout() {
        Result result = Results.success("注销成功");
        Shiros.logout();
        return "redirect:" + "/";
    }

}
