package com.issp.association.crowdfunding.bean;

import java.io.Serializable;

/**
 * 众筹产品详情
 *
 * Created by T-BayMax on 2017/4/6.
 */

public class ProductRewardBean implements Serializable {
    private int payNumber;   //该产品已购买人数
    private double supportMoney;        //支持金额
    private String rewardTitle;         //商品标题
    private String rewardContent;     //商品内容
    private int limitNumber;  //人数限制（0不限制）
    private double deliveryDays;  //发货时间天数（0结束立即发货）

    public int getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(int payNumber) {
        this.payNumber = payNumber;
    }

    public double getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(double supportMoney) {
        this.supportMoney = supportMoney;
    }

    public String getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(String rewardTitle) {
        this.rewardTitle = rewardTitle;
    }

    public String getRewardContent() {
        return rewardContent;
    }

    public void setRewardContent(String rewardContent) {
        this.rewardContent = rewardContent;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public double getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(double deliveryDays) {
        this.deliveryDays = deliveryDays;
    }
}
