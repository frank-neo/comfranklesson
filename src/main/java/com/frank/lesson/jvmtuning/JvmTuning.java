package com.frank.lesson.jvmtuning;

import org.junit.Test;

/**
 * jvm调优的例子
 */
public class JvmTuning {

    static int i;
    //先让jvm里面有强引用的对象
    @Test
    public void test1(){
        while(true){
            System.out.println("...."+i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
