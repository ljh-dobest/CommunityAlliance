package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.List;

/**
 * 产品众筹列表
 *Created by T-BayMax on 2017/3/13.
 */

public interface IMinProductListView extends BaseView {
    void setMinProductListData(List<ProductCollectBean> data);
}
