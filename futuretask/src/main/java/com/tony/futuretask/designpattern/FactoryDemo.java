package com.tony.futuretask.designpattern;

import com.tony.futuretask.streamDemo.Status;

/**
 * Created on 2020/2/26 16:38.
 *
 * @author Tony
 * @description:
 */
public class FactoryDemo {
    public static void get(String name) {
        Food x=null;
        if("A".equals(name)){
            x=StaticFactory.getA();
        }else if("B".equals(name)){
            x=StaticFactory.getB();
        }else if("C".equals(name)){
            x=StaticFactory.getC();
        }
    }
}
interface Food{};
class A implements Food{};
class B implements Food{};
class C implements Food{};
class StaticFactory{
    private StaticFactory(){};
    public static Food getA(){return new A();}
    public static Food getB(){return new B();}
    public static Food getC(){return new C();}
}
