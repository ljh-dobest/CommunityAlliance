package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.List;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public interface OnMinProductListener {
    void getMinProductInfo(List<ProductCollectBean> data);
    void showError(String errorString);
}
