package com.msm.entity;

import java.io.Serializable;
import java.util.Date;

public class User {


    private String Id;

    private String userName;

    private String passWord;

    private Date loginTime;

    private Date lastTime;

    private String userEmail;

    private String userTel;



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }



    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
