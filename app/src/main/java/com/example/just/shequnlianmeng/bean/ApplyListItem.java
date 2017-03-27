package com.example.just.shequnlianmeng.bean;

/**
 * 应用列表
 * Created by T-BayMax on 2017/3/27.
 */

public class ApplyListItem {
    private String appName;
    private int appImg;
    private int status;

    public ApplyListItem(String appName, int appImg, int status) {
        this.appName = appName;
        this.appImg = appImg;
        this.status = status;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppImg() {
        return appImg;
    }

    public void setAppImg(int appImg) {
        this.appImg = appImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
