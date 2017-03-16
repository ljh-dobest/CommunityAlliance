package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineClaimActivity extends BaseActivity {
    @BindView(R.id.iv_mineclaim_back)
    ImageView iv_mineclaim_back;
    @BindView(R.id.rv_mineClaim)
    RecyclerView rv_mineClaim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_claim);
        ButterKnife.bind(this);
    }
}
