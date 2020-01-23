package com.tony.futuretask.demo01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020/1/22 23:04.
 *
 * @author Tony
 * @description:
 */
class MyData1{
    int number=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public  void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "增加数字" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
       public void decrement(){
            lock.lock();
            try {
                while(number==0){
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"减少数字"+number);
                condition.signalAll();
            }catch (Exception e) {
                e.printStackTrace();
            }   finally
            {
                lock.unlock();
            }
        }
}
public class ProdConsumer_TraditionalDemo {
    public static void main(String[] args) {
        MyData1 myData = new MyData1();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.increment();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                myData.decrement();
            }
        }).start();
    }
}
