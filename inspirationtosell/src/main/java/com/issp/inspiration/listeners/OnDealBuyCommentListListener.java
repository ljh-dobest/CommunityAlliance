package com.issp.inspiration.listeners;


import com.issp.inspiration.bean.CommentsBean;
import com.issp.inspiration.bean.DealBuyCommentBean;

import java.util.List;


/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface OnDealBuyCommentListListener {
    void getDealBuyCommentInfo(List<CommentsBean> data);
    void getAddCommentInfo(String data);
    void showError(String errorString);
}
