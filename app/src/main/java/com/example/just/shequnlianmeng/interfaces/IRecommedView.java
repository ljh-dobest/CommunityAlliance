package com.example.just.shequnlianmeng.interfaces;

/**
 * Created by Min on 2017/3/6.
 */

public interface IRecommedView {
    void showTextEmpty();
    void showRecommedError(String string);
    void succeedToRecommed(String RecommendId);
    void initView();
    void getViewData();
}
