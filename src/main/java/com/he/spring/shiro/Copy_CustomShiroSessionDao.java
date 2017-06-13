//package com.he.spring.shiro;
//
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by heyanjing on 2017/6/8 17:39.
// */
//@Component
//public class Copy_CustomShiroSessionDao extends EnterpriseCacheSessionDAO {
//    private static final Logger log = LoggerFactory.getLogger(Copy_CustomShiroSessionDao.class);
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 创建session，保存到redis集群中
//     */
//    @Override
//    protected Serializable doCreate(Session session) {
//        Serializable sessionId = super.doCreate(session);
//        //System.out.println("sessionId: " + sessionId);
//        log.warn("创建sessionId: {}",sessionId);
//
//        BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps("shiro_session_" + sessionId.toString());
//        sessionValueOperations.set(session);
//        sessionValueOperations.expire(30, TimeUnit.MINUTES);
//
//        return sessionId;
//    }
//
//    /**
//     * 获取session
//     *
//     * @param sessionId
//     * @return
//     */
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        Session session = super.doReadSession(sessionId);
//
//        if (session == null) {
//            BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps("shiro_session_" + sessionId.toString());
//            session = (Session) sessionValueOperations.get();
//        }
//        log.warn("获取session:{}",session);
//        return session;
//    }
//
//    /**
//     * 更新session
//     *
//     * @param session
//     */
//    @Override
//    protected void doUpdate(Session session) {
//        log.warn("更新session:{}",session);
//
//        super.doUpdate(session);
//
//        BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps("shiro_session_" + session.getId().toString());
//        sessionValueOperations.set(session);
//        sessionValueOperations.expire(30, TimeUnit.MINUTES);
//    }
//
//    /**
//     * 删除失效session
//     */
//    @Override
//    protected void doDelete(Session session) {
//        log.warn("删除session:{}",session);
//        redisTemplate.delete("shiro_session_" + session.getId().toString());
//        super.doDelete(session);
//    }
//
//}
