package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.ArrayList;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface OnProductCollectListener {
    void getProductCollectInfo(ArrayList<ProductCollectBean> data);

    void selectProductIdCard(String data);

    void userPraise(String data);

    void showError(String errorString);
}
