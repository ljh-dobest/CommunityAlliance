package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.base.view.BaseMvpFragment;
import com.example.just.shequnlianmeng.interfaces.IInterpersonalConnectionsPresenter;
import com.example.just.shequnlianmeng.interfaces.IInterpersonalConnectionsView;
import com.example.just.shequnlianmeng.presenters.InterpersonalConnectionsPresenter;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 人脉关系
 * Created by T-BayMax on 2017/3/14.
 */

public class InterpersonalConnectionsFragment extends BaseMvpFragment<IInterpersonalConnectionsView,InterpersonalConnectionsPresenter> implements IInterpersonalConnectionsView{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View containerView = inflater.inflate(R.layout.fragment_connections, container, false);
        ButterKnife.bind(this,containerView);
        return containerView;
    }
    @Override
    public InterpersonalConnectionsPresenter initPresenter() {
        return new InterpersonalConnectionsPresenter();
    }

    @Override
    public void onConnectionsError(String string) {

    }

    @Override
    public void onConnectionsSucceed(List data) {

    }
}
