package com.tony.futuretask.redis;

import redis.clients.jedis.Jedis;

/**
 * Created on 2020/1/26 23:27.
 *
 * @author Tony
 * @description:
 */
public class JedisDemo {
    public static void main(String[] args) {

        Jedis jedis=ReidsPoolConfig.getJedis();
        System.out.println(jedis);
        if(jedis.exists("hello")){
            System.out.println("直接获取"+jedis.get("hello"));
        }else{
            String result="nimabi";
            jedis.set("hello",result);
            System.out.println("简介获取"+result);
        }
        ReidsPoolConfig.close(jedis);
    }
}
