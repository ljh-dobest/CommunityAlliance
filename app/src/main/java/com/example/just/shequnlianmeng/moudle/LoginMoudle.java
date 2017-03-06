package com.example.just.shequnlianmeng.moudle;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.UserInfo;
import com.example.just.shequnlianmeng.listeners.OnLoginFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * Created by just on 2017/3/5.
 */

public class LoginMoudle {
    public void login(String userName, String pwd, final OnLoginFinishListener listener){
        if ("".equals(userName) || "".equals(pwd)) {
            listener.userNameOrPassWordError();
        } else if (userName != null && pwd != null) {
            //服务器验证
            HttpUtils.postLoginRequest("/login", userName, pwd, new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    listener.failedToLogin(e.toString());
                }

                @Override
                public void onResponse(String response, int id) {
                    Gson gson=new Gson();
                    Type type = new TypeToken<Code<UserInfo>>() {}.getType();
                    Code<UserInfo> code=gson.fromJson(response,type);
                   // Code<UserInfo> code = JsonParser.parserLoginBeanRespon(response);
                    switch (code.getCode()) {
                        case 200:
                         listener.succeedToLogin();
                            UserInfo userInfo=code.getData();
                            break;
                        case 0:
                            listener.failedToLogin("账号不存在！");
                            break;
                        case 1000:
                            listener.failedToLogin("账号禁止登陆，请联系管理员");
                            break;
                        case 1001:
                            listener.failedToLogin("密码错误，请重新输入！");
                            break;
                    }
                }
            });
        }


    }
}
