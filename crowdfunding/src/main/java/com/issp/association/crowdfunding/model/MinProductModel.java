package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.listeners.OnMinProductListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public class MinProductModel {

    public void getMinProductInfo(Map<String, String> formData, final OnMinProductListener listener) {

        HttpUtils.sendGsonPostRequest("/selectMyProductCollect", formData, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code<List<ProductCollectBean>>>() {
                }.getType();
                Code<List<ProductCollectBean>> code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        List<ProductCollectBean> data = code.getData();
                        listener.getMinProductInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
