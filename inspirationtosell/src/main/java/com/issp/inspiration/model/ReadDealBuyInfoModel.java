package com.issp.inspiration.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.inspiration.bean.Code;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.listeners.OnReadDealBuyListener;
import com.issp.inspiration.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public class ReadDealBuyInfoModel {
    public void getReadShareInfo(Map<String, String> formData, final OnReadDealBuyListener listener) {

        HttpUtils.sendGsonPostRequest("/selectDealBuy", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code<DealBuyBean>>() {
                }.getType();
                Code<DealBuyBean> code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        DealBuyBean data = (DealBuyBean) code.getData();
                        listener.getReadDealBuyInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }

    public void getSharePraiseInfo(Map<String, String> formData, final OnReadDealBuyListener listener) {

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
                        listener.dealBuyPraiseInfo("点赞成功");
                        break;
                    case 100:
                        listener.showError("已点赞");
                        break;
                    case 0:
                        listener.showError("点赞失败");
                        break;
                }
            }
        });
    }
}
