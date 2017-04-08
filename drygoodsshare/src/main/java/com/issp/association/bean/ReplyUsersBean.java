package com.issp.association.bean;

import java.io.Serializable;

/**
 * 回复用户信息（没有回复为空）
 * Created by T-BayMax on 2017/4/7.
 */

public class ReplyUsersBean implements Serializable {
    private String id;               //评论id
    private String userId;           //回复用户id
    private String nickname;        //回复昵称
    private String userPortraitUrl;   //回复用户头像
    private String content;          //回复内容
    private String fromId;          //回复id
    private String fromUserId;      //被回复用户id
    private String fromNickname;    //被回复用户昵称
    private String fromPortraitUrl;     //被回复头像
    private String commentTime;      //回复时间

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFromPortraitUrl() {
        return fromPortraitUrl;
    }

    public void setFromPortraitUrl(String fromPortraitUrl) {
        this.fromPortraitUrl = fromPortraitUrl;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}
