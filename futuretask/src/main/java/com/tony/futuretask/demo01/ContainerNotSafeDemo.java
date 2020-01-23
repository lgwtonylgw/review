package com.tony.futuretask.demo01;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created on 2020/1/22 16:08.
 *
 * @author Tony
 * @description:
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list= Arrays.asList("a","b","c");
//        list.forEach(System.out::println);
        //线程安全的集合
        new Vector<>();
        Collections.synchronizedList(new ArrayList<>());
        new CopyOnWriteArrayList<>();
        //java.util.concurrentModificationException();
        List<String> list=new CopyOnWriteArrayList<>();//读写分离的思想，写时复制。
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list.toString());
            }).start();
        }

        Set<String> set=new HashSet<>();

        Collections.synchronizedSet(new HashSet<>());
        new CopyOnWriteArraySet<>();


    }
}
