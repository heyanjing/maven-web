package com.he.spring.shiro.redis.plus;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by heyanjing on 2017/6/16 11:49.
 */
public class CustomRedisSessionUtil {
    private static final Logger log                      = LoggerFactory.getLogger(CustomRedisSessionUtil.class);
    private              String redisShiroSessionPrefix  = "shiro-session:";
    private              int    redisShiroSessionTimeout = 1800;
    private RedisTemplate<String, Session> redisTemplate;

    public void setRedisShiroSessionPrefix(String redisShiroSessionPrefix) {
        this.redisShiroSessionPrefix = redisShiroSessionPrefix;
    }

    public void setRedisShiroSessionTimeout(int redisShiroSessionTimeout) {
        this.redisShiroSessionTimeout = redisShiroSessionTimeout;
    }

    public void setRedisTemplate(RedisTemplate<String, Session> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private String buildRedisSessionKey(Serializable sessionId) {
        return redisShiroSessionPrefix + sessionId;
    }

    /**
     * 保存session
     */
    public void saveSession(Session session) {
        try {
            this.redisTemplate.opsForValue().set(buildRedisSessionKey(session.getId()), session, redisShiroSessionTimeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("save session to redis error");
        }
    }

    /**
     * 更新session
     */
    public void updateSession(Session session) {
        try {
            this.redisTemplate.boundValueOps(buildRedisSessionKey(session.getId())).set(session, redisShiroSessionTimeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("update session error");
        }
    }


    /**
     * 刷新session
     */
    public void refreshSession(Serializable sessionId) {
        this.redisTemplate.expire(buildRedisSessionKey(sessionId), redisShiroSessionTimeout, TimeUnit.SECONDS);
    }


    /**
     * 删除session
     */
    public void deleteSession(Serializable id) {
        try {
            this.redisTemplate.delete(buildRedisSessionKey(id));
        } catch (Exception e) {
            log.error("delete session error");
        }
    }


    /**
     * 获取session
     */
    public Session getSession(Serializable id) {
        Session session = null;
        try {
            session = this.redisTemplate.boundValueOps(buildRedisSessionKey(id)).get();
        } catch (Exception e) {
            log.info("get session error");
        }
        return session;
    }
    public Collection<Session> getActiveSessions() {
        Set<String> keys = redisTemplate.keys(this.redisShiroSessionPrefix + "*");
        Set<Session> sessions = new HashSet();
        for (String key : keys) {
            Session session = redisTemplate.opsForValue().get(key);
            sessions.add(session);
        }
        return sessions;
    }

}
