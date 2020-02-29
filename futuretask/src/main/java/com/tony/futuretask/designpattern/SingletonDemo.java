package com.tony.futuretask.designpattern;

/**
 * Created on 2020/2/26 16:26.
 *
 * @author Tony
 * @description:
 */
//懒汉模式
public class SingletonDemo {
    private static volatile SingletonDemo instance=null;
    private SingletonDemo(){}
    public static synchronized SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(SingletonDemo.getInstance());
        }
    }
}
