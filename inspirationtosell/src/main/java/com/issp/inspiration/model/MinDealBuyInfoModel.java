package com.issp.inspiration.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.inspiration.bean.Code;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.listeners.OnMinDealBuyListener;
import com.issp.inspiration.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
*
 * Created by T-BayMax on 2017/3/13.
 */

public class MinDealBuyInfoModel {
    public void getMinDealBuyInfo(Map<String, String> formData, final OnMinDealBuyListener listener) {

        HttpUtils.sendGsonPostRequest("/myAddShare", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code<List<DealBuyBean>>>() {
                }.getType();
                Code<List<DealBuyBean>> code = gson.fromJson(response, type);
                if (code.getCode()==0){
                    listener.showError("你还未发布任何灵感贩卖！");
                }else {
                    ArrayList<DealBuyBean> data = (ArrayList<DealBuyBean>) code.getData();
                    listener.getMinDealBuyInfo(data);
                }
               /* switch (code.getCode()) {
                    case 100:
                        ArrayList<ShareBean> data = (ArrayList<ShareBean>) code.getData();
                        listener.getMinDealBuyInfo(data);
                        break;
                    case 0:
                        listener.showError("你还未发布任何干货！");
                        break;
                }*/
            }
        });
    }

    public void getDealBuyPraiseInfo(Map<String, String> formData, final OnMinDealBuyListener listener) {

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
