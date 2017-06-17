package com.he.spring.shiro.credentials;

import com.he.spring.entity.Person;
import com.he.spring.shiro.redis.ICustomRedisCacheManager;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class LimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Person person;

    private ICustomRedisCacheManager customRedisCacheManager;

    public void setCustomRedisCacheManager(ICustomRedisCacheManager customRedisCacheManager) {
        this.customRedisCacheManager = customRedisCacheManager;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        //retry count + 1
        Cache<String, AtomicInteger> cache = customRedisCacheManager.getCache(username);
        AtomicInteger atomicInteger = cache.get(username);
        if(atomicInteger == null) {
            cache.put(username,new AtomicInteger(0));
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            cache.remove(username);
        }
        return matches;
    }
}
