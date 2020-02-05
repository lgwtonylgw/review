package com.tony.futuretask.juc;

/**
 * Created on 2020/1/28 14:04.
 *
 * @author Tony
 * @description:
 */
class MyObject{

}
public class ClassLoaderDemo
{
    /**
     *虚拟机自带的加载器
     *          1.Bootstrap   启动类加载器  C++
     *          2.Extension  拓展类加载器   java
     *          3.AppClassLoader   应用程序类加载器   java
     *
     *
     *          双亲委派：如果一个类加载器收到了加载某个类的请求,则该类加载器并不会去加载该类,而是把这个请求委派给父类加载器,
     *          每一个层次的类加载器都是如此,因此所有的类加载请求最终都会传送到顶端的启动类加载器;
     *          只有当父类加载器在其搜索范围内无法找到所需的类,并将该结果反馈给子类加载器,子类加载器会尝试去自己加载。
     */
    public static void main(String[] args) {
        Object o = new Object();
        MyObject myObject = new MyObject();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());

    }
}
