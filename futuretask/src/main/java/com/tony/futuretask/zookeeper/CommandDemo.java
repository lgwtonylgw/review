package com.tony.futuretask.zookeeper;

/**
 * Created on 2020/1/25 16:53.
 *
 * @author Tony
 * @description:
 */
public class CommandDemo {
    /**
     * 1.先下载zookeeper    gz包   放到目录下   tar -zxvf ap...gz   -C   /opt/module/
     * 2.cd /opt/module/ap.../conf     mv zoo_sample.cfg   zoo.cfg  vim zoo.cfg      dataDir=/opt/module/ap.../zkData    在对应目录下创建zkData文件夹 mkdir -p zkData
     * 3.bin/zkServer.sh start  启动    jps  查看进程    /bin/zkServer.sh status    查看状态    /bin/zkServer.sh stop 关闭     /bin/zkCli.sh   开启客户端  quit 退出
     * 4.ls  查看节点
     * 然后在三台服务器上启动三台zookeeper    在zkData下建立  myid文件  touch myid   依次填写1 2 3
     *              1.
     *                 # vim conf/zoo.cfg
     *                  dataDir=/opt/module/ap.../zkData
     *                  clientPort=2182
     *                  server.1=127.0.0.1:2888:3888
     *                  server.2=127.0.0.2:2888:3888
     *                  server.3=127.0.0.3:2888:3888
     *                  # vim conf/zoo.cfg
     *                  dataDir=/opt/module/ap.../zkData
     *                  clientPort=2183
     *                  server.1=127.0.0.1:2888:3888
     *                   server.2=127.0.0.2:2888:3888
     *                   server.3=127.0.0.3:2888:3888
     *                   # vim conf/zoo.cfg
     *                   dataDir=/opt/module/ap.../zkData
     *                   clientPort=2181
     *                   server.1=127.0.0.1:2888:3888
     *                   server.2=127.0.0.2:2888:3888
     *                   server.3=127.0.0.3:2888:3888
     *
     *                   tickTime：这个时间是作为 Zookeeper 服务器之间或客户端与服务器之间维持心跳的时间间隔，也就是每个 tickTime 时间就会发送一个心跳。
     * initLimit：这个配置项是用来配置 Zookeeper 接受客户端（这里所说的客户端不是用户连接 Zookeeper 服务器的客户端，而是 Zookeeper 服务器集群中连接到 Leader 的
     * Follower 服务器）
     * 初始化连接时最长能忍受多少个心跳时间间隔数。当已经超过 10个心跳的时间（也就是 tickTime）长度后 Zookeeper 服务器还没有收到客户端的返回信息，那么表明这个
     * 客户端连接失败。总的时间长度就是 10*2000=20 秒
     * syncLimit：这个配置项标识 Leader 与 Follower 之间发送消息，请求和应答时间长度，最长不能超过多少个 tickTime 的时间长度，总的时间长度就是 5*2000=10秒
     * dataDir：顾名思义就是 Zookeeper 保存数据的目录，默认情况下，Zookeeper 将写数据的日志文件也保存在这个目录里。
     * clientPort：这个端口就是客户端连接 Zookeeper 服务器的端口，Zookeeper 会监听这个端口，接受客户端的访问请求。
     * server.A=B：C：D：其中 A 是一个数字，表示这个是第几号服务器；B 是这个服务器的 ip 地址；C 表示的是这个服务器与集群中的 Leader 服务器交换信息的端口；
     * D 表示的是万一集群中的 Leader 服务器挂了，需要一个端口来重新进行选举，选出一个新的 Leader，而这个端口就是用来执行选举时服务器相互通信的端口。
     * 如果是伪集群的配置方式，由于 B 都是一样，所以不同的 Zookeeper 实例通信端口号不能一样，所以要给它们分配不同的端口号
     *
     *
     *              然后依次启动三个服务   bin/zkServer.sh start
     *
     *  连接上客户端：     bin/zkCli.sh   quit  退出
     *                     help 查看指令
     *                     ls /   查看当前znode所包含的内容
     *                     ls2 /查看详细信息
     *                     create  /kapa   abc   创建节点    -e   创建临时节点   -s   带序号
     *                     get   /kapa/nima   可以获取节点信息
     *                     set  修改
     *                    get path   watch   监听节点数据变化
     *                    ls path watch 监听节点路径辩护
     *                    delete   node   删除节点  rmr  path   递归删除节点
     *                    stat   node   查看节点信息
     *                      客户端创建zkClient的时候会创建两个线程connect()去连接服务端，服务端注册监听列表i：Client:ip:port:/path   process()去监听服务端发来的变化
     *
     */

}
