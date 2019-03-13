package com.frank.lesson.designmodel.singleton;

/**
 * （枚举）
 */
public enum Singleton4 {
    INSTANCE;

    private int a = 0;

    public void printA() {
        System.out.println(a);
        a++;
    }
}
