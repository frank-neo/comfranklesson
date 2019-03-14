package com.frank.lesson.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类我们用来学习lambda表达式
 * Java 8 lambda表达式的语法。你可以使用lambda写出如下代码：
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statements }
 */
public class LambdaDemo {

    //首先清楚一个概念匿名内部类，最常见的就是Runnable接口的实现
    //// Java 8之前：
    @Test
    public void testNiMing() {
        //其中new Runnable() {}就是匿名内部类，他虽然是个具体的实现但是没有名称，是我们直接new出来的。
        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java8之前，代码真长啊！");
            }
        });
        testThread.start();
    }

    /*
     * 1、lambda实现Runnable，代了整个匿名内部类
     */
    @Test
    public void testlambda1() {
        //就选上面的例子，我们简化如下，省略了整个匿名内部类Runnable的实现。
        new Thread(() -> System.out.println("还是我java8厉害！")).start();
    }

    /*
     * 2、使用lambda表达式对列表进行迭代
     */
    @Test
    public void testPrintList() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // Java 8之前：
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------------------分割线---------------------");
        // Java 8之后lambda的写法
        list.forEach(c->System.out.println(c));
    }
    /*
     * 3,日后再更新
     */


}
