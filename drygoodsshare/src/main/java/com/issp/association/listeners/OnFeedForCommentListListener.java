package com.issp.association.listeners;


import com.issp.association.bean.ShareCommentBean;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface OnFeedForCommentListListener {
    void getFeedCommentInfo(ArrayList<ShareCommentBean> data);

    void getAddCommentInfo(String data);

    void showError(String errorString);
}
