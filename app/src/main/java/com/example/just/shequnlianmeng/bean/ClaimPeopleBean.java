package com.example.just.shequnlianmeng.bean;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimPeopleBean {
    private String recommendId;
    private String fullName;
    private String nickname;
    private String numberId;
    private String userPortraitUrl;
    private String userId;

    public ClaimPeopleBean(String recommendId, String fullName, String nickname, String numberId, String userPortraitUrl, String userId) {
        this.recommendId = recommendId;
        this.fullName = fullName;
        this.nickname = nickname;
        this.numberId = numberId;
        this.userPortraitUrl = userPortraitUrl;
        this.userId = userId;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getUserPortraitUrl() {
        return userPortraitUrl;
    }

    public void setUserPortraitUrl(String userPortraitUrl) {
        this.userPortraitUrl = userPortraitUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
