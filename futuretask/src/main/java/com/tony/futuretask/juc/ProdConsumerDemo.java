package com.tony.futuretask.juc;

/**
 * Created on 2020/1/28 11:08.
 *
 * @author Tony
 * @description:   虚假唤醒  不再去判断if    如果换成while还会重新判断一次条件
 * 多线程循环判断必须用while
 *        synchronized                                  lock     lock.newCondition()
 *    wait()         notifyAll()   condition.await()      condition.signalAll()
 */
class AirCondition{
    private    int number=0;
    synchronized void add(){
        while(number!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }
    synchronized void decr(){
        while(number==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
       this.notifyAll();
    }
}

public class ProdConsumerDemo {
    public static void main(String[] args) {
        AirCondition airCondition=new AirCondition();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                airCondition.add();
            },"A").start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                airCondition.decr();
            },"B").start();
        }
    }
}
