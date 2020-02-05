package com.tony.futuretask.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created on 2020/1/27 23:45.
 *
 * @author Tony
 * @description:
 */
public class ArrayLiastDemo {
    /**
     * arraaylist扩容  初始容量10   然后每次扩容一般      map  初始容量16  每次扩容一倍
     *
     */
    public static void main(String[] args) {
        //线程安全的集合
        List<String> list= Collections.synchronizedList(new ArrayList<>());
        List<String> list1=new Vector<>();
        List<String> list2=new CopyOnWriteArrayList<>();
        //set同理

    }
}
