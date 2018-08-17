package com.ljp.designpatterns.builder.one.inteface;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 食物条目的接口
 *     version: 1.0
 * </pre>
 */

public interface Item {

    public String name();//食物名称
    public Packing packing();//食物包装
    public float price();//价格
}
