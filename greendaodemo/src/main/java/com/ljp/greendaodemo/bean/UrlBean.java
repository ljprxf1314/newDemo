package com.ljp.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Entity
public class UrlBean {

    @Id
    private String id;

    private String ip;
    private String domain_name;
    private String is_select;//0是未使用,1是使用

    @Generated(hash = 681249800)
    public UrlBean(String id, String ip, String domain_name, String is_select) {
        this.id = id;
        this.ip = ip;
        this.domain_name = domain_name;
        this.is_select = is_select;
    }

    @Generated(hash = 241588977)
    public UrlBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getIs_select() {
        return is_select;
    }

    public void setIs_select(String is_select) {
        this.is_select = is_select;
    }
}
