package com.issp.inspiration.listeners;

/**
 * Created by T-BayMax on 2017/4/19.
 */

public interface OnAddArticleListListener {

    void uploadPicturesListener(String data);

    void publishAnArticleListener(String data);
    void showError(String errorString);
}
