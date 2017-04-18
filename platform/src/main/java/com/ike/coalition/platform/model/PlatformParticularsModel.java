package com.ike.coalition.platform.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ike.coalition.platform.bean.Code;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.listeners.OnFeedForCommentListListener;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.listeners.OnPlatformParticularsListener;
import com.ike.coalition.platform.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public class PlatformParticularsModel {

    public void getProductCollectInfo(Map<String, String> formData, final OnPlatformParticularsListener listener) {

        HttpUtils.sendGsonPostRequest("/platformActivesInfo", formData, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code<PlatformBean>>() {
                }.getType();
                Code<PlatformBean> code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        PlatformBean data = code.getData();
                        listener.getPlatformParticulars(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }

    public void platformActivesJoin(Map<String, String> formData, final OnPlatformParticularsListener listener) {
        HttpUtils.sendGsonPostRequest("/platformActivesJoin", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code>() {
                }.getType();
                Code code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        listener.platformActivesJoinSucceed("报名成功！！！");
                        break;
                    case 0:
                        listener.showError("报名失败！！！");
                        break;
                    case 100:
                        listener.platformActivesJoinSucceed("亲，你已经报过名了！");
                        break;
                    case 101:
                        listener.showError("报名失败！！！");
                        break;
                }
            }
        });
    }
    public void userPraise(Map<String, String> formData, final OnPlatformParticularsListener listener) {

        HttpUtils.sendGsonPostRequest("/userPraise", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code>() {
                }.getType();
                Code code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        listener.userPraise("点赞成功");
                        break;
                    case 100:
                        listener.showError(code.getMsgs());
                        break;
                    case 0:
                        listener.showError("点赞失败");
                        break;
                }
            }
        });
    }
}
