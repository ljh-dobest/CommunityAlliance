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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.issp.inspiration.R;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IReadDealBuyView;
import com.issp.inspiration.network.HttpUtils;
import com.issp.inspiration.presenters.ReadDealBuyInfoPresenter;
import com.issp.inspiration.utils.DisplayUtils;
import com.issp.inspiration.utils.T;
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
    @BindView(R.id.ll_play)
    LinearLayout llPlay;
    @BindView(R.id.tv_play_time)
    TextView tvPlayTime;
    @BindView(R.id.ll_buy_and_play)
    LinearLayout llBuyAndPlay;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.wv_play)
    WebView wvPlay;


    private static final int REQUEST_CODE = 1;

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
        getDealBuy();
    }

    private void getDealBuy() {

        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        presenter.ReadShareInfoPresenter(formData);
    }

    public void showComfirmDialog() {
        final AlertDialog ComfirmDialog = new AlertDialog.Builder(this).create();
        ComfirmDialog.show();
        Window window = ComfirmDialog.getWindow();
        WindowManager.LayoutParams lp = ComfirmDialog.getWindow().getAttributes();
        lp.width = DisplayUtils.dp2px(ReadDealBuyActivity.this, 300);//定义宽度
        lp.height = DisplayUtils.dp2px(ReadDealBuyActivity.this, 200);//定义高度
        ComfirmDialog.getWindow().setAttributes(lp);
        window.setContentView(R.layout.comfirm_dialog_layout);
        Button btn_comfirm_dialog_comfirm = (Button) window.findViewById(R.id.btn_comfirm_dialog_comfirm);
        ImageView iv_comfirm_dialog_cancel = (ImageView) window.findViewById(R.id.iv_comfirm_dialog_cancel);
        btn_comfirm_dialog_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadDealBuyActivity.this, DealBuyConfirmOrderActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
                ComfirmDialog.dismiss();
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
    void buyClick() {
        showComfirmDialog();
    }

    @OnClick(R.id.ll_like)
    void likeClick() {
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        formData.put("type", "5");
        formData.put("status", "1");
        presenter.sharePraiseInfoPresenter(formData);
    }

    @OnClick(R.id.ll_comment)
    void commentClick() {
        Intent intent = new Intent(ReadDealBuyActivity.this, FeedForCommentActivity.class);
        intent.putExtra("bean", bean);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void showError(String errorString) {
        T.showLong(ReadDealBuyActivity.this, errorString);
    }

    @Override
    public void setDealBuyData(DealBuyBean data) {
        tvTitle.setText(data.getTitle());
        tvDealBuyUserName.setText(data.getNickname());
        tvTime.setText(data.getReleaseTime());
        Picasso.with(ReadDealBuyActivity.this).load(HttpUtils.IMAGE_RUL + data.getUserPortraitUrl()).into(ivDealBuyIcon);
        wvContent.loadData(data.getContent(), "text/html; charset=UTF-8", null);
        tvLikeBtn.setText(data.getLikes() + "");
        tvCommentBtn.setText("" + data.getCommentNumber());
        switch (data.getStatusLikes()) {
            case 0:
                ivLikeBtn.setImageResource(R.mipmap.img_like_btn);
                break;
            case 1:
                ivLikeBtn.setImageResource(R.mipmap.img_have_thumb_up_btn);
                break;
            case 2:
                ivLikeBtn.setImageResource(R.mipmap.img_like_btn_no);
                break;
            case 3:
                ivLikeBtn.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
                break;
        }
        if (null != data.getDealContent() && !data.getDealContent().equals("")) {
            llBuy.setVisibility(View.GONE);
            llPlay.setVisibility(View.VISIBLE);
            wvPlay.loadData(data.getDealContent(), "text/html; charset=UTF-8", null);
        }
        bean = data;
    }

    @Override
    public void dealBuyPraise(String data) {
        int likes = Integer.parseInt(tvLikeBtn.getText().toString().trim());
        tvLikeBtn.setText((likes + 1) + "");
        ivLikeBtn.setImageResource(R.mipmap.img_have_thumb_up_btn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE){
                getDealBuy();
            }
        }
    }
}
