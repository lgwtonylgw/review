package com.tony.futuretask.juc;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created on 2020/1/28 20:34.
 *
 * @author Tony
 * @description:
 */
public class completeFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture=CompletableFuture.runAsync(()->{
            System.out.println("aaaaaa");
        });
        CompletableFuture<Integer> completableFuture1=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            int age=10/0;
            return 1024;
        });
        completableFuture1.whenComplete((a,b)->{
            System.out.println(a);
            System.out.println(b);
        }).exceptionally(f->{
            System.out.println(f.getMessage());
            return 4444;
        }).get();


    }
}
