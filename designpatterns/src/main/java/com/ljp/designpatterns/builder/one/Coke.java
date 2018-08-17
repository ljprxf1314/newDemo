package com.ljp.designpatterns.builder.one;

import com.ljp.designpatterns.builder.one.abstraction.ColdDrink;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke(可乐)";
    }
}
