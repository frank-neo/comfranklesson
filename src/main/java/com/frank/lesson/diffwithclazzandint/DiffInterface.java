package com.frank.lesson.diffwithclazzandint;

public interface DiffInterface {

    //在jdk1.8之前，这样写是错的，应为1.8版本之前，接口不可以有自己的方法实现。
    //1.8之后可以有自己的方法实现，但必须被default修饰，默认为public方法，且只能是public。
    default void testOnePlus() {
        System.out.println("这是一个方法的实现。");
    }

    //这是一个抽象方法，默认为public方法，且只能是public。
    public String testOne();
}
