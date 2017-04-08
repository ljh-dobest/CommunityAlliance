package com.issp.association.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 评论内容
 * Created by T-BayMax on 2017/4/7.
 */

public class CommentsBean implements Serializable{
    private String id;             //评论id
    private String  userId;          //评论用户id
    private String nickname;       //评论用户昵称
    private String userPortraitUrl;   //头像
    private String content;         //评论内容
    private String  commentTime;    //评论时间  Y-m-d  H:i:s
    private List<ReplyUsersBean> replyUsers;//回复用户信息（没有回复为空）

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

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public List<ReplyUsersBean> getReplyUsers() {
        return replyUsers;
    }

    public void setReplyUsers(List<ReplyUsersBean> replyUsers) {
        this.replyUsers = replyUsers;
    }
}
