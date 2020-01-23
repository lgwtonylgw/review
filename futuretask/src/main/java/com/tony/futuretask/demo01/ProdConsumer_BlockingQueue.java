package com.tony.futuretask.demo01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/1/23 10:00.
 *
 * @author Tony
 * @description:
 */
class MyResoure{
    private volatile boolean flag=true;
    BlockingQueue<String> queue=null;
    AtomicInteger atomicInteger=new AtomicInteger();

    public MyResoure(BlockingQueue<String> queue) {
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }
    //生产者
    void myProd()  {
        String data=null;
        boolean reData;
        while (flag){
            data=atomicInteger.incrementAndGet()+"";
            try {
                reData=queue.offer(data,2, TimeUnit.SECONDS);
                if(reData){
                    System.out.println(Thread.currentThread().getName()+"插入队列"+data+"成功");
                }else{
                    System.out.println(Thread.currentThread().getName()+"插入队列"+data+"失败");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费者
    void myConsumer()  {
        String data=null;
        while (flag){
            try {
                data=queue.poll(2, TimeUnit.SECONDS);
                if(data==null||data.equalsIgnoreCase("")){
                    System.out.println(Thread.currentThread().getName()+"消费超时，退哦出");
                    flag=false;
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"消费队列"+data+"成功");
        }
    }
    //停止线程
    void stop(){
        flag=false;
    }


}
public class ProdConsumer_BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        MyResoure myResoure=new MyResoure(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println("生产者线程启动");
            myResoure.myProd();

        },"Prod").start();
        new Thread(()->{
            System.out.println("消费者线程启动");
            myResoure.myConsumer();

        },"Consumer").start();
        TimeUnit.SECONDS.sleep(5);
        myResoure.stop();
        System.out.println(Thread.currentThread().getName()+"叫停");

    }
}
