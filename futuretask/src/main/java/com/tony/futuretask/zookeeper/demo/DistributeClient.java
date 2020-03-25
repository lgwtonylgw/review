package com.tony.futuretask.zookeeper.demo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/3/4 21:22.
 *
 * @author Tony
 * @description:
 */
public class DistributeClient {
    public static void main(String[] args) throws Exception {
        DistributeClient client=new DistributeClient();
        //获取zookeeper集群
        client.getConnect();
        //监听
        client.getChildren();
        //处理业务
        client.business();
    }

    private void business() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers", true);
        List<String> hosts = new ArrayList<>();

        for(String s:children){
            byte[] data = zkClient.getData("/servers" + children, false, null);
            hosts.add(new String(data));
        }
        System.out.println(hosts);
    }

    static ZooKeeper zkClient;
    private static String connectStr="127.0.0.1:2181,127.0.0.1:2181,127.0.0.1:2181";
    private void  getConnect() throws Exception {
        zkClient = new ZooKeeper(connectStr, 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //在这儿写监听逻辑
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
