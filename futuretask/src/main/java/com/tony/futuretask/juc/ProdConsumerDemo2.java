package com.tony.futuretask.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020/1/28 13:04.
 *
 * @author Tony
 * @description:
 */
class ShareData{
    private int num=1;
    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    void printA(){
        lock.lock();
        try {
            while(num!=1){
                condition1.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    void printB(){
        lock.lock();
        try {
            while(num!=2){
                condition2.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    void printC(){
        lock.lock();
        try {
            while(num!=3){
                condition3.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            num=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ProdConsumerDemo2 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                shareData.printA();
            },"A").start();
            new Thread(()->{
                shareData.printB();
            },"B").start();
            new Thread(()->{
                shareData.printC();
            },"C").start();
        }
    }
}
