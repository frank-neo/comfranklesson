package com.frank.lesson.ThreadPoolDemo;

/**
 * 这是我们的测试任务，用于给线程池池测试的
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
