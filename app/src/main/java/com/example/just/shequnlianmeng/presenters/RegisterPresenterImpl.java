package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.interfaces.IRegisterPresenter;
import com.example.just.shequnlianmeng.interfaces.IRegisterView;
import com.example.just.shequnlianmeng.listeners.OnRegisterFinishListener;
import com.example.just.shequnlianmeng.moudle.RegisterMoudle;

/**
 * Created by just on 2017/3/5.
 */

public class RegisterPresenterImpl implements IRegisterPresenter,OnRegisterFinishListener{
    private IRegisterView registerView;
    private RegisterMoudle registerMoudle;

    public RegisterPresenterImpl(IRegisterView registerView) {
        this.registerView = registerView;
        this.registerMoudle = new RegisterMoudle();
    }

    @Override
    public void verifyRegisterInfo(String userName, String mobile, String password, String recommendId) {
             registerMoudle.register(userName,mobile,password,recommendId,this);
    }

    @Override
    public void onDestroy() {
          registerView=null;
    }

    @Override
    public void showTextEmpty() {
              registerView.showTextEmpty();
    }

    @Override
    public void succeedToRegiset() {
           registerView.succeedToRegister();
    }

    @Override
    public void showPwdError() {
          registerView.showPwdError();
    }

    @Override
    public void failedToRegister(String string) {
             registerView.showRegisterError(string );
    }
}
