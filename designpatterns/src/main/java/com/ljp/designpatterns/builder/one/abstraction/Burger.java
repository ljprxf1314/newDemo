package com.ljp.designpatterns.builder.one.abstraction;

import com.ljp.designpatterns.builder.one.Wrapper;
import com.ljp.designpatterns.builder.one.inteface.Item;
import com.ljp.designpatterns.builder.one.inteface.Packing;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 食物汉堡
 *     version: 1.0
 * </pre>
 */

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
