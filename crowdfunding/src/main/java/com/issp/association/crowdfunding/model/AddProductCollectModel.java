package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.listeners.OnAddProductCollectListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by T-BayMax on 2017/4/21.
 */

public class AddProductCollectModel {
    public void productCollect(Map<String, String> formData, File file, String fileName, final OnAddProductCollectListener listener){
        HttpUtils.sendFormatPostRequest("/files", formData, file, fileName, new StringCallback() {
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
                        listener.productCollect("众筹添加成功");
                        break;
                    case 100:
                        listener.showError(code.getMsgs());
                        break;
                    case 0:
                        listener.showError("众筹添加失败");
                        break;
                }
            }
        });
    }
}
