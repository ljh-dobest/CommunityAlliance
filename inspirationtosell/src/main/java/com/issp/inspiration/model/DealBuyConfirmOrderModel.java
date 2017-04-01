package com.issp.inspiration.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.inspiration.bean.Code;
import com.issp.inspiration.bean.DealBuyCommentBean;
import com.issp.inspiration.listeners.OnDealBuyCommentListListener;
import com.issp.inspiration.listeners.OnDealBuyConfirmOrderListener;
import com.issp.inspiration.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class DealBuyConfirmOrderModel {

    public void addConfirmOrderInfo(Map<String, String> formData , final OnDealBuyConfirmOrderListener listener){

        HttpUtils.sendGsonPostRequest("/shareComment", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<DealBuyCommentBean>>>() {
                }.getType();
                Code<List<DealBuyCommentBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        // ArrayList<ShareCommentBean> data= (ArrayList<ShareCommentBean>) code.getData();
                        listener.getConfirmOrderInfo("评论成功");
                        break;
                    case 0:
                        listener.showError("评论失败");
                        break;
                }
            }
        });
    }
}
