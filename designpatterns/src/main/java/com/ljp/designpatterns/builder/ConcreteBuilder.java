package com.ljp.designpatterns.builder;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   : 装机人员
 *     version: 1.0
 * </pre>
 */

public class ConcreteBuilder extends Builder {
    //创建产品实例
    Computer computer = new Computer();

    //组装产品
    @Override
    public void  BuildCPU(){
        computer.Add("组装CPU");
    }

    @Override
    public void  BuildMainboard(){
        computer.Add("组装主板");
    }

    @Override
    public void  BuildHD(){
        computer.Add("组装主板");
    }

    //返回组装成功的电脑
    @Override
    public  Computer GetComputer(){
        return computer;
    }
}
