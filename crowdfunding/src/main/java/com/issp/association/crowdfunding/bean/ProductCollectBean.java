package com.issp.association.crowdfunding.bean;

import java.io.Serializable;

/**
 * 产品众筹
 * Created by T-BayMax on 2017/3/21.
 */

public class ProductCollectBean implements Serializable {
    private String id;    //众筹id
    private String nickname;
    private String userPortraitUrl;
    private String objective;//众筹目的
    private double capital;//需众筹总金额
    private double contribution;//已筹备资金
    private double percent;//已筹备百分比
    private String image;//众筹主图
    private double days;//剩余筹备天数
    private int likeStatus;//是否点赞 0未点赞，1已点赞
    private int likes;//点赞数量

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
