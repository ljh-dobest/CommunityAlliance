package com.example.just.shequnlianmeng.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Min on 2017/3/8.
 */

public abstract class BaseMvpActivity<V,T extends BasePersenter<V>> extends AppCompatActivity{
    public T presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
             presenter=initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    public abstract T initPresenter();
}
