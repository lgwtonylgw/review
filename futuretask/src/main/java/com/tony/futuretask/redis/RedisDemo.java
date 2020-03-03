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
     * redis主从复制：  主服务器不用配置   配置从服务器：    ./bin/redis-server ./redis.conf   --port=6380  --slaveof 127.0.0.1   6379
     *                      变回主：  slaveof on one
     *                      变回从：   slaveof   服务器  端口号
     *                      1.拷贝多个redis。conf文件  include      incluede   /myredsi/redis.conf
     *                      2.开启daemonize yes
     *                      3.Pid文件名pidfie                      pidfile  /var/run/redis_6379.pid
     *                      4.指定端口  port                       port  7379
     *                      5.Log文件名
     *                      6.Dump.rdb文件名dbfilename             dbfilename    dump6379.rdb
     *                      7.appendonly关掉或者换名
     *                      8.slave-priority 100                  slave-priority 10
     *                      info replication 打印主重复值的相关信息
     *                      slaveof ip port
     *                      这样的主从是没有哨兵模式的  还需要zookeeper配置节点，选举主机
     *                      一注二仆模式：
     *                              1.slave1和slave2是从头开始复制而不是从切入点开始复制
     *                              2.从机不可以写set
     *                              3.主机shutdown后，从机原地待命，待主机恢复后，从新链接
     *                              4.从机down掉后，就脱离slave了
     *                      用slaveof no one  从机变成主机
     *                      配置哨兵     vim myredis/sentinel.conf        sentinel monitor mymaster 127.0.0.1 6379 1  其中mymaster为监控对象取得服务名，1为至少多少个
     *                                  哨兵同意迁移的数量
     *                      启动哨兵     redis-sentinel  sentinel.conf   如果主机当掉，会根据slave-priority选举主机   值越小机会越大   宕掉的那个主机重启后不再是主机
     *                                      而是变成从机（哨兵向其发了slaveof 命令）
     * redis事务
     *                  multi开启事务组队   exec执行      discard放弃    组队过程中发生错误会回滚，而执行时发生错误则跳过
     *
     *                  乐观锁：   watch  key   可以多个key   然后执行multi    档exec的时候就回去检测key有没有改动过，改动过，事务就中断
     * redis持久化       修改redis.conf   中filename dump.rdb  的位置 为  /root/myredis/
     *                     rdb在shutdown时会持久化
     *                     save 900 1    15分钟内  1个数据发生变化就会rdb
     *                     save 300 10
     *                     save 60 10000
     *                     save   vs   bgsave手动保存       前一个会阻塞进程，后一个不会
     *                     redis备份   找到dump.rdb文件，拷贝到其他地方
     *                     redis恢复   关闭redis   将dump.rdn放回到工作面目录下，启动redis就会恢复数据
     *                     stop-writes-on-bgsave-error yes   磁盘满的时候就不会写入
     *                      rdbcompression yes   进行rdb保存时将文件压缩
     *
     *                      appendonly no  改为yes     重启redis默认会加载aof里的东西而不是rdb    redis-check-aof --fix appendonly.aof   修复aof文件
     *                      appendfsync always
     *                      appendfsync everysec   默认每秒同步一次
     *                       appendfsync no
     *                       bgrewriteaof   重写aof文件，进行压缩
     *
     *
     */
}
