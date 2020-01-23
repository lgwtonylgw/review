package com.tony.futuretask.demo01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/1/22 22:14.
 *
 * @author Tony
 * @description:
 */
public class SychronousDemo {
    public static void main(String[] args) {
        BlockingQueue sycchronous=new SynchronousQueue();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始生产");
            try {
                sycchronous.put("a");
                sycchronous.put("b");
                sycchronous.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(sycchronous.take()+"开始消费");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(sycchronous.take()+"开始消费");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(sycchronous.take()+"开始消费");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
