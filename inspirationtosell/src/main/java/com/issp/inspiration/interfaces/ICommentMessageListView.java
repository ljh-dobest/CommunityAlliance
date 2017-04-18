package com.issp.inspiration.interfaces;




import com.issp.inspiration.base.view.BaseView;
import com.issp.inspiration.bean.CommentsBean;

import java.util.List;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface ICommentMessageListView extends BaseView {
    void setCommentMessageListData(List<CommentsBean> data);
}
