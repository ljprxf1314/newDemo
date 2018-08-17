package com.ljp.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class AxeGangPeople implements Observer{

    private String name;

    public AxeGangPeople(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        AxeGangBoss boss;
        if (o instanceof AxeGangBoss){
            boss = (AxeGangBoss) o;
            System.out.println(getName()+"收到来自"+
                    boss.getName()+"的消息:"+arg.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
