package com.ala.libmodbusapi;

public interface Define {

    public  int MODBUS_R_BIT = 1;
    public  int MODBUS_R_IN_BIT = 2;
    public  int MODBUS_R_REG = 3;
    public  int MODBUS_R_IN_REG = 4;

    public  int MODBUS_W_BIT = 5;
    public  int MODBUS_W_REG = 6;
    public  int MODBUS_W_REGS = 10;

    public  int MODBUS_W_BITS = 15;
    public  int MODBUS_MASK_W_REGSTER = 16;
    public  int MODBUS_W_R_REGSTERS = 17;
}
