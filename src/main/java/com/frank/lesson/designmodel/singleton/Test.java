package com.frank.lesson.designmodel.singleton;

public class Test {

    public static void main(String args[]) {

        System.out.println("-----------------------------多例------------------------");
        //测试非单例模式产生的对象。
        for (int i = 0; i < 10; i++) {
            DisSingleton disSingleton = new DisSingleton();
            disSingleton.printA();
        }

        System.out.println("-----------------------------单例------------------------");
        //单例模式产生的对象。
//        for (int i = 0; i < 10; i++) {
//            Singleton singleton = Singleton.getInstance();
//            singleton.printA();
//        }

//        for (int i = 0; i < 10; i++) {
//            Singleton1 singleton1 = Singleton1.getInstance();
//            singleton1.printA();
//        }

//        for (int i = 0; i < 10; i++) {
//            Singleton2 singleton2 = Singleton2.getInstance();
//            singleton2.printA();
//        }

//        for (int i = 0; i < 10; i++) {
//            Singleton3 singleton3 = Singleton3.getInstance();
//            singleton3.printA();
//        }

//        for (int i = 0; i < 10; i++) {
//            Singleton4 singleton4 = Singleton4.INSTANCE;
//            singleton4.printA();
//        }

        for (int i = 0; i < 10; i++) {
            Singleton5 singleton5 = Singleton5.getSingleton();
            singleton5.printA();
        }
    }
}
