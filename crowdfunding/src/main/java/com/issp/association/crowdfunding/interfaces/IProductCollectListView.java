package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.ProductCollect;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public interface IProductCollectListView extends BaseView {
    void setProductCollectData(ArrayList<ProductCollect> data);
}
