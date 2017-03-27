package com.issp.association.crowdfunding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
<<<<<<< HEAD
import com.issp.association.crowdfunding.adapter.IndexPageAdapter;
=======
import com.issp.association.crowdfunding.base.adpater.BannerImageLoader;
>>>>>>> bxh
import com.issp.association.crowdfunding.adapter.SimpleAdapter;
import com.issp.association.crowdfunding.base.adpater.BaseRecyclerViewAdapter;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.presenters.ProductCollectPresenter;
import com.issp.association.crowdfunding.ui.activity.MessageActivity;
import com.issp.association.crowdfunding.ui.activity.MinProductActivity;
import com.issp.association.crowdfunding.utils.DisplayUtils;
<<<<<<< HEAD
import com.issp.association.crowdfunding.view.BannerViewPager;
import com.issp.association.crowdfunding.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.List;
=======
import com.issp.association.crowdfunding.view.CustomGifHeader;
import com.youth.banner.Banner;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> bxh
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

<<<<<<< HEAD
public class MainActivity extends BaseMvpActivity<IProductCollectListView,ProductCollectPresenter> implements IProductCollectListView {
=======
public class MainActivity extends BaseMvpActivity<IProductCollectListView, ProductCollectPresenter> implements IProductCollectListView {
>>>>>>> bxh

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
<<<<<<< HEAD

    private BannerViewPager mBannerViewPager;
    private int[] mImageIds = new int[]{R.mipmap.banner, R.mipmap.banner02};// 测试图片id
=======
    private int limit = 20;
    private int page = 1;

    Banner homepage_banner;

    private ArrayList<String> imgList;
    String[] images = {"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=699105693,866957547&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2152422253,1846971893&fm=21&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3258213409,1470632782&fm=21&gp=0.jpg"};

>>>>>>> bxh
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initClick();
    }

    @Override
    public ProductCollectPresenter initPresenter() {
        return new ProductCollectPresenter();
    }

<<<<<<< HEAD
    private void initView(){
=======
    private void initView() {
        lt_main_title.setText(getString(R.string.str_title_main));
>>>>>>> bxh
        xRefreshView.setPullLoadEnable(true);
        recyclerView.setHasFixedSize(true);

        initData();
        adapter = new SimpleAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
<<<<<<< HEAD
        headerView = adapter.setHeaderView(R.layout.bannerview, recyclerView);
//        LayoutInflater.from(this).inflate(R.layout.bannerview, rootview);
        mBannerViewPager = (BannerViewPager) headerView.findViewById(R.id.index_viewpager);

//        adHeader = new AdHeader(this);
//        mBannerViewPager = (LoopViewPager) adHeader.findViewById(R.id.index_viewpager);
        initViewPager();
=======
        headerView = adapter.setHeaderView(R.layout.view_banner, recyclerView);

        homepage_banner = (Banner) headerView.findViewById(R.id.homepage_banner);
        initBanner();

>>>>>>> bxh
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
<<<<<<< HEAD
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
=======
                page=1;
                initData();
                /*Random random = new Random();
                boolean success = random.nextBoolean();
                xRefreshView.stopRefresh(success);
*/
>>>>>>> bxh
            }

            @Override
            public void onLoadMore(boolean isSilence) {
<<<<<<< HEAD
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            ProductCollectBean person = new ProductCollectBean();
                            person.setTitle("标题"+i);
                            person.setContent("内容"+i);
=======
                page++;
                initData();
               /* new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            ProductCollectBean person = new ProductCollectBean();
                            //  person.setTitle("标题"+i);
                            person.setObjective("内容" + i);
>>>>>>> bxh
                            adapter.insert(person,
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
<<<<<<< HEAD
                }, 1000);
=======
                }, 1000);*/
>>>>>>> bxh
            }
        });
    }

    private void initData() {
<<<<<<< HEAD
        for (int i = 0; i < 3; i++) {
            ProductCollectBean person = new ProductCollectBean();
            person.setTitle("标题"+i);
            person.setContent("内容"+i);
            personList.add(person);
        }
    }
    private void initClick(){
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<ProductCollectBean>() {
            @Override
            public void onItemClick(View view, ProductCollectBean data) {
                Log.e("","");
=======
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("type", "1");
        formData.put("limit", limit + "");
        formData.put("page", page + "");
        presenter.ShareInfoPresenter(formData);

    }

    private void initClick() {
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<ProductCollectBean>() {
            @Override
            public void onItemClick(View view, ProductCollectBean data) {
                Log.e("", "");
>>>>>>> bxh
            }
        });
    }

<<<<<<< HEAD
    private void initViewPager() {
        IndexPageAdapter pageAdapter = new IndexPageAdapter(this, mImageIds);
        mBannerViewPager.setAdapter(pageAdapter);
        mBannerViewPager.setParent(recyclerView);
    }

=======
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


>>>>>>> bxh
    @OnClick(R.id.lt_main_title_right)
    void initPopupWindow() {
        int width = lt_main_title_right.getWidth();
        int WidthPixels = DisplayUtils.getScreenWidthPixels(MainActivity.this);
        if (null == mPopupWindow || !mPopupWindow.isShowing()) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this
                    .getSystemService(LAYOUT_INFLATER_SERVICE);
            View popwindow_more = mLayoutInflater.inflate(
                    R.layout.popwindow_more, null);
<<<<<<< HEAD
=======
            AutoUtils.autoSize(popwindow_more, AutoAttr.BASE_HEIGHT);
>>>>>>> bxh
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
<<<<<<< HEAD
                    Intent intent=new Intent(MainActivity.this, MessageActivity.class);
=======
                    Intent intent = new Intent(MainActivity.this, MessageActivity.class);
>>>>>>> bxh
                    startActivity(intent);
                    mPopupWindow.dismiss();
                }
            });
            tv_my_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
<<<<<<< HEAD
                    Intent intent=new Intent(MainActivity.this, MinProductActivity.class);
=======
                    Intent intent = new Intent(MainActivity.this, MinProductActivity.class);
>>>>>>> bxh
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
<<<<<<< HEAD

=======
        if (page == 1) {
            xRefreshView.stopRefresh(false);
        } else {
            xRefreshView.stopLoadMore(false);
        }
>>>>>>> bxh
    }

    @Override
    public void setProductCollectData(ArrayList<ProductCollectBean> data) {
<<<<<<< HEAD

    }
=======
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
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

>>>>>>> bxh
}
