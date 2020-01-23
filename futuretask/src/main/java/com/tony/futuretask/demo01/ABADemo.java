package com.tony.futuretask.demo01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created on 2020/1/22 15:57.
 *
 * @author Tony
 * @description:
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference =new AtomicReference<>(100);
    public static void main(String[] args) {
//        new AtomicStampedReference<>()
    }
}
