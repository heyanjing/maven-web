package com.he.spring.shiro.redis;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * Created by heyanjing on 2017/6/16 10:21.
 */
public interface ICustomRedisCacheManager extends CacheManager, Destroyable {
}
