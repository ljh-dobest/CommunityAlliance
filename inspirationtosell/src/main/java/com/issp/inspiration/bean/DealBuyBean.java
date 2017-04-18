package com.issp.inspiration.bean;

import java.io.Serializable;

/**
 * Created by T-BayMax on 2017/3/30.
 */

public class DealBuyBean implements Serializable {
    private String id;                //灵感贩卖id
    private String userId;            //发布用户ID
    private String nickname;         //昵称
    private String userPortraitUrl;     //用户头像
    private String title;              //标题
    private String time;
    private String content;          //非交易内容
    /*********文章创建者和已购买者显示字段*************/
    private String dealContent;     //交易内容
    /*********************字段结束**********************/
    private String image;          //背景图片
    private int dealContribution;   //查看内容交易币
    private String releaseTime;      //发布时间
    private int likes;   //点赞数量
    private int statusLikes;        //0未点赞1已点赞
    private int commentNumber;   //评论数量

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDealContent() {
        return dealContent;
    }

    public void setDealContent(String dealContent) {
        this.dealContent = dealContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDealContribution() {
        return dealContribution;
    }

    public void setDealContribution(int dealContribution) {
        this.dealContribution = dealContribution;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getStatusLikes() {
        return statusLikes;
    }

    public void setStatusLikes(int statusLikes) {
        this.statusLikes = statusLikes;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}
