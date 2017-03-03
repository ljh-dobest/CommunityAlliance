package com.example.just.shequnlianmeng;

import android.app.Application;

import com.example.just.shequnlianmeng.network.HttpUtils;

/**
 * Created by Min on 2017/3/2.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtils.setCookie(this);
    }
}
