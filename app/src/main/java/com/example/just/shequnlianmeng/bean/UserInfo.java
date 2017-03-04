package com.example.just.shequnlianmeng.bean;

/**
 * Created by Min on 2017/3/4.
 */

public class UserInfo  {
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

    public UserInfo(String userId, String token, String nickname, int sex, String mobile, String address, String birthday, int age, String email, String userPortraitUrl, String recommendUserId) {
        this.userId = userId;
        this.token = token;
        this.nickname = nickname;
        this.sex = sex;
        this.mobile = mobile;
        this.address = address;
        this.birthday = birthday;
        this.age = age;
        this.email = email;
        this.userPortraitUrl = userPortraitUrl;
        this.recommendUserId = recommendUserId;
    }

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
