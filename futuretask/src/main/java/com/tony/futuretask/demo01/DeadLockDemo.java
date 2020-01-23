package com.tony.futuretask.demo01;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/1/23 14:18.
 *
 * @author Tony
 * @description:
 */
class MyLock implements Runnable{
    private String lockA;

    public MyLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    private String lockB
            ;

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"占有"+lockA+"尝试获"+lockB+"锁");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"持有"+lockB+"锁");
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";

        new Thread(new MyLock(lockA,lockB),"ThreadAAA").start();
        new Thread(new MyLock(lockB,lockA),"ThreadBBB").start();
    }
}
