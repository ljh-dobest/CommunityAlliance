package com.issp.association.ui.activity;

import android.os.Bundle;

import com.issp.association.R;
import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.base.view.BaseMvpActivity;

/**
 *
 * 消息列表
 * Created by T-BayMax on 2017/3/18.
 */

public class CommentMessageActivity extends BaseMvpActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_message);
    }

    @Override
    public BasePersenter initPresenter() {
        return null;
    }
}
