package com.tony.futuretask.redis.demo.rediscache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/3/1 22:44.
 *
 * @author Tony
 * @description:
 */
@Service
@Slf4j
public class UserServiceeImpl implements UserService {
    private static Map<Integer,User> map=new HashMap<>();
    static {
        map.put(1,new User(1,"tony",22));
        map.put(2,new User(2,"tom",20));
        map.put(3,new User(3,"jerry",25));
    }
    @Override
    @CachePut(value = "user",key = "#user.id")
    public User save(User user) {
        map.put(user.getId(),user);
        log.info("进入save方法，当前存储对象：{}",user.toString());
        return user;
    }

    @Override
    @CacheEvict(value = "user",key = "#id")
    public void delete(int id) {
        map.remove(id);
        log.info("进入delete方法，删除成功");
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    public User get(Integer id) {
        log.info("进入get方法，当前对象：{}",map.get(id)==null?null:map.get(id).toString());

        return map.get(id);
    }
}
