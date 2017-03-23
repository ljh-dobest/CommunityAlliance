package com.issp.association.crowdfunding.bean;

import java.io.Serializable;

/**
 *
 * 产品众筹评论
 * Created by T-BayMax on 2017/3/13.
 */

public class ProductCommentBean implements Serializable {
    private ProductCollectBean productCollectId;//干货分享id
    private UserBean userId;//评论用户id
    private String content;	//评论内容
    private String commentTime;//  评论时间

    public ProductCollectBean getProductCollectId() {
        return productCollectId;
    }

    public void setProductCollectId(ProductCollectBean productCollectId) {
        this.productCollectId = productCollectId;
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
