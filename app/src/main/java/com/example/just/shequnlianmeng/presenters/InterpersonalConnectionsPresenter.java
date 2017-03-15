package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.interfaces.IInterpersonalConnectionsPresenter;
import com.example.just.shequnlianmeng.interfaces.IInterpersonalConnectionsView;
import com.example.just.shequnlianmeng.listeners.InterpersonalConnectionsListener;
import com.example.just.shequnlianmeng.moudle.InterpersonalConnectionsModel;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/14.
 */

public class InterpersonalConnectionsPresenter extends BasePersenter<IInterpersonalConnectionsView> implements IInterpersonalConnectionsPresenter,InterpersonalConnectionsListener {
    private InterpersonalConnectionsModel model;
    public InterpersonalConnectionsPresenter(){
        this.model=new InterpersonalConnectionsModel();
    }
    @Override
    public void onConnectionsError(String string) {
mView.onConnectionsError(string);
    }

    @Override
    public void onConnectionsSucceed(List data) {
mView.onConnectionsSucceed(data);
    }

    @Override
    public void getConnectionsData(String uid) {
        model.getConnectionData(uid);
    }
}
