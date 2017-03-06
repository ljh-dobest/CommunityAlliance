package com.example.just.shequnlianmeng.listeners;

/**
 * Created by just on 2017/3/5.
 */

public interface OnLoginFinishListener {
    void userNameOrPassWordError();
    void succeedToLogin();
    void failedToLogin(String string);
}
