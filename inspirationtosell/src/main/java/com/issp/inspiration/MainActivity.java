package com.issp.inspiration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.inspiration.adapter.IndexPageAdapter;
import com.issp.inspiration.adapter.SimpleAdapter;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IDealBuyListView;
import com.issp.inspiration.presenters.DealBuyInfoPresenter;
import com.issp.inspiration.presenters.ReadDealBuyInfoPresenter;
import com.issp.inspiration.ui.activity.DealBuyCommentActivity;
import com.issp.inspiration.ui.activity.ReadDealBuyActivity;
import com.issp.inspiration.utils.DisplayUtils;
import com.issp.inspiration.utils.T;
import com.issp.inspiration.view.BannerViewPager;
import com.issp.inspiration.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<IDealBuyListView, DealBuyInfoPresenter> implements IDealBuyListView {

    private PopupWindow mPopupWindow;

    @BindView(R.id.lt_main_title_left)
    TextView lt_main_title_left;
    @BindView(R.id.lt_main_title)
    TextView lt_main_title;
    @BindView(R.id.lt_main_title_right)
    TextView lt_main_title_right;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerView;
    @BindView(R.id.xrefreshview)
    XRefreshView xRefreshView;

    private View headerView;

    private boolean isRefresh;

    SimpleAdapter adapter;
    List<DealBuyBean> personList = new ArrayList<DealBuyBean>();
    GridLayoutManager layoutManager;
    private int mLoadCount = 0;


    private int limit = 20;
    private int page = 1;

    private BannerViewPager mBannerViewPager;
    private int[] mImageIds = new int[]{R.mipmap.banner, R.mipmap.banner02};// 测试图片id

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        lt_main_title.setText("干货分享");
        xRefreshView.setPullLoadEnable(true);
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
        xRefreshView.setPinnedTime(1500);
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
                page = 1;
                initData();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                page++;
                initData();
            }
        });
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DealBuyBean bean) {
                Intent intent = new Intent(MainActivity.this, ReadDealBuyActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }

            @Override
            public void onLikeClick(View view, DealBuyBean bean) {
                isRefresh=false;
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("shareId", bean.getId());
                formData.put("praise", "1");
                tv_like_btn = (TextView) view.findViewById(R.id.tv_like_btn);
                iv_like_btn = (ImageView) view.findViewById(R.id.iv_like_btn);

                presenter.sharePraiseInfoPresenter(formData);
            }

            @Override
            public void onCommentClick(View view, DealBuyBean bean) {
                Intent intent = new Intent(MainActivity.this, DealBuyCommentActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }
        });
    }

    TextView tv_like_btn;
    ImageView iv_like_btn;

    private void initData() {
        isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("page", page + "");
        presenter.ShareInfoPresenter(formData);

    }


    private void initViewPager() {
        IndexPageAdapter pageAdapter = new IndexPageAdapter(this, mImageIds);
        mBannerViewPager.setAdapter(pageAdapter);
        mBannerViewPager.setParent(recyclerView);
    }

    @Override
    public DealBuyInfoPresenter initPresenter() {
        return new DealBuyInfoPresenter();
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
            mPopupWindow.setTouchable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
            mPopupWindow.showAsDropDown(lt_main_title_right, -width, 0);
            TextView tv_information = (TextView) popwindow_more.findViewById(R.id.tv_information);
            TextView tv_my_share = (TextView) popwindow_more.findViewById(R.id.tv_my_share);

            tv_information.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent intent = new Intent(MainActivity.this, CommentMessageActivity.class);
                    startActivity(intent);
                    mPopupWindow.dismiss();*/
                }
            });
            tv_my_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  /*  Intent intent = new Intent(MainActivity.this, MinShareActivity.class);
                    startActivity(intent);
                    mPopupWindow.dismiss();*/
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
        if (isRefresh)
            if (page == 1) {
                xRefreshView.stopRefresh(false);
            } else {
                xRefreshView.stopLoadMore(false);
            }
        T.showShort(MainActivity.this, errorString);
    }

    @Override
    public void setDealBuyListData(ArrayList<DealBuyBean> data) {
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }

    @Override
    public void dealBuyPraise(String data) {
        int likes = Integer.parseInt(tv_like_btn.getText().toString().trim());
        tv_like_btn.setText((likes + 1) + "");
        iv_like_btn.setImageResource(R.mipmap.img_have_thumb_up_btn);
        T.showShort(MainActivity.this, data);
    }
}