package com.issp.inspiration.presenters;

import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.interfaces.IAddArticleView;
import com.issp.inspiration.interfaces.IPreviewView;
import com.issp.inspiration.listeners.OnAddArticleListListener;
import com.issp.inspiration.listeners.OnPreviewListener;
import com.issp.inspiration.model.AddArticleModel;
import com.issp.inspiration.model.PreviewModel;

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
     * 灵感贩卖发布
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
