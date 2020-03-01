package com.tony.futuretask.redis.demo.rediscache;

/**
 * Created on 2020/3/1 22:43.
 *
 * @author Tony
 * @description:
 */
public interface UserService {
    User save(User user);
    void delete(int id);
    User get(Integer id );
}
