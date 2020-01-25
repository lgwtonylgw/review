package com.tony.futuretask.demo01;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created on 2020/1/24 14:40.
 *
 * @author Tony
 * @description:
 */
public class MetaspaceOOM {
    /**
     * 元空间内存溢出   元空间用来存储字节码文件（类信息） 静态常量，常量池
     * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
     */
    static  class MetaOOMTest{

    }
    public static void main(String[] args) {
        int i=0;
        try {
            while(true){
                i++;
                Enhancer enhancer=new Enhancer();
                enhancer.setSuperclass(MetaOOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(0,args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
