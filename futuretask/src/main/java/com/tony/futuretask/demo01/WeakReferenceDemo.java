package com.tony.futuretask.demo01;

import java.lang.ref.WeakReference;

/**
 * Created on 2020/1/23 17:46.
 *
 * @author Tony
 * @description:  弱引用，不管内存够不够用，都会被回收
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o);
        System.out.println(o);
        System.out.println(weakReference.get());
        o=null;
        System.gc();
        System.out.println(o);
        System.out.println(weakReference.get());
    }
}
