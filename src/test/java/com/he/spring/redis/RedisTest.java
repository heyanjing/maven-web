package com.he.spring.redis;

import com.he.spring.dao.UserDao;
import com.he.spring.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heyanjing on 2017/6/8 16:54.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class RedisTest {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate           stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplateCluster;
    @Autowired
    private StringRedisTemplate           stringRedisTemplateCluster;

    @Test
    public void test() {
        log.info("高的刷");
    }

    /**
     * ValueOperations、SetOperations、ZSetOperations
     * ListOperations、HashOperations
     */
    @Test
    public void testSaveAndGet() {
        User user = this.userDao.getById("4028c6ee5b8f3883015b8f3ac88c0001");
        ValueOperations<String, Object> valueOperation = redisTemplate.opsForValue();
        valueOperation.set("user" + user.getId(), user);

        User result = (User) valueOperation.get("user" + user.getId());
        System.out.println("name: " + result.getName());

    }

    @Test
    public void testOpsForList() {
        List<User> users = userDao.findByName("何彦静");
        ValueOperations<String, Object> opsForList = redisTemplate.opsForValue();

        opsForList.set("users", users);

        List<User> result = (List<User>) opsForList.get("users");

        System.out.println(result.get(0).getName());

    }

    @Test
    public void testOpsForMap() {
        Map<String, String> score = new HashMap<>();
        score.put("stuA", "89");
        score.put("stuB", "63");
        score.put("stuC", "94");
        score.put("stuD", "21");


        ValueOperations<String, Object> opsForList = redisTemplate.opsForValue();

        opsForList.set("scores", score);

        Map<String, String> result = (Map<String, String>) opsForList.get("scores");

        System.out.println(result.get("stuA"));

    }

    /**
     * BoundKeyOperations、BoundValueOperations、BoundSetOperations
     * BoundListOperations、BoundSetOperations、BoundHashOperations
     */
    @Test
    public void testBoundOperations() {
        BoundValueOperations<String, Object> boundValueOperations = redisTemplate.boundValueOps("BoundTest");
        //设置值
//		boundValueOperations.set("test12345");
        //设置过期时间
//		boundValueOperations.expire(100, TimeUnit.SECONDS);
        //重命名Key
//		boundValueOperations.rename("BoundTest123");

        System.out.println("key: " + boundValueOperations.getKey());
        System.out.println(boundValueOperations.get());
        System.out.println("expire: " + boundValueOperations.getExpire());
    }
}