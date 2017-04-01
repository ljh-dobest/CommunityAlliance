package com.issp.inspiration.bean;

import java.io.Serializable;

/**
 * Created by T-BayMax on 2017/3/30.
 */

public class DealBuyBean implements Serializable {
    private String id;
    private String userId;            //发布用户ID
    private String nickname;         //昵称
    private String userPortraitUrl;     //用户头像
    private String title;             //标题
    private String content;         //非交易内容
    private String image;         //背景图片
    private String time;            //发布时间


    private String dealContribution;   //查看内容交易币
    private String releaseTime;       //发布时间


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserPortraitUrl() {
        return userPortraitUrl;
    }

    public void setUserPortraitUrl(String userPortraitUrl) {
        this.userPortraitUrl = userPortraitUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDealContribution() {
        return dealContribution;
    }

    public void setDealContribution(String dealContribution) {
        this.dealContribution = dealContribution;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}
