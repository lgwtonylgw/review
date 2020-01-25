package com.tony.futuretask.demo02;

/**
 * Created on 2020/1/24 15:30.
 *
 * @author Tony
 * @description:
 * 思想：  引用计数  复制   标记清除  标记清理
 * 回收器：  串行回收
 *            并行回收
 *             并发回收
 *             G1
 */

public class GCDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
