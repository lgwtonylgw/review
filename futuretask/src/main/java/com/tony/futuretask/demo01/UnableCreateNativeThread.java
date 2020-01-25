package com.tony.futuretask.demo01;

/**
 * Created on 2020/1/24 14:03.
 *
 * @author Tony
 * @description:
 */
public class UnableCreateNativeThread {
    /**
     * unable to create native thread
     */
    public static void main(String[] args) {
        for(int i=0;;i++){
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
