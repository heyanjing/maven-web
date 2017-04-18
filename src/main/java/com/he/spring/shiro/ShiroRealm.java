package com.he.spring.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.he.spring.shiro.bean.ShiroBean;

/**
 * 先进行登录认证
 * ,然后在进行授权认证
 */

public class ShiroRealm extends AuthorizingRealm {
    /**
     * 登录认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
        String loginName = loginToken.getUsername();// 用户名
        // 通过用户名查询用户相关信息，封装到shiroBean中
        ShiroBean shiroBean = new ShiroBean();
        /**
         * 密码有加盐处理时
         * byte[] salt = {};
         * SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(shiroBean, "用户密码", ByteSource.Util.bytes(salt), super.getName());
         */
        // XXX
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroBean, "用户密码", super.getName());
        return info;
    }

    /**
     * 角色授权认证
     * principals 为登录认证时穿过来的shiroBean
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        ShiroBean shiroBean = (ShiroBean) principals.getPrimaryPrincipal();
        // 通过ShiroBean查询出该用户拥有的角色，然后添加进角色授权认证中
        // XXX
        info.addRole("角色");
        return info;
    }
}
