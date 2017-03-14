package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享点赞
 * Created by T-BayMax on 2017/3/13.
 */

public class SharePraiseBean implements Serializable {
    private ShareBean shareId;//干货分享id
    private UserBean userId;//点赞用户id
    private int praise;//点赞（0不赞同1赞同）
    private String praiseTime;//点赞时间

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

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public String getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(String praiseTime) {
        this.praiseTime = praiseTime;
    }
}
