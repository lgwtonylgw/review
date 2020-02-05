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
     *                                bind 127.0.0.1注释掉，取消只能本地访问
     *                                requirepass 设置密码
     * 2.启动redis：     ./bin/redis-server   ./redis.conf
     *                  redis -h host -p port -a password
     *                  redis正常关闭：   ./bin/redis-cli shutdown 如果需要密码则在客户都登陆后shutdown
     *
     * 在一个项目中 key精良用这种格式   user:info:name
     *          String   set name  value
     *                    setNx   name value
     *                    get name
     *                    exist  name
     *                    expire name time
     *                    ttl name
     *                    del name
     *                    incr name   decr name    如果不是整型则置为0
     *                    getrange name start end
     *                    getset name
     *                    keys *
     *                    key pattern     key user:?
     *                    strlen name    字符串长度
     *            Hash
     *                  hset key field value
     *                  hget key field
     *                  hmset key filed1 value1 filed2 value2
     *                  hmget key filed1 field2
     *                  hkeys key
     *                  hlen key
     *                  hgetall key
     *                  hdel key  filed1 field2
     *                  hincrby key field 1
     *                  hexists key field
     *
     *
     * redis主从复制：  主服务器不用配置   从服务器：    ./bin/redis-server ./redis.conf   --port=6380  --slaveof 127.0.0.1   6379
     *                      变回主：  slaveof on one
     *                      变回从：   slaveof   服务器  端口号
     */
}
