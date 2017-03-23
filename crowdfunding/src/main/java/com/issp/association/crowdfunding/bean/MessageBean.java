package com.issp.association.crowdfunding.bean;

import java.io.Serializable;

/**
 * 消息
 * Created by T-BayMax on 2017/3/22.
 */

public class MessageBean implements Serializable {
    private UserBean userId;
    private String messageContent;
    private String theme;
    private String messageTime;

    public UserBean getUserId() {
        return userId;
    }

    public void setUserId(UserBean userId) {
        this.userId = userId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
