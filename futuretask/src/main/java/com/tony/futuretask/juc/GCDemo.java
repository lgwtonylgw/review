package com.tony.futuretask.juc;

/**
 * Created on 2020/1/28 17:33.
 *
 * @author Tony
 * @description:
 */
public class GCDemo
{
    /**
     * GC回收四大算法：
     *          引用计数法
     *          复制算法
     *          标记清除
     *          标记整理
     *  新生代一般使用复制算法，，而在老年代一般使用标记整理算法   由新生代晋升到老年代要默认达到15次  ，可以调剂参数： -XX:MaxTenuringThreshold=15
     *  eden:feom:to=8:1:1      GYoung:Gold=2:1         */
}
