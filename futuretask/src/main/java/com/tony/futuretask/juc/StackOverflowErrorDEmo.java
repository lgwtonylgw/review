package com.tony.futuretask.juc;

/**
 * Created on 2020/1/28 15:46.
 *
 * @author Tony
 * @description:
 */
public class StackOverflowErrorDEmo {
    public static void m1(){
        m1();
    }
        //栈溢出异常   属于虚拟机error
    public static void main(String[] args) {
        m1();

    }
}
