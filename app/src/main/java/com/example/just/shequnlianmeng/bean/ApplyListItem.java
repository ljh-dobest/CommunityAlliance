package com.example.just.shequnlianmeng.bean;

/**
 * 应用列表
 * Created by T-BayMax on 2017/3/27.
 */

public class ApplyListItem {


    public CharSequence title; // 标题
    private String appName;
    public String versionName; // 版本名称
    public int versionCode; // 版本号
    private String packageName;
    private int appImg;
    private int status;

    public ApplyListItem(String title, String appName, int appImg, int versionCode, String packageName, int status) {
        this.title=title;
        this.appName = appName;
        this.appImg = appImg;
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.status = status;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
    }


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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
