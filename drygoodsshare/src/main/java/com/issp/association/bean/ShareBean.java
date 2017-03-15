package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareBean implements Serializable{
    private String shareId;	//是	分享文章id
    private UserBean userId;	//发布用户id
    private String arcTitle;	//文章标题
    private String shareContent;	//文章内容
    private ShareTypeBean typeId;	//文章类型id
    private String sendDate;	//发布时间
    private boolean isShow;	//是否显示

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
    }

    public String getArcTitle() {
        return arcTitle;
    }

    public void setArcTitle(String arcTitle) {
        this.arcTitle = arcTitle;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public ShareTypeBean getTypeId() {
        return typeId;
    }

    public void setTypeId(ShareTypeBean typeId) {
        this.typeId = typeId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
