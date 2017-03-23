package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.ArrayList;

/**
 * 支持TA
 *Created by T-BayMax on 2017/3/13.
 */

public interface ISupportProductListView extends BaseView {
    void setSupportProductData(ArrayList<ProductCollectBean> data);
}
