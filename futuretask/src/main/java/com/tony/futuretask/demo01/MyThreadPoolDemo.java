package com.tony.futuretask.demo01;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created on 2020/1/23 11:09.
 *
 * @author Tony
 * @description:
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("=====策略线程====pool==%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 8; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"正在执行");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
