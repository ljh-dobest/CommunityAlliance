package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpFragment;
import com.example.just.shequnlianmeng.interfaces.IRegisterView;
import com.example.just.shequnlianmeng.presenters.RegisterPresenterImpl;
import com.example.just.shequnlianmeng.utils.AMUtils;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterFragment extends BaseMvpFragment<IRegisterView,RegisterPresenterImpl> implements IRegisterView{

    public interface FinishRegisterListener{
        void finishRegister();
    }
    @BindView(R.id.et_re_ph)
     EditText et_re_ph;
    @BindView(R.id.et_re_nickname)
    EditText et_re_nickname;
    @BindView(R.id.et_re_pw)
     EditText et_re_pw;
    @BindView(R.id.et_re_invite_code)
    EditText et_re_invite_code;
     private FinishRegisterListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View containerView=inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this,containerView);
        addEditTextListener();
        return containerView;
    }

    @Override
    public RegisterPresenterImpl initPresenter() {
        return new RegisterPresenterImpl();
    }

    private void addEditTextListener() {
        et_re_ph.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 11) {
                    if (!AMUtils.isMobile(et_re_ph.getText().toString().trim())) {
                        T.showShort(getContext(), "请输入正确的手机号码");
                        return;
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @OnClick(R.id.btn_register)
    public void registerOnClick(View view){
        LoadDialog.show(getContext());
       String password = et_re_pw.getText().toString();
      String  mobile = et_re_ph.getText().toString();
        String nikeName=et_re_nickname.getText().toString();
        String inviteCode = et_re_invite_code.getText().toString().trim();
       presenter.verifyRegisterInfo(nikeName,mobile,password,inviteCode);
    }

    public void setListener(FinishRegisterListener listener){
        this.listener=listener;
    }
    @Override
    public void showTextEmpty() {
          T.showShort(getContext(),"用户名、手机号码、密码、推荐码不能为空！");
        LoadDialog.dismiss(getContext());
    }

    @Override
    public void showRegisterError(String errorString) {
         T.showShort(getContext(),errorString);
        LoadDialog.dismiss(getContext());
    }

    @Override
    public void showPwdError() {
        T.showShort(getContext(),"密码不能少于4位");
        LoadDialog.dismiss(getContext());
    }

    @Override
    public void succeedToRegister() {
          T.showShort(getContext(),"注册成功~~");
        et_re_ph.setText("");
        et_re_nickname.setText("");
        et_re_pw.setText("");
        et_re_invite_code.setText("");
        LoadDialog.dismiss(getContext());
        listener.finishRegister();
     }
    }