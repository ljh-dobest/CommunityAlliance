package com.issp.association.base.view;

/**
 * Created by Min on 2017/3/8.
 * 这个是activity的实现接口基类，封装了用于一般要进行网络请求，登录或注册等
 * 要等待时的一些功能
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showError(String errorString);
}
