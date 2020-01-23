package com.tony.futuretask.demo01;

/**
 * Created on 2020/1/23 15:46.
 *
 * @author Tony
 * @description:
 */
public class Jinfo {
    //jps -l 查看当前java进程
    //jstack 进程号   查看进程信息
    //jinfo -flag 参数名 进程号   查看参数信息
    //jinfo -flags 进程号    查看所有参数信息
    //XX参数:  -Xms   等价于  -XX:InitialHeapSize   -Xmx  等价于:  -XX:MaxHeapSize

    //查看JVM初始参数：      java -XX:+PrintFlagsInitial
    //查看JVM修改过后的参数 java -XX:+PrintFlagsFinal -version
    //PrintFlagsFinal 运行java命令同时打印参数
    //java -XX:+PrintCommandLineFlags -version

    //查看常用参数
    /**
     * -Xmx:   初始内存大小：默认为物理内存1/64   等价于-XX:InitialHeapSize
     * -Xmx:    最大分配内存  默认为物理内存1/4   等价于：-XX:MaxHeapSize
     * -Xss:    设置单个栈空间的大小   一般默认512K——1024K  等价于：-XX:ThreadStackSize
     * -Xmn:     设置年轻代的大小
     * -XX:MetaspaceSize
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio:
     * -XX:NewRatio:
     * -XX:MaxTenuringThreshold:    设置垃圾的最大年龄
     */
 }
