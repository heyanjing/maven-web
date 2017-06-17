/**
 * May 5, 2017 2:20:53 PM
 * Copyright(c) 2015-2017 深圳xxx电子商务科技有限公司.
 */
package com.he.spring.shiro.redis;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 张永强
 */
public class CustomRedisSessionDao extends CachingSessionDAO {
    private static final Logger log              = LoggerFactory.getLogger(CustomRedisSessionDao.class);
    /**
     * redis session key 前缀
     */
    private              String sessionKeyPrefix = "web-session-";

    private RedisTemplate<String, Session> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Session> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setSessionKeyPrefix(String sessionKeyPrefix) {
        this.sessionKeyPrefix = sessionKeyPrefix;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(this.sessionKeyPrefix + session.getId(), session, session.getTimeout(), TimeUnit.MILLISECONDS);
        log.warn("heRedis--- doCreate:-------{}",session);
        return sessionId;
    }
   /* @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        Session session = super.getCachedSession(sessionId);
        log.warn("heRedis--- readSession:-------{}",session);
        if(session==null){
            session=  this.doReadSession(sessionId);
        }
        return session;
    }*/
    @Override
    protected Session doReadSession(Serializable serializable) {
        Session session = null;
        try {
            session = session = redisTemplate.opsForValue().get(this.sessionKeyPrefix + serializable);
            if (session != null) {
                redisTemplate.expire(this.sessionKeyPrefix + serializable, session.getTimeout(), TimeUnit.MILLISECONDS);//刷新
                log.info("sessionId {} name {} 被读取", serializable, session.getClass().getName());
            }
        } catch (Exception e) {
            log.warn("读取Session失败", e);
        }
        log.warn("heRedis--- doReadSession:-------{}",serializable);
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        log.warn("heRedis--- doUpdate:-------{}",session);
        redisTemplate.boundValueOps(this.sessionKeyPrefix + session.getId()).set(session, session.getTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        log.warn("heRedis--- doDelete:-------{}",session);
        redisTemplate.delete(this.sessionKeyPrefix + session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<String> keys = redisTemplate.keys(this.sessionKeyPrefix + "*");
        Set<Session> sessions = new HashSet();
        for (String key : keys) {
            Session session = redisTemplate.opsForValue().get(key);
            sessions.add(session);
        }
        log.warn("heRedis--- getActiveSessions:-------{}",sessions);
        return sessions;
    }
}
