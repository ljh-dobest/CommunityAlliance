package com.issp.association.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 评论
 * Created by T-BayMax on 2017/3/13.
 */

public class ArticleCommentBean implements Serializable {
    private String title;             //求助问题标题
    private String nickname;          //回答者昵称
    private String userPortraitUrl;      //回答者头像
    private String content;           //回答内容
    private String time;             //回答时间
    private List<CommentsBean> comments;           //以下为评论区

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserPortraitUrl() {
        return userPortraitUrl;
    }

    public void setUserPortraitUrl(String userPortraitUrl) {
        this.userPortraitUrl = userPortraitUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }
}
