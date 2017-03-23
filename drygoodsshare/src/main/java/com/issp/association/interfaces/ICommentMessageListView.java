package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.ShareCommentBean;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface ICommentMessageListView extends BaseView {
    void setCommentMessageListData(ArrayList<ShareCommentBean> data);
}
