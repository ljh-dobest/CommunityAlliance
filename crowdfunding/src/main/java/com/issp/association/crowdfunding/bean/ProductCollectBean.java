package com.issp.association.crowdfunding.bean;

import java.io.Serializable;

/**
 * 产品众筹
 * Created by T-BayMax on 2017/3/21.
 */

public class ProductCollectBean implements Serializable {
    private String id;	//众筹id
<<<<<<< HEAD
    private UserBean userId;		//众筹申请用户
    private String userName;	//众筹用户姓名
    private String mobile;		//众筹用户电话
    private String title;		//众筹标题
    private int capital;	//众筹总资金
    private int contribution;	//已筹备资金
    private String content;		//众筹内容

    private String file;	//众筹图片
    private int days;		//众筹天数
    private int status;	//众筹状态（0不通过1通过2审核中）
    private String reason;		//原因（审核不通过详情）
=======
 private String objective;//众筹目的
    private double capital;//需众筹总金额
    private double contribution;//已筹备资金
    private double percent;//已筹备百分比
    private String image;//众筹主图
    private double days;//剩余筹备天数
    private int likeStatus;//是否点赞 0未点赞，1已点赞
    private int likes;//点赞数量
>>>>>>> bxh

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

<<<<<<< HEAD
    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
=======
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
>>>>>>> bxh
    }
}
