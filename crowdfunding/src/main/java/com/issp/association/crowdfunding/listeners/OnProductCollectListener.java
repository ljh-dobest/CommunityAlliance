package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.ProductCollect;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public interface OnProductCollectListener {
    void getProductCollectInfo(ArrayList<ProductCollect> data);
    void showError(String errorString);
}
