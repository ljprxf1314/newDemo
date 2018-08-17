package com.ljp.designpatterns.builder.one;

import com.ljp.designpatterns.builder.one.abstraction.Burger;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 汉堡实现类
 *     version: 1.0
 * </pre>
 */

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger(素汉堡)";
    }
}
