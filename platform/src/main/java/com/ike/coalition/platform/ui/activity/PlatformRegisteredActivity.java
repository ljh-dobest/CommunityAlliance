package com.ike.coalition.platform.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.ike.coalition.platform.R;
import com.ike.coalition.platform.adapter.PlatformRegisteredAdapter;
import com.ike.coalition.platform.adapter.SimpleAdapter;
import com.ike.coalition.platform.base.view.BaseMvpActivity;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.bean.UserBean;
import com.ike.coalition.platform.interfaces.IPlatformRegisteredListView;
import com.ike.coalition.platform.presenters.PlatformRegisteredPresenter;
import com.ike.coalition.platform.utils.T;
import com.ike.coalition.platform.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlatformRegisteredActivity extends BaseMvpActivity<IPlatformRegisteredListView, PlatformRegisteredPresenter> implements IPlatformRegisteredListView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.gv_apply)
    GridView gvApply;
    private int mLoadCount = 0;

    private int limit = 20;
    private int page = 1;

    private boolean isRefresh;
    PlatformBean bean;
    PlatformRegisteredAdapter adapter;
    List<UserBean> personList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public PlatformRegisteredPresenter initPresenter() {
        return new PlatformRegisteredPresenter();
    }

    private void initView() {
        bean = (PlatformBean) getIntent().getSerializableExtra("bean");
        ltMainTitleLeft.setText("返回");
        ltMainTitle.setText("已报名（" + bean.getJoinUsersNumber() + "）");
        personList = new ArrayList<UserBean>(0);
        adapter = new PlatformRegisteredAdapter(personList, this);
        gvApply.setAdapter(adapter);

    }

    private void initData() {
        isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("activesId", bean.getId());
        presenter.PlatformRegisteredPresenter(formData);

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        PlatformRegisteredActivity.this.finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {

        T.showShort(PlatformRegisteredActivity.this, errorString);
    }

    @Override
    public void setPlatformRegisteredListData(List<UserBean> data) {
        adapter.setData(data, page);
    }
}

