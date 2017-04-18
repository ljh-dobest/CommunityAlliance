package com.issp.association.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.bean.ArticleCommentBean;
import com.issp.association.bean.Code;
import com.issp.association.bean.CommentsBean;
import com.issp.association.listeners.OnFeedForCommentListListener;
import com.issp.association.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * 评论
 * Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentModel {
    /**
     * 查看评论
     * @param formData
     * @param listener
     */
    public void getFeedCommentInfo(Map<String, String> formData, final OnFeedForCommentListListener listener) {

        HttpUtils.sendGsonPostRequest("/selectArticleComment", formData, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code<ArticleCommentBean>>() {
                }.getType();
                Code<ArticleCommentBean> code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        if (null != code.getData()) {
                            ArticleCommentBean bean = code.getData();
                            List<CommentsBean> data = bean.getComments();
                            listener.getFeedCommentInfo(data);
                        }
                        break;
                    case 0:
                        listener.showError("暂无评论");
                        break;
                }
            }
        });
    }

    /**
     * 添加评论
     * @param formData
     * @param listener
     */
    public void addCommentInfo(Map<String, String> formData, final OnFeedForCommentListListener listener) {

        HttpUtils.sendGsonPostRequest("/articleComment", formData, new StringCallback() {
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
                        listener.getAddCommentInfo("评论成功");
                        break;
                    case 0:
                        listener.showError("评论失败");
                        break;
                }
            }
        });
    }

    /**
     * 评论点赞
     * @param formData
     * @param listener
     */
    public void commentLikes(Map<String, String> formData, final OnFeedForCommentListListener listener) {

        HttpUtils.sendGsonPostRequest("/commentLikes", formData, new StringCallback() {
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
                        listener.commentLikes("点赞成功");
                        break;
                    case 0:
                        listener.showError("点赞失败");
                        break;
                }
            }
        });
    }
}
