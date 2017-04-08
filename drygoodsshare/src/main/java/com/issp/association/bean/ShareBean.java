package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareBean implements Serializable{
    private String id;
    private String nickname;
    private String userPortraitUrl;
    private String shareId;	//分享文章id
    private UserBean userId;	//发布用户id
    private String arcTitle;	//文章标题
    private String shareContent;	//文章内容
    private String content;	//文章内容
    private ShareTypeBean typeId;	//文章类型id
    private String sendDate;	//发布时间
    private boolean isShow;	//是否显示
    private String title;
    private String image;
    private String time;
    private int likes;
    private int likesStatus;
    private String synopsis;

    public ShareBean(){

    }
    public ShareBean(String arcTitle,String shareContent){
        this.arcTitle=arcTitle;
        this.shareContent=shareContent;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
