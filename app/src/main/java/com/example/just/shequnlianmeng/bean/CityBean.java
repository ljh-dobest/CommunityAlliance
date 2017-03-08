package com.example.just.shequnlianmeng.bean;

import java.util.List;

/**
 * Created by Min on 2017/3/8.
 */

public class CityBean {
    private String name;
    private List<CountyBean> sub;

    public CityBean(String name, List<CountyBean> sub) {
        this.name = name;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountyBean> getSub() {
        return sub;
    }

    public void setSub(List<CountyBean> sub) {
        this.sub = sub;
    }
}
