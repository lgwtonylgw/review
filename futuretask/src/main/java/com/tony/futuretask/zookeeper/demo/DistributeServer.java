package com.tony.futuretask.zookeeper.demo;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/3/4 21:12.
 *
 * @author Tony
 * @description:
 */
public class DistributeServer {
    public static void main(String[] args) throws Exception {
        //连接zookeeper集群
        DistributeServer server=new DistributeServer();
        server.getConnect();
        //注册节点
        server.regiter(args[0]);
        //处理业务
        server.bussiness();
    }

    private void bussiness() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    private void regiter(String hostName) throws KeeperException, InterruptedException {
        String path = zkClient.create("/servers/server", hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName+"上线了");
    }

    static ZooKeeper zkClient;
    private static String connectStr="127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
    private void  getConnect() throws Exception {
        zkClient = new ZooKeeper(connectStr, 10000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //在这儿写监听逻辑
                try {
                    List<String> children = zkClient.getChildren("/", false);
                    for (String c:children){
                        System.out.println(c);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
