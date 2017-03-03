package com.example.just.shequnlianmeng.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.just.shequnlianmeng.MainActivity;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.utils.LoadDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends Fragment {
    @BindView(R.id.et_userName)
   EditText et_userName;
    @BindView(R.id.et_login_pw)
    EditText et_pw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View containerView=inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,containerView);
        return containerView;
    }
    @OnClick(R.id.sign_in_btn)
    public void loginOnLick(View view) {
        String userName = et_userName.getText().toString().trim();
        String password = et_userName.getText().toString().trim();
        if ("".equals(userName) || "".equals(password)) {
            Toast.makeText(getContext(), "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
        } else if (userName != null && password != null) {
            LoadDialog.show(getContext());
            //服务器验证
            Intent intent=new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
    }
