package com.frank.lesson.diffwithclazzandint;

/**
 * 接口和抽象类的区别
 *
 * @author FrankLee
 */
public abstract class DiffAbstractClazz {

    //可以有构造器
    DiffAbstractClazz(){
        System.out.println("这是构造器。");
    }

    //这是一个抽象方法【抽象方法必须是public的】
    public abstract String testOne();

    //这是一个私有的方法
    private void testPrivate(){
        System.out.println("这是一个private方法");
    }

    //这是一个方法的实现
    public void testOnePlus() {
        System.out.println("这是一个方法的实现。");
    }
}
