package com.example.just.shequnlianmeng.interfaces;

/**
 * Created by just on 2017/3/5.
 */

public interface ILoginView {
    void showUserNameOrPassWordEmpty(String errorString);
    void showFailedLogin(String errorString);
    void succeedToLogin();
}
