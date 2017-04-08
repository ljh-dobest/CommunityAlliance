package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;
import com.issp.association.bean.CommentsBean;
import com.issp.association.bean.ShareCommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface IFeedForCommentListView extends BaseView {
    void setFeedForCommentListData(List<CommentsBean> data);

    void setAddCommentData(String data);
    boolean checkInputInfo();

}
