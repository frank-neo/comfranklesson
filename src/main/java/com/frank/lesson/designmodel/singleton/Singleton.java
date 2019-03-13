package com.frank.lesson.designmodel.singleton;

/**
 * 单例模式（懒汉，线程不安全）
 * 在多线程不能正常工作。
 */
public class Singleton {

    private static Singleton instance;

    private int a = 0;

    //私有化构造器
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printA() {
        System.out.println(a);
        a++;
    }

}
