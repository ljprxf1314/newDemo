package com.ljp.designpatterns.builder;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 定义组装的过程
 *     version: 1.0
 * </pre>
 */

public abstract class Builder {

    //第一步：装CPU
    //声明为抽象方法，具体由子类实现
    public abstract void  BuildCPU();

    //第二步：装主板
    //声明为抽象方法，具体由子类实现
    public abstract void BuildMainboard();

    //第三步：装硬盘
    //声明为抽象方法，具体由子类实现
    public abstract void BuildHD();

    //返回产品的方法：获得组装好的电脑
    public abstract Computer GetComputer();

}
