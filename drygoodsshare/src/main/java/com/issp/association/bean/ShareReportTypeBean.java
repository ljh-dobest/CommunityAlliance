package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享举报类型
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareReportTypeBean implements Serializable {
    private String report_id;//是	举报类型id
    private String report_type;//举报内容

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }
}
