package com.issp.association.bean;

import java.io.Serializable;

/**
 *
 * 干货分享类型
 * Created by T-BayMax on 2017/3/13.
 */

public class ShareTypeBean implements Serializable {
    private String type_id;	//是	文章类型id
    private String type_name;//文章类型名称

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
