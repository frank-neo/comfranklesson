package com.frank.lesson.designmodel.singleton;

/**
 * 单例模式（懒汉，线程安全,效率低）
 * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是，遗憾的是，效率很低，99%情况下不需要同步。
 */
public class Singleton1 {

    private static Singleton1 instance;

    private int a = 0;

    public void printA() {
        System.out.println(a);
        a++;
    }

    //私有化构造器
    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
