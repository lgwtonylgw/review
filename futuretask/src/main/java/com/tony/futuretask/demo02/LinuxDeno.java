package com.tony.futuretask.demo02;

/**
 * Created on 2020/1/25 10:46.
 *
 * @author Tony
 * @description:
 */
public class  LinuxDeno {
    /**
     * top uptime   主要查看整机性能     主要看参数load average    和   cpm mem
     * vmstat -n 2 3   主要用来查看cpu
     *          mpstat -P ALL 2  查看所有CPU信息
     *          pidstat -u l -p 进程id   每个进程使用CPU的用户分量
     * free   查看内存     free -g 以g为单位     free -m 以m为单位
     *          pidstat -p 进程号 -r 采样间隔秒数
     * iostat -xdk 2 3 产看系统io情况
     *          pidstat -d 采样间隔时间 -p 进程id
     *ifstat l    查看网络情况
     *ps -mp 进程号 -o THREAD,tid,time    -m显示所有线程   -p  pid进程使用CPU的时间   -o 用户自定义格式
     *              jstack 进程id  | grep tid(进程ID转化为16进制）   -A60    查看CPU使用情况精确到代码行
     *
     */
}
