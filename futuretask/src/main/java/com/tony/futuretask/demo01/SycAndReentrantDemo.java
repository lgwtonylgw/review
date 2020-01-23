package com.tony.futuretask.demo01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020/1/22 23:34.
 *
 * @author Tony
 * @description:
 */
class ShareResoure{
    private int number=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    void print5(){
        lock.lock();
        try {
            while(number!=1){
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"打印5次");
            }
            number=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void print10(){
        lock.lock();
        try {
            while(number!=2){
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"打印10次");
            }
            number=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void print15(){
        lock.lock();
        try {
            while(number!=3){
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"打印15次");
            }
            number=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SycAndReentrantDemo {
    public static void main(String[] args) {
        ShareResoure shareResoure=new ShareResoure();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                shareResoure.print5();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                shareResoure.print10();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                shareResoure.print15();
            }
        }).start();
    }
}
