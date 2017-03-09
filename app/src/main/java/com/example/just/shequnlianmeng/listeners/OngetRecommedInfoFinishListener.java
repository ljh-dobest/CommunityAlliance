package com.example.just.shequnlianmeng.listeners;

import com.example.just.shequnlianmeng.bean.RecommendInfoBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface OngetRecommedInfoFinishListener {
    void getRecommedInfo(ArrayList<RecommendInfoBean> data);
    void showError(String errorString);
}
