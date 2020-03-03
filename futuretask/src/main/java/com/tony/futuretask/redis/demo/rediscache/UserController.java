package com.tony.futuretask.redis.demo.rediscache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created on 2020/3/1 22:46.
 *
 * @author Tony
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public void add(){
        User jack = userService.save(new User(4, "jack", 19));
        log.info("添加用户信息:{}",jack.toString());
    }
    @RequestMapping("delete")
    public void delete(){
        userService.delete(4);
    }
    @RequestMapping("get/{id}")
    public void get(@PathVariable Integer id){
        User user = userService.get(id);
        log.info("获取用户信息：{}",user);
    }
}
