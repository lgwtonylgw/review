package com.tony.futuretask.demo01;

/**
 * Created on 2020/1/24 12:17.
 *
 * @author Tony
 * @description:
 */
public class OutOfMemoryDemo {
    public static void main(String[] args) {
        String a="tony";
        while(true){
            a+=a+(new String("12312312"))+(new String("bbbbbb"));
            a.intern();
        }
    }
}
