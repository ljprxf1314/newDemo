package com.ljp.designpatterns.builder.one.abstraction;

import com.ljp.designpatterns.builder.one.Bottle;
import com.ljp.designpatterns.builder.one.inteface.Item;
import com.ljp.designpatterns.builder.one.inteface.Packing;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 饮料
 *     version: 1.0
 * </pre>
 */

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
