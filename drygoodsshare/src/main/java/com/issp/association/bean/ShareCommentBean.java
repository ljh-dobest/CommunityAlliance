package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享评论
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareCommentBean implements Serializable {
    private ShareBean shareId;//干货分享id
    private UserBean userId;//评论用户id
    private String content;	//评论内容
    private String commentTime;//  评论时间

    public ShareBean getShareId() {
        return shareId;
    }

    public void setShareId(ShareBean shareId) {
        this.shareId = shareId;
    }

    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
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
