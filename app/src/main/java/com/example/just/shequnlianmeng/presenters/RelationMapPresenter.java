package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.interfaces.IRelationMapPresenter;
import com.example.just.shequnlianmeng.interfaces.IRelationMapView;
import com.example.just.shequnlianmeng.listeners.RelationMapListener;
import com.example.just.shequnlianmeng.moudle.RelationMapMoudle;

import java.util.Map;

/**
 * Created by T-BayMax on 2017/3/11.
 */

public class RelationMapPresenter extends BasePersenter<IRelationMapView> implements IRelationMapPresenter, RelationMapListener {
    private RelationMapMoudle moudle;

    public RelationMapPresenter() {
        this.moudle = new RelationMapMoudle();
    }

    @Override
    public void onRelationError(String string) {
        mView.onRelationFailed(string);
    }

    @Override
    public void onRelationSucceed(RelationBean relation) {
        mView.onRelationSucceed(relation);
    }

    @Override
    public void postRelationMapData(Map<String, String> formData) {
        moudle.postRelationMap(formData, this);
    }
}
