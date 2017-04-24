package com.issp.association.crowdfunding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.issp.association.crowdfunding.adapter.IndexPageAdapter;
import com.issp.association.crowdfunding.adapter.SimpleAdapter;
import com.issp.association.crowdfunding.base.adpater.BannerImageLoader;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.presenters.ProductCollectPresenter;
import com.issp.association.crowdfunding.ui.activity.AddCrowdFundingActivity;
import com.issp.association.crowdfunding.ui.activity.FeedForCommentActivity;
import com.issp.association.crowdfunding.ui.activity.MessageActivity;
import com.issp.association.crowdfunding.ui.activity.MinProductActivity;
import com.issp.association.crowdfunding.ui.activity.ProductIDCardActivity;
import com.issp.association.crowdfunding.ui.activity.ProductParticularsActivity;
import com.issp.association.crowdfunding.utils.DisplayUtils;
import com.issp.association.crowdfunding.utils.T;
import com.issp.association.crowdfunding.view.BannerViewPager;
import com.issp.association.crowdfunding.view.CustomGifHeader;
import com.youth.banner.Banner;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 产品众筹
 * Created by T-BayMax on 2017/3/21.
 */
public class MainActivity extends BaseMvpActivity<IProductCollectListView, ProductCollectPresenter> implements IProductCollectListView {


    @BindView(R.id.tv_add_product)
    TextView tvAddProduct;
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

    SimpleAdapter adapter;
    List<ProductCollectBean> personList = new ArrayList<ProductCollectBean>();
    GridLayoutManager layoutManager;
    private int mLoadCount = 0;

    private BannerViewPager mBannerViewPager;
    private int[] mImageIds = new int[]{R.mipmap.banner, R.mipmap.banner02};// 测试图片id

    private int limit = 20;
    private int page = 1;

    private boolean isRefresh;
    Banner homepage_banner;
    private boolean isIDCard;

    private ArrayList<String> imgList;
    String[] images = {"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=699105693,866957547&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2152422253,1846971893&fm=21&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3258213409,1470632782&fm=21&gp=0.jpg"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        //initClick();
    }

    @Override
    public ProductCollectPresenter initPresenter() {
        return new ProductCollectPresenter();
    }

    TextView tv_like_btn;
    ImageView iv_like_btn;

    private void initView() {
        lt_main_title.setText(getString(R.string.str_title_main));

        xRefreshView.setPullLoadEnable(true);
        recyclerView.setHasFixedSize(true);

        initData();
        adapter = new SimpleAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        headerView = adapter.setHeaderView(R.layout.view_banner, recyclerView);

        homepage_banner = (Banner) headerView.findViewById(R.id.homepage_banner);
        initBanner();

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

                page = 1;
                initData();
                checkIDCard();
            }

            @Override
            public void onLoadMore(boolean isSilence) {

                page++;
                initData();

            }
        });
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ProductCollectBean bean) {
                Intent intent = new Intent(MainActivity.this, ProductParticularsActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }

            @Override
            public void onLikeClick(View view, ProductCollectBean bean) {
                isRefresh = false;
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("articleId", bean.getId());
                formData.put("type", "1");
                formData.put("status", "1");
                tv_like_btn = (TextView) view.findViewById(R.id.tv_like_btn);
                iv_like_btn = (ImageView) view.findViewById(R.id.iv_like_btn);

                presenter.postUserPraise(formData);
            }

            @Override
            public void onCommentClick(View view, ProductCollectBean bean) {
                Intent intent = new Intent(MainActivity.this, FeedForCommentActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);

            }
        });
        checkIDCard();
    }
    private void checkIDCard(){
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        presenter.selectProductIdCardPresenter(formData);
    }

    private void initData() {
        isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("type", "1");
        formData.put("limit", limit + "");
        formData.put("page", page + "");
        presenter.ShareInfoPresenter(formData);

    }
/*
    private void initClick() {
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<ProductCollectBean>() {
            @Override
            public void onItemClick(View view, ProductCollectBean data) {
                Log.e("", "");

            }
        });
    }*/

    private void initViewPager() {
        IndexPageAdapter pageAdapter = new IndexPageAdapter(this, mImageIds);
        mBannerViewPager.setAdapter(pageAdapter);
        mBannerViewPager.setParent(recyclerView);
    }


    private void initBanner() {
        imgList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            imgList.add(images[i]);
        }
        //设置图片加载器
        homepage_banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        homepage_banner.setImages(imgList);
        //设置滚动时间
        homepage_banner.setDelayTime(5000);
        //banner设置方法全部调用完毕时最后调用
        homepage_banner.start();
    }


    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        MainActivity.this.finish();
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

            AutoUtils.autoSize(popwindow_more, AutoAttr.BASE_HEIGHT);

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

                    Intent intent = new Intent(MainActivity.this, MessageActivity.class);

                    startActivity(intent);
                    mPopupWindow.dismiss();
                }
            });
            tv_my_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, MinProductActivity.class);

                    startActivity(intent);
                    mPopupWindow.dismiss();
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
    public void setProductCollectData(ArrayList<ProductCollectBean> data) {

        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }

    @Override
    public void selectProductIdCardView(String data) {
        isIDCard = true;
    }

    @Override
    public void userPraise(String data) {
        T.showLong(MainActivity.this, data);
    }

    @Override
    public void onStart() {
        super.onStart();
        homepage_banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        homepage_banner.stopAutoPlay();
    }

    @OnClick(R.id.tv_add_product)
    public void onViewClicked() {
        if (isIDCard){
            Intent intent = new Intent(MainActivity.this, AddCrowdFundingActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(MainActivity.this, ProductIDCardActivity.class);
            startActivity(intent);
        }
    }
}
