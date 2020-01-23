package com.tony.futuretask.demo01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/1/22 22:01.
 *
 * @author Tony
 * @description:
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
        try {
            System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("b", 2, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("c", 2, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
