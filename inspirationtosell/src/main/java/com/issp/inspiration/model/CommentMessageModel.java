package com.issp.inspiration.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.inspiration.bean.ArticleCommentBean;
import com.issp.inspiration.bean.Code;
import com.issp.inspiration.bean.CommentsBean;
import com.issp.inspiration.listeners.OnCommentMessageListListener;
import com.issp.inspiration.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class CommentMessageModel {
    public void getCommentMessageInfo(String userId, final OnCommentMessageListListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.sendGsonPostRequest("/selectArticleComment", userId, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<ArticleCommentBean>>() {
                }.getType();
                Code<ArticleCommentBean> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        List<CommentsBean> data= code.getData().getComments();
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
