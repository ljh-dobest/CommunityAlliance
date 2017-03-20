package com.issp.association.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.issp.association.R;
import com.issp.association.base.view.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的分享
 * Created by T-BayMax on 2017/3/18.
 */

public class MinShareActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.lt_main_title_left)
    TextView lt_main_title_left;
    @BindView(R.id.rg_relation)
    RadioGroup radioGroup;
    @BindView(R.id.rb_connection)
    RadioButton rb_connection;
    @BindView(R.id.rb_relation_map)
    RadioButton rb_relation_map;

    private RadioButton radioButtons[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_share);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        radioButtons = new RadioButton[]{rb_connection, rb_relation_map};
        radioGroup.setOnCheckedChangeListener(this);
        rb_connection.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        reset();
        RadioButton rb = (RadioButton) group.findViewById(checkedId);
        rb.setTextColor(Color.BLACK);

    }

    private void reset() {
        for (RadioButton rb : radioButtons) {
            rb.setTextColor(Color.GREEN);
        }

    }
    @OnClick(R.id.lt_main_title_left)
    void backClick(){
        MinShareActivity.this.finish();
    }
}
