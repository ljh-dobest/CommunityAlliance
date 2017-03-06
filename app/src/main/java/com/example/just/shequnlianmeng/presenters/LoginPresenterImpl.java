package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.interfaces.ILoginPresenter;
import com.example.just.shequnlianmeng.interfaces.ILoginView;
import com.example.just.shequnlianmeng.listeners.OnLoginFinishListener;
import com.example.just.shequnlianmeng.moudle.LoginMoudle;

/**
 * Created by just on 2017/3/5.
 */

public class LoginPresenterImpl implements ILoginPresenter,OnLoginFinishListener{
    private ILoginView loginView;
    private LoginMoudle loginMoudle;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginMoudle = new LoginMoudle();
    }

    @Override
    public void verifyLoginInfo(String userName, String password) {
               loginMoudle.login(userName,password,this);
    }

    @Override
    public void onDestroy() {
       loginView=null;
    }

    @Override
    public void userNameOrPassWordError() {
        if(loginView!=null){
            loginView.showUserNameOrPassWordEmpty("用户名或密码不能为空");
        }
    }

    @Override
    public void succeedToLogin() {
        if(loginView!=null){
            loginView.succeedToLogin();
        }
    }

    @Override
    public void failedToLogin(String string) {
        if(loginView!=null){
            loginView.showFailedLogin(string);
        }
    }
}
