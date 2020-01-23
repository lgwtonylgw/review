package com.tony.futuretask.demo01;

import java.util.concurrent.CountDownLatch;

/**
 * Created on 2020/1/22 20:41.
 *
 * @author Tony
 * @description:
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"走了");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"班长锁门了");
    }
    public static void main11() {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"走了");
            }).start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(Thread.currentThread().getName()+"班长关门了");
    }
}
