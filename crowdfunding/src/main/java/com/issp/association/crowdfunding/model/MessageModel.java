package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.bean.MessageBean;
import com.issp.association.crowdfunding.listeners.OnMessageListListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class MessageModel {
    public void getCommentMessageInfo(String userId, final OnMessageListListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.sendGsonPostRequest("/allRecommendsUsers", userId, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<MessageBean>>>() {
                }.getType();
                Code<List<MessageBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ArrayList<MessageBean> data= (ArrayList<MessageBean>) code.getData();
                        listener.getCommentMessageInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
