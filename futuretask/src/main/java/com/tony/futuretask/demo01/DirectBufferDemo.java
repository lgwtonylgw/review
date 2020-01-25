package com.tony.futuretask.demo01;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/1/24 13:47.
 *
 * @author Tony
 * @description:
 */
public class DirectBufferDemo {
  //直接内存溢出   nio编程时会用到

    /**
     * -Xmx10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     * @param args
     */
  public static void main(String[] args) throws InterruptedException {
      System.out.println("配置的maxDirectMemorySize:"+sun.misc.VM.maxDirectMemory());
      TimeUnit.SECONDS.sleep(1);
      ByteBuffer byteBuffer=ByteBuffer.allocateDirect(6*102481014);
  }
}
