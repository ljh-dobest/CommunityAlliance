package com.issp.inspiration.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.inspiration.bean.Code;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.listeners.OnAddArticleListListener;
import com.issp.inspiration.listeners.OnPreviewListener;
import com.issp.inspiration.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;

/**
 * 添加灵感贩卖
 * Created by T-BayMax on 2017/4/19.
 */

public class PreviewModel {

    /**
     * 添加灵感贩卖
     *
     * @param params
     * @param file
     * @param fileName
     * @param listener
     */
    public void publishAnArticle(Map<String, String> params, File file, String fileName,  final OnPreviewListener listener) {

        HttpUtils.sendFormatPostRequest("/dealBuy", params, file, fileName, new StringCallback() {
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
                        listener.publishAnArticleListener("灵感贩卖发表成功");
                        break;
                    case 100:
                        listener.showError("");
                        break;
                    case 0:
                        listener.showError("灵感贩卖发表失败");
                        break;
                }
            }
        });
    }
}
