package com.tony.futuretask.demo01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 2020/1/22 17:56.
 *
 * @author Tony
 * @description:
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"获取锁");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    void myunLock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"释放锁");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo=new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myunLock();
        },"AA").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myunLock();
        },"BB").start();
    }
}
