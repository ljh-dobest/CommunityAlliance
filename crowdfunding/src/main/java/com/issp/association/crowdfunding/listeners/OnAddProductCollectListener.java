package com.issp.association.crowdfunding.listeners;

/**
 * Created by T-BayMax on 2017/4/21.
 */

public interface OnAddProductCollectListener {
    void productCollect(String data);
    void showError(String errorString);
}
