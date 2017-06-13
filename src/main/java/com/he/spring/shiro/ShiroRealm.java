package com.he.spring.shiro;

import com.he.spring.dao.UserDao;
import com.he.spring.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 先进行登录认证
 * ,然后在进行授权认证
 */

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 登录认证信息 Subject.login(token);会回调该方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
        String loginName = loginToken.getUsername();// 用户名
        /*
        * 通过用户名查询用户相关信息并抛出对应的异常
        *   1、没有用户抛出 UnknownAccountException
        *   2、用户被锁定  LockedAccountException
        *
        *
        *
        */
        List<User> userList = this.userDao.findByName(loginName);
        if (userList.size() <= 0) {
            throw new UnknownAccountException("用户不存在");
        }
        User user = userList.get(0);
        if (user.getState() == 99) {
            throw new LockedAccountException("用户被锁定");
        }


        // 经过一系列的处理后最后将用户的所有相关信息封装到shiroBean中
//        ShiroBean shiroBean = new ShiroBean(user.getName(),user.getMd5Password(),user.getSha1Password(),user.getSalt(),user.getState());
        /**
         * 密码有加盐处理时
         * byte[] salt = {};//用户数据库中的盐
         * SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(shiroBean, "用户数据库密码", ByteSource.Util.bytes(salt), super.getName());
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getMd5Password(), ByteSource.Util.bytes(user.getSalt()), super.getName());
        return info;
    }

    /**
     * 角色授权认证
     * principals 为登录认证时穿过来的principals
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        ShiroBean shiroBean = (ShiroBean) principals.getPrimaryPrincipal();
        // 通过ShiroBean查询出该用户拥有的角色，然后添加进角色授权认证中
        // XXX
        User user = (User) principals.getPrimaryPrincipal();
        if(user.getName().equals("何彦静")){
            info.addRole("user1");
            info.addRole("user2");
        }
        if(user.getName().equals("陈友兰")){
            info.addRole("user2");
        }
        info.addRole("用户角色");
        return info;
    }
}
