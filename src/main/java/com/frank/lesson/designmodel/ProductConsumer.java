package com.frank.lesson.designmodel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者，消费者模式
 */
public class ProductConsumer {

    private CangKu cangku = new CangKu();//创建仓库
    //测试方法在最下方

    //生产者
    public void produce() {
        synchronized (this) {
            //仓库满了我们就不生产连【把线程锁让出去】
            while (cangku.isFull()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //没满我们就生产
            cangku.add();
            //当前线程要么wait()，要么add()，代码执行完毕之后，
            // 唤醒其他线程来争抢CPU资源，获得synchronized同步锁。
            notifyAll();
        }
    }

    //消费者
    public void consume() {
        synchronized (this) {
            //仓库空了我们就不消费了
            while (cangku.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有库存我们就消费
            cangku.remove();
            //当前线程要么wait()，要么remove()，代码执行完毕之后，
            // 唤醒其他线程来争抢CPU资源，获得synchronized同步锁。
            notifyAll();
        }
    }

    //内部类[仓库类]
    private class CangKu {
        private static final int MAX_CANGKU = 1;//仓库最大容量为1个位子。
        private List innerList = new ArrayList<>(MAX_CANGKU);

        //仓库添加货物
        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().toString() + "往仓库添加了一个商品。");
        }

        //仓库减少货物
        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.remove(MAX_CANGKU - 1);
            }
            System.out.println(Thread.currentThread().toString() + "库存-1。");
        }

        //查看仓库是否已经满了
        boolean isFull() {
            return innerList.size() == MAX_CANGKU;
        }

        //查看仓库是否已经满了
        boolean isEmpty() {
            return innerList.isEmpty();
        }
    }

    @Test
    public void test() {
        ProductConsumer productConsumer = new ProductConsumer();
        Runnable runProduce = new Runnable() {
            int count = 100;//生产尝试次数

            @Override
            public void run() {
                while (count-- > 0) {
                    productConsumer.produce();
                }
            }
        };
        Runnable runConsume = new Runnable() {
            int count = 100;//消费尝试次数

            @Override
            public void run() {
                while (count-- > 0) {
                    productConsumer.consume();
                }
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(runConsume).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(runProduce).start();
        }
    }

}
