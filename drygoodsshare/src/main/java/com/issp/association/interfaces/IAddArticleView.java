package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;

/**
 * 添加灵感贩卖
 * Created by T-BayMax on 2017/4/19.
 */

public interface IAddArticleView extends BaseView {
    /**
     * 上传图片
     */
    void uploadPicturesView(String data);

    void publishAnArticleView(String data);
}
