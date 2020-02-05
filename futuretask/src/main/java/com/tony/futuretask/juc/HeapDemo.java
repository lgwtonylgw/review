package com.tony.futuretask.juc;

/**
 * Created on 2020/1/28 15:58.
 *
 * @author Tony
 * @description:
 */
public class HeapDemo {
    /**
     *  新生区    ：  伊甸区   幸存一区  幸存2区
     *  养老区
     *  元空间
     *  -Xms  初始分配内存  默认为物理内存的1/64
     *  -Xmx   最大堆内存  默认为物理内存的1/4        生产环境   初始内存和最大内存必须一样
     *  -XX:+PrintGCDetails  输出GC详细日志
     *   由新生代晋升到老年代要默认达到15次  ，可以调剂参数： -XX:MaxTenuringThreshold=15  来调
     */
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
