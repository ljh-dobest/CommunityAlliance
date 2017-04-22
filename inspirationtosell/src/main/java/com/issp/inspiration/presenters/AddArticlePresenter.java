package com.issp.inspiration.presenters;

import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.interfaces.IAddArticleView;
import com.issp.inspiration.listeners.OnAddArticleListListener;
import com.issp.inspiration.model.AddArticleModel;

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
     * 灵感贩卖发布
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
