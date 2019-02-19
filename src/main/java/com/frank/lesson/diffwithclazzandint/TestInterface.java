package com.frank.lesson.diffwithclazzandint;

//一个测试类可以去实现多个接口。也就是我们所说的“多实现”。
public class TestInterface implements DiffInterface, DiffInterfaceTwo {

    //实现的接口中抽象方法必须被重写。
    @Override
    public String testOne() {
        return "测试";
    }
}
