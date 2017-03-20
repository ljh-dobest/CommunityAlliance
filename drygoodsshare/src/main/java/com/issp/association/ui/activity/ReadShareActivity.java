package com.issp.association.ui.activity;

import android.os.Bundle;

import com.issp.association.R;
import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.base.view.BaseMvpActivity;

/**
 *
 * 分享预览
 * Created by T-BayMax on 2017/3/18.
 */

public class ReadShareActivity extends BaseMvpActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_share);
    }

    @Override
    public BasePersenter initPresenter() {
        return null;
    }
}
