package com.tony.futuretask.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created on 2020/1/26 23:28.
 *
 * @author Tony
 * @description:
 */
public class ReidsPoolConfig {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(10);
        String host="139.155.15.187";
        String port="6397";

        jedisPool=new JedisPool(jedisPoolConfig,host);
    }
    public static Jedis getJedis(){
        Jedis jedis=jedisPool.getResource();
        jedis.auth("123456");
        return jedis;
    }
    public static void close (Jedis jedis){
        jedis.close();
    }
}
