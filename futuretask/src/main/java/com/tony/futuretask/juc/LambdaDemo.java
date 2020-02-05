package com.tony.futuretask.juc;

/**
 * Created on 2020/1/27 23:18.
 *
 * @author Tony
 * @description:
 */
interface Foo{
    int add(int x,int y);
}
public class LambdaDemo {
    public static void main(String[] args) {
        Foo foo=(x,y)->{
            System.out.println("come in lambda");
            return x+y;
        };
        System.out.println(foo.add(3, 8));
    }
}
