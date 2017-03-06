package com.example.just.shequnlianmeng.moudle;

import android.text.TextUtils;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.listeners.OnRegisterFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.network.JsonParser;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/6.
 */

public class RegisterMoudle {
    public void register(String userName, String mobile, String pwd, String recommendId, final OnRegisterFinishListener listener){
        if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(pwd)||TextUtils.isEmpty(recommendId)){
                    listener.showTextEmpty();
        }else if (TextUtils.isEmpty(pwd) || pwd.length() < 4) {
            listener.showPwdError();
        }else {
            //信息提交服务器
            HttpUtils.postRegisterRequest("/register", mobile, mobile, pwd, recommendId, new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                   listener.failedToRegister(e.toString());
                }
                @Override
                public void onResponse(String response, int id) {
                    Code<Object> code = JsonParser.parserRegisterRespon(response);
                    switch (code.getCode()) {
                        case 200:
                           listener.succeedToRegiset();
                            break;
                        case 0:
                           listener.failedToRegister("账号已注册");
                            break;
                        case 1000:
                          listener.failedToRegister("推荐码不正确");
                            break;

                    }

                }
            });
        }

    }
}
