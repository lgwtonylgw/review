package com.tony.futuretask.redis;

/**
 * Created on 2020/1/26 17:35.
 *
 * @author Tony
 * @description:
 */
public class RedisDemo {
    /**
     * 1.linux安装redsi： 编译：make MALLOC=libc
     *                              make PREFIX=/usr/local/redis install
     *                              在/usr/local/redis/bin  下面   ./redis-server  开启服务端   ./redis-cli  开启客户端
     *                               将安装包下的redis.conf复制到安装目录下   cp redis.conf   /usr/local/redis
     *                               less -mN redis.conf   查看配置文件
     *                                修改配置文件   daemonize no 改为yes    设置为守护进程
     *                                bind 127.0.0.1注释掉，取消只能本地访问     61行
     *                                requirepass 设置密码
     *                                protect-mode  改为no   80行
     *
     *                单机版安装      cd /opt
     *                                tar -zxvf
     *                                cd redis-5.0.7
     *                                make
     *                                make install
     *                                cd /usr/local/bin   ll
     *                                在任意位置都可以  redis-server     启动
     *                                cp redis.conf  /root/myredis
     *                                vim redis.conf   同上
     *                                redis-cli shudown关闭服务端   或者redis-cli进去shudown   关闭服务端
     * 2.启动redis：     ./bin/redis-server   ./redis.conf
     *                  redis -h host -p port -a password
     *                  redis正常关闭：   ./bin/redis-cli shutdown 如果需要密码则在客户都登陆后shutdown
     *
     * 在一个项目中 key精良用这种格式   user:info:name
     *          String   set name  value
     *                    setNx   name value   没有才会创建
     *                    get name
     *                    append  key value  追加value值
     *                    exist  name
     *                    type key
     *                    expire name time
     *                    ttl name
     *                    del name
     *                    incr name   decr name    如果不是整型则置为0
     *                    getrange name start end
     *                    getset name
     *                    keys *
     *                    key pattern     key user:?
     *                    strlen name    字符串长度
     *                    incr    key    如果值为空则value 为1
     *                    decr    key    如果值为空则value 为-1
     *                    incrby  key   步长
     *                    setex   设置值同时设置过期时间
     *                    getset  设置值同时获取旧值
     *            List    lpush/rpush   key value1  value2   value3   一个或多个值
     *                    lpop/rpop
     *                    rpoplpush  左边取出插入右边
     *                    lrange   key start end
     *                    lindex key index
     *                    llen key
     *                    linsert key before value newvalue
     *                    lrem key n value
     *            Set     sadd key v1 v2 v3   一个或多个
     *                    smembers key  取出该集合的所有值
     *                    sismember key value
     *                    scard key  返回该集合元素个数
     *                    srem key v1 v2
     *                    spop key
     *                    sranmember key n
     *                    sinter k1 k2
     *                    sunion k1 k2
     *                    sdiff k1 k2
     *
     *            Hash
     *                  hset key field value
     *                  hget key field
     *                  hmset key filed1 value1 filed2 value2
     *                  hmget key filed1 field2
     *                  hkeys key   列出key所有的field
     *                  hvals key   列出key所有的value
     *                  hlen key
     *                  hgetall key
     *                  hdel key  filed1 field2
     *                  hincrby key field 1
     *                  hexists key field
     *                  hsetnx key value    不存在则设置
     *           Zset      zadd key score1 value1   score2  value2
     *                     zrange key start stop
     *                     zrangebyscore key min max    （withscores)
     *                     zrevrangebyscore key max min
     *                     zrem key value
     *                     zcount key min max  指定分数区间成员数
     *                     zcard   key   获取成员数
     *                     zincrby key n value   score增加n
     *                     zrank key value    返回该值在集合中的排名
     *
     *
     *
     * redis主从复制：  主服务器不用配置   从服务器：    ./bin/redis-server ./redis.conf   --port=6380  --slaveof 127.0.0.1   6379
     *                      变回主：  slaveof on one
     *                      变回从：   slaveof   服务器  端口号
     */
}
