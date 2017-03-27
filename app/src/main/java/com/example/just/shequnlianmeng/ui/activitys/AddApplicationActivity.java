package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.AddApplicationAdapter;
import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.base.view.BaseActivity;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.ApplyListItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by T-BayMax on 2017/3/27.
 */

public class AddApplicationActivity extends BaseActivity {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.gv_application)
    GridView gvApplication;

    private List<ApplyListItem> list;
    private AddApplicationAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_application);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        AddApplicationActivity.this.finish();
    }

    private void initData() {
        list=new ArrayList<ApplyListItem>(0);
        list.add(new ApplyListItem("干货分享",R.mipmap.ganhuo,0));
        list.add(new ApplyListItem("灵感贩卖",R.mipmap.linggan,0));
        list.add(new ApplyListItem("认领中心",R.mipmap.lingyang,0));
        list.add(new ApplyListItem("直播中心",R.mipmap.zhibo,0));
        list.add(new ApplyListItem("联盟打车",R.mipmap.dache,0));
        list.add(new ApplyListItem("求助中心",R.mipmap.qiuzhu,0));
        adapter=new AddApplicationAdapter(list,AddApplicationActivity.this);
        gvApplication.setAdapter(adapter);
    }


}
