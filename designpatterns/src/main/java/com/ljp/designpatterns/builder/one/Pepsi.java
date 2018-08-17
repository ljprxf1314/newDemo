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

public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi(百事可乐)";
    }
}
