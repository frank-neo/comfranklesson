package com.frank.lesson.clazzloader;


import org.junit.Test;

/**
 * 类加载器的demo
 */
public class ClazzLoadDemo {
    @Test
    public void test1() {
        //appClassLoader只是一个名字，你叫classLoder也行，只不过他其实就是appClassLoader类，这样容易理解。
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        //我们发现SystemClassLoader是AppClassLoader
        System.out.println("系统类装载器:" + appClassLoader);
        ClassLoader appClassLoaderParent = appClassLoader.getParent();
        //我们发现appClassLoaderParent就是ExtClassLoader
        System.out.println("系统类装载器的父类加载器——扩展类加载器:" + appClassLoaderParent);
        ClassLoader extensionClassLoaderParent = appClassLoaderParent.getParent();
        //我们发现extensionClassLoaderParent是null
        System.out.println("扩展类加载器的父类加载器——引导类加载器:" + extensionClassLoaderParent);
    }
}
