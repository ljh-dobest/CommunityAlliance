package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.interfaces.ILoginPresenter;
import com.example.just.shequnlianmeng.interfaces.ILoginView;
import com.example.just.shequnlianmeng.listeners.OnLoginFinishListener;
import com.example.just.shequnlianmeng.moudle.LoginMoudle;

/**
 * Created by just on 2017/3/5.
 */

public class LoginPresenterImpl extends BasePersenter<ILoginView>implements ILoginPresenter,OnLoginFinishListener{
    private LoginMoudle loginMoudle;
    public LoginPresenterImpl() {
        this.loginMoudle = new LoginMoudle();
    }

    @Override
    public void verifyLoginInfo(String userName, String password) {
               loginMoudle.login(userName,password,this);
    }
    @Override
    public void userNameOrPassWordError() {
        if(mView!=null){
            mView.showUserNameOrPassWordEmpty("用户名或密码不能为空");
        }
    }

    @Override
    public void succeedToLogin() {
        if(mView!=null){
            mView.succeedToLogin();
        }
    }

    @Override
    public void failedToLogin(String string) {
        if(mView!=null){
            mView.showFailedLogin(string);
        }
    }
}
