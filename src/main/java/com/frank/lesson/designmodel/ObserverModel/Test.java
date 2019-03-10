package com.frank.lesson.designmodel.ObserverModel;

public class Test {

    public static void main(String[] args) {

        WechatServer server = new WechatServer();

        //新建三个观察者
        Observer lishaoxiong = new User("李少雄");
        Observer lisong = new User("李松");
        Observer xuekun = new User("薛坤");

        //注册这三个人
        server.registerObserver(lishaoxiong);
        server.registerObserver(lisong);
        server.registerObserver(xuekun);

        //被观察者发布消息（做出更改）
        server.setInfomation("泗泾三人中有一个是帅逼");

        System.out.println("----------------------------------------------");

        //删除一个观察者重新发布消息
        server.removeObserver(lisong);
        server.setInfomation("单人影");


    }
}
