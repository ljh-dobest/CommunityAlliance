package com.example.just.shequnlianmeng.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.just.shequnlianmeng.MainActivity;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseMvpFragment;
import com.example.just.shequnlianmeng.interfaces.ILoginView;
import com.example.just.shequnlianmeng.presenters.LoginPresenterImpl;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class LoginFragment extends BaseMvpFragment<ILoginView,LoginPresenterImpl> implements ILoginView{
    @BindView(R.id.et_userName)
   EditText et_userName;
    @BindView(R.id.et_login_pw)
    EditText et_pw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View containerView=inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,containerView);
        return containerView;
    }

    @Override
    public LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl();
    }

    @OnClick(R.id.sign_in_btn)
    public void loginOnClick(View view) {
        String userName= et_userName.getText().toString().trim();
        String pwd= et_pw.getText().toString().trim();
        LoadDialog.show(getContext());
        presenter.verifyLoginInfo(userName,pwd);
    }

    @Override
    public void showUserNameOrPassWordEmpty(String errorString) {
        T.showShort(getContext(),errorString);
        LoadDialog.dismiss(getContext());
    }
    @Override
    public void showFailedLogin(String errorString) {
        T.showShort(getContext(),errorString);
        LoadDialog.dismiss(getContext());
    }

    @Override
    public void succeedToLogin() {
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        T.showShort(getContext(),"登录成功~~");
        getActivity().finish();
        LoadDialog.dismiss(getContext());
    }

}
