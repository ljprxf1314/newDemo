package com.ljp.plcstoredemo.bean;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/10/26
 *     desc   : 格子补货操作bean
 *     version: 1.0
 * </pre>
 */

public class StoreBoxBean {
    private int code;//水柜格子显示的编号
    private int locationCode;//实际补货给plc的位置编号
    private String boxStatus;//格子库存状态  1.满格(有水) 2.空格 3.补水选中的格子 4.当前夹子所在的位置(有水)
    private int waterNum;//当前取水格子水的数量(只有boxStatus为4时有用)

    /**
     *
     * @param code 水柜格子显示的编号
     * @param locationCode 实际补货给plc的位置编号
     * @param boxStatus 格子库存状态  1.满格(有水) 2.空格 3.补水选中的格子 4.当前夹子所在的位置(有水)
     * @param waterNum 当前取水格子水的数量,非必填
     */
    public StoreBoxBean(int code, int locationCode, String boxStatus, int waterNum) {
        this.code = code;
        this.locationCode = locationCode;
        this.boxStatus = boxStatus;
        this.waterNum = waterNum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    public String getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(String boxStatus) {
        this.boxStatus = boxStatus;
    }

    public int getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(int waterNum) {
        this.waterNum = waterNum;
    }
}
