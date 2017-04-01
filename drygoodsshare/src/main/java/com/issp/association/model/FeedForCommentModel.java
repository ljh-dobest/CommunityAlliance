package com.issp.association.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.bean.Code;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.listeners.OnFeedForCommentListListener;
import com.issp.association.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> bxh

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentModel {
<<<<<<< HEAD
    public void getFeedCommentInfo(String userId, final OnFeedForCommentListListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.sendGsonPostRequest("/allRecommendsUsers", userId, new StringCallback() {
=======
    public void getFeedCommentInfo(Map<String, String> formData , final OnFeedForCommentListListener listener){

        HttpUtils.sendGsonPostRequest("/allShareComment", formData, new StringCallback() {
>>>>>>> bxh
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<ShareBean>>>() {
                }.getType();
                Code<List<ShareCommentBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ArrayList<ShareCommentBean> data= (ArrayList<ShareCommentBean>) code.getData();
                        listener.getFeedCommentInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
<<<<<<< HEAD
=======
    public void addCommentInfo(Map<String, String> formData , final OnFeedForCommentListListener listener){

        HttpUtils.sendGsonPostRequest("/shareComment", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<ShareBean>>>() {
                }.getType();
                Code<List<ShareCommentBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                       // ArrayList<ShareCommentBean> data= (ArrayList<ShareCommentBean>) code.getData();
                        listener.getAddCommentInfo("评论成功");
                        break;
                    case 0:
                        listener.showError("评论失败");
                        break;
                }
            }
        });
    }
>>>>>>> bxh
}
