package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.DividerItemDecoration;
import com.example.just.shequnlianmeng.adapter.SearchRecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {
   @BindView(R.id.rv_search)
    RecyclerView rv_search;
    @BindView(R.id.tv_search_clear)
    TextView tv_search_clear;
    private SearchRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initRv();
    }

    private void initRv() {
        ArrayList<String> data=new ArrayList<>();
        data.add("宋小宝");
        data.add("小沈阳");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        rv_search.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        adapter=new SearchRecyclerAdapter(this,data );
        rv_search.setAdapter(adapter);
        //设置增加或删除条目的动画
        rv_search.setItemAnimator(new DefaultItemAnimator());
        rv_search.addItemDecoration(new DividerItemDecoration(this,OrientationHelper.VERTICAL));
    }

    @OnClick(R.id.tv_search_clear)
    public void onViewClick(View view){
        switch (view.getId()) {
            case R.id.tv_search_clear:
                 adapter.clearData();
                break;
        }
    }
}
