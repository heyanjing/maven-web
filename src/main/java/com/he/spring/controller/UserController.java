package com.he.spring.controller;

import com.he.spring.bean.Result;
import com.he.spring.bean.Results;
import com.he.spring.controller.util.Controllers;
import com.he.spring.entity.User;
import com.he.spring.service.UserService;
import com.he.spring.shiro.util.Shiros;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String login(String userName, String password, RedirectAttributes rmodel) {
        Result result = Results.failure(1, "登陆失败");
        log.info("开始认证");
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        try {
            Shiros.login(token);
            Session session = Shiros.getSession();
            if (session.getAttribute("userKey") == null) {
                session.setAttribute("userKey", "我操你妹" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        } catch (UnknownAccountException e) {
            result.setMsg("未知用户");
        } catch (LockedAccountException e) {
            result.setMsg("用户已被锁定");
        } catch (ExcessiveAttemptsException e) {
            result.setMsg("账号被锁定10分钟");
        } catch (AuthenticationException e) {
            result.setMsg("用户名密码错误");
        }
        if (!Shiros.isAuthenticated()) {
            rmodel.addFlashAttribute("result", result);
            return redirect("/");
        } else {
            return redirect("/home");
        }
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
