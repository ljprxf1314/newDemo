package com.ljp.designpatterns.builder.one;

import com.ljp.designpatterns.builder.one.abstraction.Burger;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger(肉汉堡)";
    }
}
