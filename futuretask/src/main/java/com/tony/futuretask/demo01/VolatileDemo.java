package com.tony.futuretask.demo01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/1/22 11:21.
 *
 * @author Tony
 * @description:
 */
class MyData{
    //保证可见性，修改后其他线程立即可见
    volatile int data=0;
    void addPlus(){
        data++;
    }
    //保证原子性
    AtomicInteger atomicInteger=new AtomicInteger(0);
    void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlus();
                    myData.addAtomic();
                }
            }).start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(myData.data);
        System.out.println(myData.atomicInteger);
    }
}
