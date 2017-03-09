package com.example.just.shequnlianmeng.moudle;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;
import com.example.just.shequnlianmeng.listeners.OngetRecommedInfoFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/9.
 */

public class RecommedInfoMoudle {
    public void getRecommedInfo(String userId, final OngetRecommedInfoFinishListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.getRecommedInfo("/allRecommendsUsers", userId, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<RecommendInfoBean>>>() {
                }.getType();
                Code<List<RecommendInfoBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ArrayList<RecommendInfoBean> data= (ArrayList<RecommendInfoBean>) code.getData();
                        listener.getRecommedInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
