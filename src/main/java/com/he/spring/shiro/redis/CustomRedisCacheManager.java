/**
 * May 5, 2017 4:25:52 PM
 * Copyright(c) 2015-2017 深圳xxx电子商务科技有限公司.
 */
package com.he.spring.shiro.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author 张永强
 */
public class CustomRedisCacheManager implements ICustomRedisCacheManager {
    private static final Logger log            = LoggerFactory.getLogger(CustomRedisCacheManager.class);
    /**
     * redis cache key的前缀
     */
    private              String cacheKeyPrefix = "web-cache-";

    @Resource
    private RedisTemplate<String, Session> redisTemplate;

    @Override
    public void destroy() throws Exception {
        // 这里不用connection.flushDb(), 以免Session等其他缓存数据被连带删除
        Set<String> redisKeys = redisTemplate.keys(this.cacheKeyPrefix + "*");
        for (String redisKey : redisKeys) {
            redisTemplate.delete(redisKey);
        }
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        log.warn("缓存起效");
        return new CustomRedisCache(this.cacheKeyPrefix + name + ":");
    }

    /**
     * 需要spring注入，所以public访问权限
     *
     * @param cacheKeyPrefix
     */
    public void setCacheKeyPrefix(String cacheKeyPrefix) {
        this.cacheKeyPrefix = cacheKeyPrefix;
    }
}
