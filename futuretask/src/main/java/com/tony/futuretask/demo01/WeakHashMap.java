package com.tony.futuretask.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/1/23 18:08.
 *
 * @author Tony
 * @description:
 */
public class WeakHashMap {
    public static void main(String[] args) {
        myhashMap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        Map<Integer,String> map=new java.util.WeakHashMap<>();
        Integer key=new Integer(2);
        String value="WeakhashMap";
        map.put(key,value);
        System.out.println(map);
        key=null;
        System.gc();
        System.out.println(map+"   "+map.size());
    }

    private static void myhashMap() {
        Map<Integer,String> map=new HashMap<>();
        Integer key=new Integer(1);
        String value="hashMap";
        map.put(key,value);
        System.out.println(map);
        key=null;
        System.gc();
        System.out.println(map+"   "+map.size());
    }

}
