package com.ljp.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
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
public class RecordsBean {

    @Id(autoincrement = true)
    private Long id;
    private String account = "";
    private String password = "";
    private String login_time = "";
    private String code = "";


    @Generated(hash = 731306047)
    public RecordsBean(Long id, String account, String password, String login_time,
            String code) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.login_time = login_time;
        this.code = code;
    }

    @Generated(hash = 635267722)
    public RecordsBean() {
    }



    @Override
    public String toString() {
        return "RecordsBean{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", login_time='" + login_time + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getAccount() {
        return this.account;
    }



    public void setAccount(String account) {
        this.account = account;
    }



    public String getPassword() {
        return this.password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getLogin_time() {
        return this.login_time;
    }



    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
