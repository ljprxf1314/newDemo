package com.ljp.designpatterns.observer;

import java.util.Observable;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/18
 *     desc   : 被观察者
 *     version: 1.0
 * </pre>
 */

public class LaoDaBoss extends Observable {


    private String name;

    public LaoDaBoss(String name) {
        this.name = name;
    }


    //发送消息
    private void sendMsg(String msg) {
        setChanged();//表示有更新
        notifyObservers(msg);//刷新观察者消息队列
    }

    public static void main(String[] arg) {
        LaoDaBoss ld = new LaoDaBoss("张弘范");

        XiaoDi xd1 = new XiaoDi("吴三桂");
        XiaoDi xd2 = new XiaoDi("耿忠明");

        ld.addObserver(xd1);
        ld.addObserver(xd2);

        ld.sendMsg("我有难,快来救我!");
    }

    public String getName() {
        return name;
    }
}
