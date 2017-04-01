package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.listeners.OnProductCollectListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> bxh
=======
import java.util.Map;
>>>>>>> bxh

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class ProductCollectModel {
<<<<<<< HEAD
<<<<<<< HEAD
    public void getProductCollectInfo(String userId, final OnProductCollectListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.sendGsonPostRequest("/allRecommendsUsers", userId, new StringCallback() {
=======
    public void getProductCollectInfo(Map<String ,String> formData, final OnProductCollectListener listener){

        HttpUtils.sendGsonPostRequest("/selectProduct", formData, new StringCallback() {
>>>>>>> bxh
=======
    public void getProductCollectInfo(Map<String ,String> formData, final OnProductCollectListener listener){

        HttpUtils.sendGsonPostRequest("/selectProductList", formData, new StringCallback() {
>>>>>>> bxh
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<ProductCollectBean>>>() {
                }.getType();
                Code<List<ProductCollectBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ArrayList<ProductCollectBean> data= (ArrayList<ProductCollectBean>) code.getData();
                        listener.getProductCollectInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
