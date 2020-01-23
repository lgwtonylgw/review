package com.tony.futuretask.demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2020/1/22 19:57.
 *
 * @author Tony
 * @description:
 */
class MyCache{
    private volatile Map<String ,Object> map=new HashMap<>();
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    void put(String key,Object o) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入");
            map.put(key,o);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写入完成");
        }finally {
            lock.writeLock().unlock();
        }
    }
    void get(String key) {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"正在读取");
            map.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取完成");
        } finally {
            lock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tempInt=i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            final int tempInt=i;
            new Thread(()->{
                myCache.get(tempInt+"");
            }).start();
        }

    }
}
