package com.issp.inspiration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.issp.inspiration.R;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IReadDealBuyView;
import com.issp.inspiration.network.HttpUtils;
import com.issp.inspiration.presenters.ReadDealBuyInfoPresenter;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 分享预览
 * Created by T-BayMax on 2017/3/18.
 */

public class ReadDealBuyActivity extends BaseMvpActivity<IReadDealBuyView, ReadDealBuyInfoPresenter> implements IReadDealBuyView {


    DealBuyBean bean;
    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_deal_buy_icon)
    ImageView ivDealBuyIcon;
    @BindView(R.id.tv_deal_buy_user_Name)
    TextView tvDealBuyUserName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_share_btn)
    ImageView ivShareBtn;
    @BindView(R.id.tv_share_btn)
    TextView tvShareBtn;
    @BindView(R.id.ll_share)
    LinearLayout llShare;
    @BindView(R.id.iv_like_btn)
    ImageView ivLikeBtn;
    @BindView(R.id.tv_like_btn)
    TextView tvLikeBtn;
    @BindView(R.id.ll_like)
    LinearLayout llLike;
    @BindView(R.id.iv_comment_btn)
    ImageView ivCommentBtn;
    @BindView(R.id.tv_comment_btn)
    TextView tvCommentBtn;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.iv_play)
    ImageView ivPlay;
    @BindView(R.id.pb_play)
    ProgressBar pbPlay;
    @BindView(R.id.ll_play)
    LinearLayout llPlay;
    @BindView(R.id.tv_play_time)
    TextView tvPlayTime;
    @BindView(R.id.ll_buy_and_play)
    LinearLayout llBuyAndPlay;
    @BindView(R.id.wv_content)
    WebView wvContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_deal_buy);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ltMainTitleLeft.setText("返回");
        ltMainTitle.setText("");
        Intent intent = getIntent();
        bean = (DealBuyBean) intent.getSerializableExtra("bean");
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        presenter.ReadShareInfoPresenter(formData);
    }

    @Override
    public ReadDealBuyInfoPresenter initPresenter() {
        return new ReadDealBuyInfoPresenter();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        ReadDealBuyActivity.this.finish();
    }

    @OnClick(R.id.tv_buy)
    void buyClick(){
        Intent intent=new Intent(ReadDealBuyActivity.this,DealBuyConfirmOrderActivity.class);
        intent.putExtra("bean",bean);
        startActivity(intent);
    }

    @OnClick(R.id.ll_like)
    void likeClick() {
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        formData.put("praise", "1");
        presenter.sharePraiseInfoPresenter(formData);
    }

    @OnClick(R.id.ll_comment)
    void commentClick() {
        Intent intent = new Intent(ReadDealBuyActivity.this, DealBuyCommentActivity.class);
        intent.putExtra("bean", bean);
        startActivity(intent);
    }

    @Override
    public void showError(String errorString) {

    }

    @Override
    public void setDealBuyData(DealBuyBean data) {
        tvTitle.setText(data.getTitle());
        tvDealBuyUserName.setText(data.getNickname());
        tvTime.setText(data.getTime());
        Picasso.with(ReadDealBuyActivity.this).load(HttpUtils.IMAGE_RUL + data.getUserPortraitUrl()).into(ivDealBuyIcon);
        wvContent.loadData(data.getContent(), "text/html; charset=UTF-8", null);
        //tvLikeBtn.setText(data.getLikes() + "");
    }

    @Override
    public void dealBuyPraise(String data) {

    }
}
