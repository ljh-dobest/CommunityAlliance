package com.example.just.shequnlianmeng.bean;

import java.util.List;

/**
 * Created by Min on 2017/3/8.
 */

public class ProvinceBean {
    private String name;
    private List<CityBean> sub;
    private String type;

    public ProvinceBean(String name, List<CityBean> sub, String type) {
        this.name = name;
        this.sub = sub;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityBean> getSub() {
        return sub;
    }

    public void setSub(List<CityBean> sub) {
        this.sub = sub;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
