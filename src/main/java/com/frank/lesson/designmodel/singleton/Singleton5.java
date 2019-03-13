package com.frank.lesson.designmodel.singleton;

/**
 * （双重校验锁）JDK1.5之后，双重检查锁定才能够正常达到单例效果。
 */
public class Singleton5 {

    private volatile static Singleton5 singleton;
    private Singleton5 (){}

    private int a = 0;

    public void printA() {
        System.out.println(a);
        a++;
    }

    public static Singleton5 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }
}
