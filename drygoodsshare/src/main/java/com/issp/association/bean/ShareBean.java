package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareBean implements Serializable{
    private String userId;
    private String nickname;       //用户昵称
    private String userPortraitUrl;   //用户头像
    private String id;              //干货id
    private String title;            //标题
    private String synopsis;        //简介内容
    private String content;         //干货内容
    private String image;          //图片
    private String time;           //发布时间
    private int likes;           //点赞总数
    private int likesStatus;   //1当前用户已点赞 0未点赞
    private int commentNumber;   //评论数量
    private int collectionNumber; //收藏数量

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikesStatus() {
        return likesStatus;
    }

    public void setLikesStatus(int likesStatus) {
        this.likesStatus = likesStatus;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }
}
