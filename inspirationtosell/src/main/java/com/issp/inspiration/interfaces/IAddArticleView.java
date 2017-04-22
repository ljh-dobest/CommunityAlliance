package com.issp.inspiration.interfaces;

import com.issp.inspiration.base.view.BaseView;

import java.io.File;
import java.util.Map;

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
