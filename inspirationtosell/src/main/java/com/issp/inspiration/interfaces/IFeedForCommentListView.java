package com.issp.inspiration.interfaces;




import com.issp.inspiration.base.view.BaseView;
import com.issp.inspiration.bean.CommentsBean;

import java.util.List;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface IFeedForCommentListView extends BaseView {
    void setFeedForCommentListData(List<CommentsBean> data);
    void commentLikes(String data);
    void setAddCommentData(String data);
    boolean checkInputInfo();

}