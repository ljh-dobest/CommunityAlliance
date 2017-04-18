package com.ike.coalition.platform.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by T-BayMax on 2017/4/8.
 */

public class PlatformBean implements Serializable {
    private String id;    //id
    private String title;              //活动标题
    private int status;             //活动状态
    private String description;       //活动描述
    private String address;          //活动地点
    private String activesImage;       //活动图片
    private String startingTime;       //活动开始时间
    private String endTime;           //活动结束时间
    private String deadline;          //活动报名截止时间
    private double costMoney;       //活动费用
    private String content;         //活动详情
    private int joinStatus;     //1当前用户已报名  0未报名
    private int joinUsersNumber;  //报名人数
    private List<UserBean> joinUsers;               //报名人员

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivesImage() {
        return activesImage;
    }

    public void setActivesImage(String activesImage) {
        this.activesImage = activesImage;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(double costMoney) {
        this.costMoney = costMoney;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(int joinStatus) {
        this.joinStatus = joinStatus;
    }

    public int getJoinUsersNumber() {
        return joinUsersNumber;
    }

    public void setJoinUsersNumber(int joinUsersNumber) {
        this.joinUsersNumber = joinUsersNumber;
    }

    public List<UserBean> getJoinUsers() {
        return joinUsers;
    }

    public void setJoinUsers(List<UserBean> joinUsers) {
        this.joinUsers = joinUsers;
    }
}
