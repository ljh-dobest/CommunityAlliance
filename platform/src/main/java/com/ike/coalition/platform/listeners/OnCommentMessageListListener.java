package com.ike.coalition.platform.listeners;



import com.ike.coalition.platform.bean.CommentsBean;

import java.util.List;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface OnCommentMessageListListener {
    void getCommentMessageInfo(List<CommentsBean> data);
    void showError(String errorString);
}
