package com.issp.inspiration.bean;

import java.io.Serializable;

/**
 *
 * 用户表
 * Created by T-BayMax on 2017/3/13.
 */

public class UserBean implements Serializable {
   /* private String tu_id;    //用户id1(电话号码)
    private String userid;    //用户id2
    private String token;    //token
    private String nickname;    //昵称
    private String password;    //密码
    private int sex;            //性别(0保密，1男，2女)
    private String email;       //邮箱
    private String mobile;      //电话号码
    private String address;     //地址
    private String birth_date;    //生日
    private int age;            //年龄
    private String avatar_id;    //头像id(外键)
    private int status;         //登录状态（0，禁止登录，1，正常登录）
    private String gen_time;    //注册时间
    private String login_time;      //登录时间
    private String last_login_time;    //上一次登录时间
    private String login_ip;        //登录ip
    private int online;         //用户在线状态
    private int count;       //登录次数*/
   private String  userId;
    private String token;
    private String nickname;
    private int sex;
    private String mobile;
    private String address;
    private String birthday;
    private int age;
    private String email;
    private String userPortraitUrl;
    private String recommendUserId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPortraitUrl() {
        return userPortraitUrl;
    }

    public void setUserPortraitUrl(String userPortraitUrl) {
        this.userPortraitUrl = userPortraitUrl;
    }

    public String getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(String recommendUserId) {
        this.recommendUserId = recommendUserId;
    }
}
