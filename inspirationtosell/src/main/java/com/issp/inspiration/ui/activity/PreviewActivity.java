package com.issp.inspiration.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.issp.inspiration.App;
import com.issp.inspiration.R;
import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IPreviewView;
import com.issp.inspiration.listeners.OnPreviewListener;
import com.issp.inspiration.presenters.AddArticlePresenter;
import com.issp.inspiration.presenters.PreviewPresenter;
import com.issp.inspiration.utils.CircleTransform;
import com.issp.inspiration.utils.DisplayUtils;
import com.issp.inspiration.utils.T;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by T-BayMax on 2017/4/20.
 */

public class PreviewActivity extends BaseMvpActivity<IPreviewView, PreviewPresenter> implements IPreviewView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_deal_buy_icon)
    ImageView ivDealBuyIcon;
    @BindView(R.id.tv_deal_buy_user_Name)
    TextView tvDealBuyUserName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.wv_dealContent)
    WebView wvDealContent;

    DealBuyBean bean;
    File file;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);
        ltMainTitleRight.setCompoundDrawables(null,null,null,null);
        initData();
    }

    private void initData() {
        bean = (DealBuyBean) getIntent().getSerializableExtra("bean");
        ltMainTitle.setText("预览");
        ltMainTitleRight.setText("发布");
        tvDealBuyUserName.setText("");
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
        String date = sDateFormat.format(new java.util.Date());
        tvTime.setText(date);
        file = new File(bean.getImage());
        //Picasso.with(PreviewActivity.this).load(file).transform(new CircleTransform()).into(ivDealBuyIcon);
        Picasso.with(PreviewActivity.this).load(file).into(ivImage);

        wvContent.loadData(bean.getContent(), "text/html; charset=UTF-8", null);
        wvDealContent.loadData(bean.getDealContent(), "text/html; charset=UTF-8", null);
    }

    public void showComfirmDialog() {
        final AlertDialog ComfirmDialog = new AlertDialog.Builder(this).create();
        ComfirmDialog.show();
        Window window = ComfirmDialog.getWindow();
        WindowManager.LayoutParams lp = ComfirmDialog.getWindow().getAttributes();
        lp.width = DisplayUtils.dp2px(PreviewActivity.this, 300);//定义宽度
        lp.height = DisplayUtils.dp2px(PreviewActivity.this, 200);//定义高度
        ComfirmDialog.getWindow().setAttributes(lp);
        window.setContentView(R.layout.comfirm_dialog_layout);
        TextView tv_reminder = (TextView) window.findViewById(R.id.tv_reminder);
        tv_reminder.setText("确定发布内容");
        Button btn_comfirm_dialog_comfirm = (Button) window.findViewById(R.id.btn_comfirm_dialog_comfirm);
        ImageView iv_comfirm_dialog_cancel = (ImageView) window.findViewById(R.id.iv_comfirm_dialog_cancel);
        btn_comfirm_dialog_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("title", bean.getTitle());
                formData.put("content", bean.getContent());
                formData.put("dealContent", bean.getDealContent());
                formData.put("dealContribution", bean.getDealContribution() + "");
                presenter.publishAnArticlePresenter(formData, file, "file");
            }
        });
        iv_comfirm_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmDialog.dismiss();
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void publishAnArticleView(String data) {

        T.showShort(PreviewActivity.this, "灵感贩卖发表成功！");
        App.activityMap.get("AddArticleActivity").finish();
        PreviewActivity.this.finish();
    }

    @Override
    public void showError(String errorString) {
        T.showLong(PreviewActivity.this, errorString);
    }

    @Override
    public PreviewPresenter initPresenter() {
        return new PreviewPresenter();
    }

    @OnClick(R.id.lt_main_title_right)
    public void onViewClicked() {
        showComfirmDialog();
    }
}
