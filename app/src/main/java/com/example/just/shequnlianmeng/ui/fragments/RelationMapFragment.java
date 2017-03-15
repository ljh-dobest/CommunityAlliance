package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpFragment;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.interfaces.IRelationMapView;
import com.example.just.shequnlianmeng.presenters.RelationMapPresenter;
import com.example.just.shequnlianmeng.utils.T;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/14.
 */

public class RelationMapFragment extends BaseMvpFragment<IRelationMapView, RelationMapPresenter> implements IRelationMapView  {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View containerView = inflater.inflate(R.layout.fragment_relation_map, container, false);
        ButterKnife.bind(this,containerView);
        initDate();
        return containerView;
    }
    private void initDate(){

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
        T.showShort(RelationMapFragment.this.getActivity(),failed);
    }

    @Override
    public RelationMapPresenter initPresenter() {
        return new RelationMapPresenter();
    }
}
