package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductCommentBean;
import com.issp.association.crowdfunding.listeners.OnFeedForCommentListListener;
import com.issp.association.crowdfunding.listeners.OnProductCommentListListener;
import com.issp.association.crowdfunding.listeners.OnProductParticularsListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class ProductParticularsModel {
    public void getProductParticularsInfo(Map<String, String> formData, final OnProductParticularsListener listener){

        HttpUtils.sendGsonPostRequest("/selectProductInfo", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<ProductCollectBean>>() {
                }.getType();
                Code<ProductCollectBean> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ProductCollectBean data=  code.getData();
                        listener.getProductParticularsInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
    /**
     * 点赞
     * @param formData
     * @param listener
     */
    public void postUserPraise(Map<String, String> formData, final OnProductParticularsListener listener) {

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
                        listener.showError("评论失败");
                        break;
                }
            }
        });
    }
}
