package com.issp.association.presenters;


import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.interfaces.IPreviewView;
import com.issp.association.listeners.OnPreviewListener;
import com.issp.association.model.PreviewModel;

import java.io.File;
import java.util.Map;

/**
 * Created by T-BayMax on 2017/4/19.
 */

public class PreviewPresenter extends BasePersenter<IPreviewView> implements OnPreviewListener {

    private PreviewModel model;

    public PreviewPresenter() {
        model = new PreviewModel();
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
    public void publishAnArticleListener(String data) {
        mView.publishAnArticleView(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
