package com.example.just.shequnlianmeng.bean;

/**
 * Created by Min on 2017/3/8.
 */

public class RecommendInfoBean {
    private String fullName;
    private String mobile;
    private String recommendId;

    public RecommendInfoBean(String fullName, String mobile, String recommendId) {
        this.fullName = fullName;
        this.mobile = mobile;
        this.recommendId = recommendId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }
}
