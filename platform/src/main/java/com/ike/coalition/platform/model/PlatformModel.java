package com.ike.coalition.platform.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ike.coalition.platform.bean.Code;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class PlatformModel {

    public void getProductCollectInfo(Map<String ,String> formData, final OnPlatformListener listener){

        HttpUtils.sendGsonPostRequest("/platformActivesList", formData, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<PlatformBean>>>() {
                }.getType();
                Code<List<PlatformBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        List<PlatformBean> data=  code.getData();
                        listener.getPlatformList(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
