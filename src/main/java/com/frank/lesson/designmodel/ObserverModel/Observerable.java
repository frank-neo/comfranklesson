package com.frank.lesson.designmodel.ObserverModel;

/***
 * 抽象 被 观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author jstao
 *
 */
public interface Observerable {

    //添加观察者
    public void registerObserver(Observer o);

    //删除观察者
    public void removeObserver(Observer o);

    //通知观察者
    public void notifyObserver();

}