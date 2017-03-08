package com.example.just.shequnlianmeng.interfaces;

import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/6.
 */

public interface IRecommedView {
    void showTextEmpty();
    void showRecommedError(String string);
    void succeedToRecommed(String RecommendId);
    void initView();
    void getViewData();
    void getparserData(ArrayList<ProvinceBean> provinces);
}
