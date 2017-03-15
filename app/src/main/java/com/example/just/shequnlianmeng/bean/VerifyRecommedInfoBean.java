package com.example.just.shequnlianmeng.bean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/10.
 */

public class VerifyRecommedInfoBean {
    private String userId;
    private String fullName;
    private String mobile;
    private String SfullName;
    private String sex;
    private ArrayList<String> hobby;
    private ArrayList<String> address;
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String degree;
    private String company;
    private String position;
    private String email;
    private String QQ;
    private String wechat;

    public VerifyRecommedInfoBean(String userId, String fullName, String mobile, String sfullName, String sex, ArrayList<String> hobby, ArrayList<String> address, String birthday, String homeplace, String finishSchool, String degree, String company, String position, String email, String QQ, String wechat) {
        this.userId = userId;
        this.fullName = fullName;
        this.mobile = mobile;
        SfullName = sfullName;
        this.sex = sex;
        this.hobby = hobby;
        this.address = address;
        this.birthday = birthday;
        this.homeplace = homeplace;
        this.finishSchool = finishSchool;
        this.degree = degree;
        this.company = company;
        this.position = position;
        this.email = email;
        this.QQ = QQ;
        this.wechat = wechat;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSfullName() {
        return SfullName;
    }

    public void setSfullName(String sfullName) {
        SfullName = sfullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getHobby() {
        return hobby;
    }

    public void setHobby(ArrayList<String> hobby) {
        this.hobby = hobby;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }

    public String getFinishSchool() {
        return finishSchool;
    }

    public void setFinishSchool(String finishSchool) {
        this.finishSchool = finishSchool;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
