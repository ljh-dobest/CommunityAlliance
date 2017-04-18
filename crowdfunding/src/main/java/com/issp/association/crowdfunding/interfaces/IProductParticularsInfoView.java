package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductCommentBean;

import java.util.ArrayList;

/**
 * 产品众筹评论
 *Created by T-BayMax on 2017/3/20.
 */

public interface IProductParticularsInfoView extends BaseView {
    void setProductParticularsInfoData(ProductCollectBean data);
    void userPraise(String data);
}
