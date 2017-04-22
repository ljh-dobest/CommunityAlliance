package com.issp.association.presenters;


import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.interfaces.IAddArticleView;
import com.issp.association.listeners.OnAddArticleListListener;
import com.issp.association.model.AddArticleModel;

import java.io.File;
import java.util.Map;

/**
 * Created by T-BayMax on 2017/4/19.
 */

public class AddArticlePresenter extends BasePersenter<IAddArticleView> implements OnAddArticleListListener {

    private AddArticleModel model;

    public AddArticlePresenter() {
        model = new AddArticleModel();
    }

    /**
     * 上传图片
     *
     * @param params
     * @param file
     * @param fileName
     */
    public void uploadPicturesPresenter(Map<String, String> params, File file, String fileName) {
        model.uploadPictures(params, file, fileName, this);
    }

    /**
     * 发布
     * @param formData
     * @param file
     * @param fileName
     */
    public void publishAnArticlePresenter(Map<String, String> formData, File file, String fileName) {
        model.publishAnArticle(formData, file, fileName, this);
    }

    @Override
    public void uploadPicturesListener(String data) {
        mView.uploadPicturesView(data);
    }

    @Override
    public void publishAnArticleListener(String data) {
        mView.publishAnArticleView(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
