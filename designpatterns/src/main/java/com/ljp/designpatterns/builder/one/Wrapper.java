package com.ljp.designpatterns.builder.one;

import com.ljp.designpatterns.builder.one.inteface.Packing;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 纸--包装实现类
 *     version: 1.0
 * </pre>
 */

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return  "Wrapper";
    }
}
