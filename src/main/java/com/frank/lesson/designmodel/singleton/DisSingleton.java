package com.frank.lesson.designmodel.singleton;

/**
 * 这个不是单例模式的对象，用来对照区别
 */
public class DisSingleton {

    private int a = 0;

    public void printA() {
        System.out.println(a);
        a++;
    }
}
