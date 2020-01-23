package com.tony.futuretask.demo01;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/1/22 15:06.
 *
 * @author Tony
 * @description:
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
//        atomicInteger.compareAndSet(5,6);
//        System.err.println(atomicInteger.get());
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                atomicInteger.getAndIncrement();
            }).start();
        }
    }
}
