package com.issp.association.crowdfunding.ui.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.issp.association.crowdfunding.interfaces.IAddCrowdFundingView;
import com.issp.association.crowdfunding.presenters.AddProductCollectPresenter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultSubscriber;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;

/**
 * 添加众筹
 * Created by T-BayMax on 2017/4/21.
 */

public class AddCrowdFundingActivity extends BaseMvpActivity<IAddCrowdFundingView, AddProductCollectPresenter> implements IAddCrowdFundingView {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.tv_imgage)
    TextView tvImgage;
    @BindView(R.id.rb_product)
    RadioButton rbProduct;
    @BindView(R.id.rb_seek_help)
    RadioButton rbSeekHelp;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_objective)
    EditText etObjective;
    @BindView(R.id.et_capital)
    EditText etCapital;
    @BindView(R.id.tv_product_days)
    TextView tvProductDays;
    @BindView(R.id.tv_days)
    TextView tvDays;
    @BindView(R.id.et_days)
    EditText etDays;
    @BindView(R.id.ll_product_content)
    LinearLayout llProductContent;
    @BindView(R.id.ll_product_commodity)
    LinearLayout llProductCommodity;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_add_commodity)
    ImageView ivAddCommodity;

    private List<View> layoutList=new ArrayList<View>(0);
    Map<Integer,ProductRewardBean> listBean=new HashMap<Integer,ProductRewardBean>(0);

    private int REQUEST_CODE = 1;

    private String path;
    private File file;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crowd_funding);
        ButterKnife.bind(this);
    }

    /**
     * 添加商品项
     */
    private void addCommodity(){
        View view=getLayoutInflater().inflate(R.layout.view_product_commodity,null);
        TextView tv= (TextView) view.findViewById(R.id.tv_commodity_name);
        tv.setText("商品"+(layoutList.size()+1));
        llProductCommodity.addView(view);
        layoutList.add(view);
        commodityClick();
    }
    private void commodityClick(){
        for (int i = 0; i <layoutList.size(); i++) {
            final int finalI = i;
            layoutList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(AddCrowdFundingActivity.this,AddCommodityActivity.class);
                        startActivityForResult(intent, finalI);
                    }
                });
        }
    }
    private void clickImage(){
        RxGalleryFinal
                .with(AddCrowdFundingActivity.this)
                .image()
                .radio()
                .crop()
                .imageLoader(ImageLoaderType.PICASSO)
                .subscribe(new RxBusResultSubscriber<ImageRadioResultEvent>() {
                    @Override
                    protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                        path = imageRadioResultEvent.getResult().getOriginalPath();
                        file = new File(path);
                        Picasso.with(getBaseContext()).load(file).into(new Target() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                tvImgage.setBackground(new BitmapDrawable(getResources(), bitmap));
                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {

                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });
                    }
                }).openGallery();

    }

    @Override
    public AddProductCollectPresenter initPresenter() {
        return new AddProductCollectPresenter();
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
    public void productCollectView(String data) {

    }

    @OnClick({R.id.lt_main_title_left,R.id.tv_imgage, R.id.ll_product_content,R.id.iv_add_commodity, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                AddCrowdFundingActivity.this.finish();
                break;
            case R.id.tv_imgage:
                clickImage();
                break;
            case R.id.ll_product_content:
                break;
            case R.id.iv_add_commodity:
                addCommodity();
                break;
            case R.id.tv_submit:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (resultCode == REQUEST_CODE) {
            listBean.put(requestCode, (ProductRewardBean) data.getSerializableExtra("ProductReward"));
       // }
    }
}
