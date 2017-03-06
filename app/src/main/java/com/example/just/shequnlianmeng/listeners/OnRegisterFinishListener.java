package com.example.just.shequnlianmeng.listeners;

/**
 * Created by just on 2017/3/5.
 */

public interface OnRegisterFinishListener {
    void showTextEmpty();
    void succeedToRegiset();
    void showPwdError();
    void failedToRegister(String string);
}
