package com.frank.lesson.ThreadPoolDemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * java1.7版本线程池的学习
 */
public class TestThreadPool {
    //首先我们要会使用。

    //要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，
    // 很有可能配置的线程池不是较优的，因此在Executors类里面提供了一些静态工厂，生成一些常用的线程池。

    //newSingleThreadExecutor：创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
    //如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。

    //newFixedThreadPool：创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。

    //线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。

    //newCachedThreadPool：创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，
    //当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
    //此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。【如果一瞬间线程数很大，可能会造成jvm内存溢出】

    //newScheduledThreadPool：创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
    //newSingleThreadExecutor：创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求。

    //这些方法的返回值是ExecutorService对象，该对象表示一个线程池，可以执行Runnable对象或者Callable对象代表的线程。
    //它提供了如下方法来提交一个任务:
    //Future<?> submit(Runnable task)
    //<T> Future<T> submit(Callable<T> task)

    @Test
    public void testThreadPoolDemo() {
        //通过静态工厂创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);

        //可以执行Runnable对象或者Callable对象代表的线程,通过submit方法。
        for (int i = 0; i < 1000000; i++) {
            pool.submit(new MyRunnable());
        }
        //newFixedThreadPool是固定大小的线程池，从结果就可以看出，虽然创建五个线程，但是线程池最大只有3个。
        //值得注意的是：线程池最大只有3个不是说只能执行最多3个线程的任务，
        // 而是把多余的任务放到了LinkedBlockingQueue<Runnable>()中。LinkedBlockingQueue<Runnable>()的默认大小为Integer.MAX_VALUE
        //看源码都能看到！

        //一般情况下
        /*如果是CPU密集型应用，则线程池大小设置为N+1
        如果是IO密集型应用，则线程池大小设置为2N+1*/


    }

    //最后说面一下除了工厂模式外，我们使用ThreadPoolExecutor【工厂模式的四种线程池也是在这个基础上配置好的】的注意事项。
    @Test
    public void testThreadPoolExecutor() {
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
    //可在ThreadPoolExecutor构造器参数里面设置拒绝策略，不设置就是默认的
}
