package com.tony.futuretask.demo01;

/**
 * Created on 2020/1/24 12:06.
 *
 * @author Tony
 * @description:   栈溢出，方法太多
 */
public class StackOverflowDemo {
    public static void main(String[] args) {
        stackOverflow();
    }

    private static void stackOverflow() {
        stackOverflow();
    }
}
