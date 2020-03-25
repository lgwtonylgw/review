package com.tony.futuretask.zookeeper.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/3/4 20:44.
 *
 * @author Tony
 * @description:
 */
public class ZookeeperDemo {
   static ZooKeeper zkClient;
    private static String connectStr="127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
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
        String path = zkClient.create("/tony", "liuguowen".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        //获取根路径下所有节点并没监控
        List<String> children = zkClient.getChildren("/", false);
        for (String c:children){
            System.out.println(c);
        }
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        //判断节点是否存在
        Stat exists = zkClient.exists("/tony", false);
        System.out.println(exists==null?"不存在":exists);

    }

}
