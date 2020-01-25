package com.tony.futuretask.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/1/24 12:53.
 *
 * @author Tony
 * @description: gc回收不过来的错误，大部分cpu被gc线程占用
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> lsit=new ArrayList<>();
        try {
            while(true){
                lsit.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
