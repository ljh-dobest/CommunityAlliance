package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductCommentBean;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface OnProductParticularsListener {
    void getProductParticularsInfo(ProductCollectBean data);
    void userPraise(String data);
    void showError(String errorString);
}
