package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.CommentsBean;

import java.util.List;

/**
 * 产品众筹评论
 *Created by T-BayMax on 2017/3/20.
 */

public interface IProductCommentListView extends BaseView {
    void setProductCommentListData(List<CommentsBean> data);
}
