package com.he.spring.shiro.util;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.he.spring.util.Logs;

public class Shiros {

    private Shiros() {
    }

    /**
     * 获取当前用户
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 登出
     */
    public static void logout() {
        Subject currentUser = getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
    }

    /**
     * 获取Session
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获取Session
     */
    public static Session getSession(boolean create) {
        return getSubject().getSession(create);
    }

    /**
     * 获取当前用户
     */
    public static Object getCurrentUser() {
        return getSubject().getPrincipal();
    }

    public static Serializable getSessionId() {
        return getSession().getId();
    }

    public static String getHost() {
        return getSession().getHost();
    }

    public static String getIP() {
        return getHost();
    }

    public static Date getStartTimestamp() {
        return getSession().getStartTimestamp();
    }

    public static Date getLastAccessTime() {
        return getSession().getLastAccessTime();
    }

    /**
     * 是否登陆
     */
    public static boolean isLogin() {
        return getCurrentUser() != null;
    }

    /**
     * 检查角色
     */
    public static boolean hasRole(String role) {
        return getSubject().hasRole(role);
    }

    /**
     * 检查权限
     */
    public static boolean isPermitted(String permission) {
        return getSubject().isPermitted(permission);
    }

    /**
     * 打印Session相关信息
     */
    public static void printSession() {
        Logs.println("SESSION");
        Logs.msg(getSession().getId());
        Logs.msg(getSession().getHost());
        Logs.msg(getSession().getTimeout());
        Logs.msg(getSession().getLastAccessTime());
    }
}
