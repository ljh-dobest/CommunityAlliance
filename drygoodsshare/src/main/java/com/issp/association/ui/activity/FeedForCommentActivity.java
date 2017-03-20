package com.issp.association.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.issp.association.R;
import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.base.view.BaseMvpActivity;

import butterknife.ButterKnife;

/**
 * 评论列表
 * Created by T-BayMax on 2017/3/18.
 */

public class FeedForCommentActivity extends BaseMvpActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_for_comments);
        ButterKnife.bind(this);
    }

    @Override
    public BasePersenter initPresenter() {
        return null;
    }
}
