package com.tony.futuretask.redis.demo.rediscache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created on 2020/3/1 22:38.
 *
 * @author Tony
 * @description:
 */
@RestController
@RequestMapping("user")
@Slf4j
public class RedisCacheTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping("test")
    public void test(){
        redisTemplate.opsForValue().set("userKey",new User(1,"张三",23));
        User user=(User) redisTemplate.opsForValue().get("userKey");
        log.info("当前获取对象：{}",user.toString());
    }
}
