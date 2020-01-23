package com.tony.futuretask.demo01;

import java.lang.ref.SoftReference;

/**
 * Created on 2020/1/23 17:29.
 *
 * @author Tony
 * @description:
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
//        a1();
        a2();
    }
    //内存没有满之前
    static void a1(){
        Object o=new Object();
        SoftReference<Object> softReference=new SoftReference<>(o);
        System.out.println(o);
        o=null;
        System.gc();
        System.out.println(o);
        System.out.println(softReference.get());
    }
    //内存满了之后,软引用就会被回收
    static void a2(){
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());
        o=null;
//        System.gc();
        try {
            byte[] bytes=new byte[30*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }

    }

}
