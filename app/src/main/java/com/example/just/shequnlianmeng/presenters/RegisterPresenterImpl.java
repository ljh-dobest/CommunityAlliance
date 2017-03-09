package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.BasePersenter;
import com.example.just.shequnlianmeng.interfaces.IRegisterPresenter;
import com.example.just.shequnlianmeng.interfaces.IRegisterView;
import com.example.just.shequnlianmeng.listeners.OnRegisterFinishListener;
import com.example.just.shequnlianmeng.moudle.RegisterMoudle;

/**
 * Created by just on 2017/3/5.
 */

public class RegisterPresenterImpl extends BasePersenter<IRegisterView>implements IRegisterPresenter,OnRegisterFinishListener{
    private RegisterMoudle registerMoudle;
    public RegisterPresenterImpl() {
        this.registerMoudle = new RegisterMoudle();
    }

    @Override
    public void verifyRegisterInfo(String userName, String mobile, String password, String recommendId) {
             registerMoudle.register(userName,mobile,password,recommendId,this);
    }

    @Override
    public void showTextEmpty() {
              mView.showTextEmpty();
    }

    @Override
    public void succeedToRegiset() {
        mView.succeedToRegister();
    }

    @Override
    public void showPwdError() {
        mView.showPwdError();
    }

    @Override
    public void failedToRegister(String string) {
        mView.showRegisterError(string );
    }
}
