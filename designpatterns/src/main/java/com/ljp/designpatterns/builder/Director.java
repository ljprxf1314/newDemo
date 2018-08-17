package com.ljp.designpatterns.builder;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class Director {

    public void Construct(Builder builder) {
        builder. BuildCPU();
        builder.BuildMainboard();
        builder. BuildHD();
    }
}
