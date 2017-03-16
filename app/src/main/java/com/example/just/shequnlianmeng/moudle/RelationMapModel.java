package com.example.just.shequnlianmeng.moudle;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.listeners.RelationMapListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.utils.GsonResponsePasare;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/11.
 */

public class RelationMapModel {
    public void postRelationMap(Map<String, String> formData, final RelationMapListener listener) {
        HttpUtils.sendFormBodyPostRequest("/directNexusChart", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

                listener.onRelationError("系统异常");
            }

            @Override
            public void onResponse(String response, int id) {
                Type jsonType = new TypeToken<Code<RelationBean>>() {
                }.getType();
                Code<RelationBean> code = new Gson().fromJson(response,jsonType);
                switch (code.getCode()){
                    case 200:
                        listener.onRelationSucceed(code.getData());
                        break;
                    case 0:
                        listener.onRelationError("没有查找到关系");
                        break;
                }
            }
        });
    }
}
