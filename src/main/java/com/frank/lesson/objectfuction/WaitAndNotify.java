package com.frank.lesson.objectfuction;

/**
 * Java多线程学习之wait、notify/notifyAll
 * 这是基本使用格式，具体的看在设计模式包下（designmodel）生产者消费者的例子
 */
public class WaitAndNotify {
    //创建状态锁
    private Object loc;
    //条件标量，用来模拟业务判断逻辑
    private int now, need;

    public void testWaitAndNotify() {
        //同步代码块
        synchronized (loc) {
            //当模拟业务条件不满足时，需要等待
            while (now < need) {
                try {
                    //等待阻塞
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("我被唤醒了！");//现实中为你的业务操作
            notifyAll();//一般不用notify，应为可能会造成死锁。不过根据业务需求，看情况可以使用。
        }
    }
}
