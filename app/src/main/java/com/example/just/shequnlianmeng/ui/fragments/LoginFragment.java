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
import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.UserInfo;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.network.JsonParser;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


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
        String password = et_pw.getText().toString().trim();
        if ("".equals(userName) || "".equals(password)) {
            Toast.makeText(getContext(), "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if (userName != null && password != null) {
            LoadDialog.show(getContext());
            //服务器验证
            HttpUtils.postLoginRequest("/login", userName, password, new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    T.showShort(getContext(),e.toString());
                }

                @Override
                public void onResponse(String response, int id) {
                    Code<UserInfo> code = JsonParser.parserLoginBeanRespon(response);
                    switch (code.getCode()) {
                        case 200:
                       Intent intent=new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);
                            T.showShort(getContext(),"登录成功~~");
                            getActivity().finish();
                            break;
                        case 0:
                          T.showShort(getContext(),"账号不存在");
                            break;
                        case 1000:
                            T.showShort(getContext(),"账号禁止登录");
                            break;
                        case 1001:
                            T.showShort(getContext(),"密码错误");
                            break;
                    }
                }
            });
        }
    }
    }
