package com.tony.futuretask.demo01;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created on 2020/1/23 18:30.
 *
 * @author Tony
 * @description:
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<>();
        WeakReference<Object> weakReference=new WeakReference<>(o,referenceQueue);
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        o=null;
        System.gc();
//        Thread.sleep(500);
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
