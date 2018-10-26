package com.ljp.designpatterns.observer;

import java.math.BigDecimal;
import java.util.Observable;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class AxeGangBoss extends Observable {

    private String name;

    public AxeGangBoss(String name) {
        this.name = name;
    }

    private void sendMsg(String msg){
        setChanged();//表示有更新
        notifyObservers(msg);//发送消息
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] arg){
//        AxeGangPeople lisi = new AxeGangPeople("李四");
//        AxeGangPeople zhangsan = new AxeGangPeople("张三");
//
//        AxeGangBoss boss = new AxeGangBoss("雄霸天");
//        boss.addObserver(lisi);
//        boss.addObserver(zhangsan);
//
//        boss.sendMsg("我有难,快来救我!");

        BigDecimal bg = new BigDecimal("0.");
        System.out.println(bg.toString());
    }
}
