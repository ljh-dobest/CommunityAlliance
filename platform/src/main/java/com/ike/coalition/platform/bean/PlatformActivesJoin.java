package com.ike.coalition.platform.bean;

import java.io.Serializable;

/**
 * 平台活动报名
 * Created by T-BayMax on 2017/4/15.
 */

public class PlatformActivesJoin implements Serializable {
    private String userId;               //当前用户id
    private String activesId;             //活动id
    private String userName;           //姓名
    private int mobile;             //电话
    private String wechat;            //微信
    private String company;            //公司

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivesId() {
        return activesId;
    }

    public void setActivesId(String activesId) {
        this.activesId = activesId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
