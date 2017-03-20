package com.issp.association;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.adapter.IndexPageAdapter;
import com.issp.association.adapter.SimpleAdapter;
import com.issp.association.base.view.BaseMvpActivity;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IShareListView;
import com.issp.association.presenters.ShareInfoPresenter;
import com.issp.association.ui.activity.MinShareActivity;
import com.issp.association.utils.DisplayUtils;
import com.issp.association.view.BannerViewPager;
import com.issp.association.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 干货分享
 */
public class MainActivity extends BaseMvpActivity<IShareListView, ShareInfoPresenter> implements IShareListView {

    private PopupWindow mPopupWindow;

    @BindView(R.id.lt_main_title_left)
    TextView lt_main_title_left;
    @BindView(R.id.lt_main_title)
    TextView lt_main_title;
    @BindView(R.id.lt_main_title_right)
    TextView lt_main_title_right;
    RecyclerView recyclerView;

    SimpleAdapter adapter;
    List<ShareBean> personList = new ArrayList<ShareBean>();
    XRefreshView xRefreshView;
    GridLayoutManager layoutManager;
    private int mLoadCount = 0;

    private BannerViewPager mBannerViewPager;
    private int[] mImageIds = new int[]{R.mipmap.banner, R.mipmap.banner02};// 测试图片id
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }
    private void initView(){
        xRefreshView = (XRefreshView) findViewById(R.id.xrefreshview);
        xRefreshView.setPullLoadEnable(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);

        initData();
        adapter = new SimpleAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        headerView = adapter.setHeaderView(R.layout.bannerview, recyclerView);
//        LayoutInflater.from(this).inflate(R.layout.bannerview, rootview);
        mBannerViewPager = (BannerViewPager) headerView.findViewById(R.id.index_viewpager);

//        adHeader = new AdHeader(this);
//        mBannerViewPager = (LoopViewPager) adHeader.findViewById(R.id.index_viewpager);
        initViewPager();
        CustomGifHeader header = new CustomGifHeader(this);
        xRefreshView.setCustomHeaderView(header);
        recyclerView.setAdapter(adapter);
        xRefreshView.setAutoLoadMore(false);
        xRefreshView.setPinnedTime(1000);
        xRefreshView.setMoveForHorizontal(true);
//        recyclerviewAdapter.setHeaderView(headerView, recyclerView);
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
//        xRefreshView1.setPullRefreshEnable(false);
        //设置在下拉刷新被禁用的情况下，是否允许界面被下拉,默认是true
//        xRefreshView1.setMoveHeadWhenDisablePullRefresh(false);
//        xRefreshView1.enablePullUpWhenLoadCompleted(false);
//		xRefreshView1.setPullLoadEnable(false);
//        xRefreshView1.enableRecyclerViewPullUp(false);
        //设置静默加载时提前加载的item个数
//		xRefreshView1.setPreLoadCount(2);

        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟数据加载失败的情况
                        Random random = new Random();
                        boolean success = random.nextBoolean();
                        if(success){
                            xRefreshView.stopRefresh();
                        }else{
                            xRefreshView.stopRefresh(false);
                        }
                        //或者
//                        xRefreshView1.stopRefresh(success);
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            adapter.insert(new ShareBean("标题"+i+1,"内容"+i+1),
                                    adapter.getAdapterItemCount());
                        }
                        mLoadCount++;
                        if (mLoadCount >= 3) {
                            xRefreshView.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            xRefreshView.stopLoadMore();
                        }
                    }
                }, 1000);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            ShareBean person = new ShareBean("标题"+i+1,"内容"+i+1);
            personList.add(person);
        }
    }

    private View headerView;

    private void initViewPager() {
        IndexPageAdapter pageAdapter = new IndexPageAdapter(this, mImageIds);
        mBannerViewPager.setAdapter(pageAdapter);
        mBannerViewPager.setParent(recyclerView);
    }

    @Override
    public ShareInfoPresenter initPresenter() {
        return new ShareInfoPresenter();
    }


    @OnClick(R.id.lt_main_title_right)
    void initPopupWindow() {
        int width = lt_main_title_right.getWidth();
        int WidthPixels = DisplayUtils.getScreenWidthPixels(MainActivity.this);
        if (null == mPopupWindow || !mPopupWindow.isShowing()) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this
                    .getSystemService(LAYOUT_INFLATER_SERVICE);
            View popwindow_more = mLayoutInflater.inflate(
                    R.layout.popwindow_more, null);
            mPopupWindow = new PopupWindow(popwindow_more, WidthPixels / 3, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            mPopupWindow.showAsDropDown(lt_main_title_right, -width, 0);
            mPopupWindow.setOutsideTouchable(true);
            TextView tv_information = (TextView) popwindow_more.findViewById(R.id.tv_information);
            TextView tv_my_share = (TextView) popwindow_more.findViewById(R.id.tv_my_share);
            tv_my_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this, MinShareActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {

    }

    @Override
    public void setShareListData(ArrayList<ShareBean> data) {

    }
}
