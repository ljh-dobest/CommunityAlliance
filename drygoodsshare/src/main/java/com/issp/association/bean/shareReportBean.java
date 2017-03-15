package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享举报
 * Created by T-BayMax on 2017/3/13.
 */

public class shareReportBean implements Serializable     {
    private ShareBean shareId;//干货分享id
    private UserBean userId;//举报用户id
    private ShareReportTypeBean reportId	;//举报内容id(选择性)
    private String reportContent;//举报内容（自定义）
    private String reportTime;//举报时间

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

    public ShareReportTypeBean getReportId() {
        return reportId;
    }

    public void setReportId(ShareReportTypeBean reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
