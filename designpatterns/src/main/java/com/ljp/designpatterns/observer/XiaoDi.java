package com.ljp.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class XiaoDi implements Observer {

    private String name;

    public XiaoDi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        LaoDaBoss ld;
        if (o instanceof LaoDaBoss){
            ld = (LaoDaBoss) o;
            System.out.println(ld.getName()+"发来消息--"+getName()+"收到消息:"+arg.toString());
        }
    }
}
