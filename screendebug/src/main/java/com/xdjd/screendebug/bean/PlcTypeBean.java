package com.xdjd.screendebug.bean;

/**
 * Created by Administrator on 2018/10/24.
 */

public class PlcTypeBean {

    private String name;//名称
    private String code;//编号
    private int addr;//plc地址
    private int functionCode;//功能码

    /**
     *
     * @param code 编号
     * @param name 名称
     * @param addr 地址
     * @param functionCode 功能码
     */
    public PlcTypeBean(String code, String name, int addr, int functionCode) {
        this.name = name;
        this.code = code;
        this.addr = addr;
        this.functionCode = functionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }

    public int getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }
}
