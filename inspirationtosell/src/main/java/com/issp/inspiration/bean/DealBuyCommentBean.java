package com.issp.inspiration.bean;

import java.io.Serializable;

/**
 *
 * 灵感贩卖评论
 * Created by T-BayMax on 2017/3/13.
 */

public class DealBuyCommentBean implements Serializable {
    private DealBuyBean shareId;//干灵感贩卖id
    private String userId;//评论用户id
    private String nickname;
    private String avatarImage;
    private String content;	//评论内容
    private String commentTime;//  评论时间

    public DealBuyBean getShareId() {
        return shareId;
    }

    public void setShareId(DealBuyBean shareId) {
        this.shareId = shareId;
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

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
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
}
