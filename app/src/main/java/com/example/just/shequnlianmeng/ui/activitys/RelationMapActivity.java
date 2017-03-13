package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.interfaces.IRelationMapView;
import com.example.just.shequnlianmeng.presenters.RelationMapPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/11.
 */

public class RelationMapActivity extends BaseMvpActivity<IRelationMapView, RelationMapPresenter> implements IRelationMapView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation_map);
        Map<String, String> formData=new HashMap<String, String>(0);
        formData.put("userId","111");
        presenter.postRelationMapData(formData);
    }

    @Override
    public boolean checkInputInfo() {
        return false;
    }

    @Override
    public void onRelationSucceed(RelationBean relation) {

    }

    @Override
    public void onRelationFailed(String failed) {

    }

    @Override
    public RelationMapPresenter initPresenter() {
        return new RelationMapPresenter();
    }
}
