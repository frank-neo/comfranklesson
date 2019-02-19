package com.frank.lesson.diffwithclazzandint;

public class TestApp {

    public static void main(String args[]){
        System.out.println("**********抽象类测试类**********");
        TestAbsClazz ta = new TestAbsClazz();
        System.out.println("testOnef返回值：" + ta.testOne());
        ta.testOnePlus();
        System.out.println("**********接口测试类**********");
        TestInterface ti = new TestInterface();
        System.out.println("testOnef返回值：" + ti.testOne());
        ti.testOnePlus();
    }
}
