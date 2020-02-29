package com.tony.futuretask.designpattern;

/**
 * Created on 2020/2/26 16:47.
 *
 * @author Tony
 * @description:
 */
interface Dog{}
class AA implements Dog{}
class BB implements Dog{}
interface produce{Dog get();}
class FactoryForA implements produce{
    @Override
    public Dog get() {
        return new AA();
    }
}
class FactoryForBB implements produce{
    @Override
    public Dog get() {
        return new BB();
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        Dog x=new FactoryForA().get();
        x=new FactoryForBB().get();
    }
}
