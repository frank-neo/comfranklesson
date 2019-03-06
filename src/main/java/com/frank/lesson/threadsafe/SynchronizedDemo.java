package com.frank.lesson.threadsafe;

import org.junit.Test;

/**
 * 线程安全syncronized关键字使用实例
 */
public class SynchronizedDemo {
    @Test
    public void doTest() {
        //创建5个线程去抢占业务执行资源
        for (int index = 0; index < 6; index++) {
            Mythread temp = new Mythread();
            temp.start();
        }
    }

    @Test
    public void doTest1() {
        // 创建10个线程来调用【同一个】TestForSynchronized实例(对象)
        TestServices testServices = new TestServices();
        for (int index = 0; index < 10; index++) {
            Mythread1 temp1 = new Mythread1(testServices);
            temp1.start();
        }
    }
}

//注意，这里不是内部类【内部类包在里面，权限也不同。这里上下会生成两个.class文件】
class Mythread extends Thread {
    //这是放到方法区的变量，去营造脏读效果
    private static int a;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //假设我们的业务就是i从0自增到4.
            //System.out.println(Thread.currentThread().getName() + ": [" + i + "]");
            //脏读【并不是012346...这种顺序自增，也就是说有的线程在打印输出方法println还没执行结束的时候，
            // 别的线程就已经拿到更新的a值println出来了】
            System.out.println(Thread.currentThread().getName() + ": [" + a++ + "]");
        }
    }
}

/**
 * 接下来我们进行一些修改，让他实现线程安全。
 */
//首先把自增业务抽里出来，写成一个原子性方法，方便我们修改,引用,操作。
class TestServices {
    private static int a = 0;

    //synchronized方法块（对象级）
    public String ValueA_01() {
        synchronized (this) {
            a++;//【之前是自增5，我们为了方便就自增一代替】
            return "ValueA_01() a =" + a;
        }
    }

    //synchronized块(类级别)
    public String ValueA_02() {
        synchronized (TestServices.class) {
            a++;
            return "ValueA_02() a =" + a;
        }
    }

    //synchronized 方法
    public synchronized String ValueA_03() {
        a++;
        return "ValueA_03() a =" + a;
    }

    //用来对比的普通方法
    public String ValueA_Commen() {
        a++;
        return "ValueA_Commen() a =" + a;
    }
}

//按章之前的样子创建多线程
class Mythread1 extends Thread {

    //引入业务类，实例化
    TestServices testServices;

    //自定义构造器
    public Mythread1(TestServices testServices) {
        this.testServices = testServices;
    }

    @Override
    public void run() {

        //可以修改下面注释，然后执行SynchronizedDemo的doTest1（）方法查看效果。
        //System.out.println(Thread.currentThread().getName() + "--" + testServices.ValueA_Commen());
        //System.out.println(Thread.currentThread().getName() + "--"+testServices.ValueA_01());
        //System.out.println(Thread.currentThread().getName() + "--"+testServices.ValueA_02());
        System.out.println(Thread.currentThread().getName() + "--"+testServices.ValueA_03());
    }
    //详细解说见印象笔记Java问题：一个JAVA文件可以写几个Class类？
}