package com.issp.association.crowdfunding.ui.activity;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.issp.association.crowdfunding.interfaces.IAddCrowdFundingView;
import com.issp.association.crowdfunding.presenters.AddProductCollectPresenter;
import com.issp.association.crowdfunding.utils.DisplayUtils;
import com.issp.association.crowdfunding.utils.T;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.lang.reflect.Type;
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

    private List<View> layoutList = new ArrayList<View>(0);
    Map<Integer, ProductRewardBean> listBean = new HashMap<Integer, ProductRewardBean>(0);

    private int REQUEST_CODE = 1;
    private int REQUEST_CONTENT = 200;

    private int crowdType;
    private String content;
    private String path;
    private File file;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crowd_funding);
        ButterKnife.bind(this);
        checkedChanged();
        addCommodity();
    }

    private void checkedChanged() {
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (group.getId()) {
                    case R.id.rb_product:
                        crowdType = 1;
                        break;
                    case R.id.rb_seek_help:
                        crowdType = 2;
                        break;
                }
            }
        });
    }

    /**
     * 添加商品项
     */
    private void addCommodity() {
        View view = getLayoutInflater().inflate(R.layout.view_product_commodity, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_commodity_name);
        tv.setText("商品" + (layoutList.size() + 1));
        llProductCommodity.addView(view);
        layoutList.add(view);
        commodityClick();
    }

    private void commodityClick() {
        for (int i = 0; i < layoutList.size(); i++) {
            final int finalI = i;
            layoutList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddCrowdFundingActivity.this, AddCommodityActivity.class);
                    startActivityForResult(intent, finalI);
                }
            });
        }
    }

    private void clickImage() {
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

    public void showComfirmDialog() {
        final AlertDialog ComfirmDialog = new AlertDialog.Builder(this).create();
        ComfirmDialog.show();
        Window window = ComfirmDialog.getWindow();
        WindowManager.LayoutParams lp = ComfirmDialog.getWindow().getAttributes();
        lp.width = DisplayUtils.dp2px(AddCrowdFundingActivity.this, 300);//定义宽度
        lp.height = DisplayUtils.dp2px(AddCrowdFundingActivity.this, 200);//定义高度
        ComfirmDialog.getWindow().setAttributes(lp);
        window.setContentView(R.layout.comfirm_dialog_layout);
        TextView tv_reminder = (TextView) window.findViewById(R.id.tv_reminder);
        tv_reminder.setText("确定发布内容");
        Button btn_comfirm_dialog_comfirm = (Button) window.findViewById(R.id.btn_comfirm_dialog_comfirm);
        ImageView iv_comfirm_dialog_cancel = (ImageView) window.findViewById(R.id.iv_comfirm_dialog_cancel);
        btn_comfirm_dialog_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        iv_comfirm_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmDialog.dismiss();
            }
        });
    }
    private void submit(){

        Map<String, String> formData = new HashMap<String, String>(0);

        String title = etTitle.getText().toString().trim();
        String objective = etObjective.getText().toString().trim();
        String capital = etCapital.getText().toString().trim();
        String days = etDays.getText().toString().trim();
        if (file==null){
            T.showLong(AddCrowdFundingActivity.this,"请选择封面图");
            return;
        }
        if (title.equals("")){
            T.showLong(AddCrowdFundingActivity.this,"请输入项目标题");
            return;
        }
        if (objective.equals("")){
            T.showLong(AddCrowdFundingActivity.this,"请输入众筹目的");
            return;
        }
        if (capital.equals("")){
            T.showLong(AddCrowdFundingActivity.this,"请输入众筹金额");
            return;
        }
        if (days.equals("")){
            T.showLong(AddCrowdFundingActivity.this,"请输入众筹天数");
            return;
        }
        if(listBean.size()==0){
            T.showLong(AddCrowdFundingActivity.this,"请输入商品");
            return;
        }
        formData.put("userId", "111");
        formData.put("title", title);
        formData.put("capital", capital);
        formData.put("content", content);
        formData.put("objective", objective);
        formData.put("days", days);
        formData.put("type", crowdType + "");

        Gson gson = new Gson();
        List<ProductRewardBean> list = new ArrayList<ProductRewardBean>(listBean.values());
        Type type = new TypeToken<List<ProductRewardBean>>() {
        }.getType();
        String productReward = gson.toJson(list, type);
        formData.put("productReward", productReward);


        presenter.addProductCollect(formData, file, "file");
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

    @OnClick({R.id.lt_main_title_left, R.id.tv_imgage, R.id.ll_product_content, R.id.iv_add_commodity, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                AddCrowdFundingActivity.this.finish();
                break;
            case R.id.tv_imgage:
                clickImage();
                break;
            case R.id.ll_product_content:
                Intent intent = new Intent(AddCrowdFundingActivity.this, GraphicDetailsActivity.class);
                startActivityForResult(intent, REQUEST_CONTENT);
                break;
            case R.id.iv_add_commodity:
                addCommodity();
                break;
            case R.id.tv_submit:
                showComfirmDialog();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == REQUEST_CODE) {
            listBean.put(requestCode, (ProductRewardBean) data.getSerializableExtra("ProductReward"));
         }else if (resultCode==REQUEST_CONTENT){
            content=data.getStringExtra("productReward");
        }
    }
}
