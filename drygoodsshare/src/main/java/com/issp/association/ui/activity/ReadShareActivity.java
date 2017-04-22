package com.issp.association.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.issp.association.R;
import com.issp.association.base.view.BaseMvpActivity;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IReadShareView;
import com.issp.association.network.HttpUtils;
import com.issp.association.presenters.ReadShareInfoPresenter;
import com.issp.association.utils.CircleTransform;
import com.issp.association.utils.T;
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

public class ReadShareActivity extends BaseMvpActivity<IReadShareView, ReadShareInfoPresenter> implements IReadShareView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_share_icon)
    ImageView ivShareIcon;
    @BindView(R.id.tv_share_user_Name)
    TextView tvShareUserName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_share_btn)
    ImageView ivShareBtn;
    @BindView(R.id.tv_share_btn)
    TextView tvShareBtn;
    @BindView(R.id.iv_like_btn)
    ImageView ivLikeBtn;
    @BindView(R.id.tv_like_btn)
    TextView tvLikeBtn;
    @BindView(R.id.iv_comment_btn)
    ImageView ivCommentBtn;
    @BindView(R.id.tv_comment_btn)
    TextView tvCommentBtn;
    @BindView(R.id.iv_collect_btn)
    ImageView ivCollectBtn;
    @BindView(R.id.tv_collect_btn)
    TextView tvCollectBtn;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.ll_like)
    LinearLayout llLike;
    @BindView(R.id.ll_share)
    LinearLayout llShare;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;
    @BindView(R.id.ll_collect)
    LinearLayout llCollect;

    ShareBean bean;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.wv_cynopsis)
    WebView wvCynopsis;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_share);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ltMainTitleLeft.setText("返回");
        ltMainTitle.setText("");
        Intent intent = getIntent();
        bean = (ShareBean) intent.getSerializableExtra("bean");
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("shareId", bean.getId());
        presenter.ReadShareInfoPresenter(formData);
    }

    @Override
    public ReadShareInfoPresenter initPresenter() {
        return new ReadShareInfoPresenter();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        ReadShareActivity.this.finish();
    }

    @OnClick(R.id.ll_like)
    void likeClick() {
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        formData.put("type", "3");
        formData.put("status", "1");
        presenter.sharePraiseInfoPresenter(formData);
    }

    @OnClick(R.id.ll_comment)
    void commentClick() {
        Intent intent = new Intent(ReadShareActivity.this, FeedForCommentActivity.class);
        intent.putExtra("bean", bean);
        startActivity(intent);
    }

    @Override
    public void showError(String errorString) {
        T.showShort(ReadShareActivity.this, errorString);
    }

    @Override
    public void setReadShareData(ShareBean data) {
        tvTitle.setText(data.getTitle());
        tvShareUserName.setText(data.getNickname());
        tvTime.setText(data.getTime());
        if (null != data.getUserPortraitUrl())
            Picasso.with(ReadShareActivity.this).load(HttpUtils.IMAGE_RUL + data.getUserPortraitUrl())
                    .transform(new CircleTransform()).into(ivShareIcon);
        if (null != data.getImage())
            Picasso.with(ReadShareActivity.this).load(HttpUtils.IMAGE_RUL + data.getImage())
                    .into(ivImage);
        wvCynopsis.loadData(data.getSynopsis(), "text/html; charset=UTF-8", null);
        wvContent.loadData(data.getContent(), "text/html; charset=UTF-8", null);
        tvLikeBtn.setText(data.getLikes() + "");

        tvCommentBtn.setText("" + data.getCommentNumber());
        switch (data.getLikesStatus()) {
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
    }

    @Override
    public void sharePraise(String data) {
        int likes = Integer.parseInt(tvLikeBtn.getText().toString().trim());
        tvLikeBtn.setText((likes + 1) + "");
        ivLikeBtn.setImageResource(R.mipmap.img_have_thumb_up_btn);
        T.showShort(ReadShareActivity.this, data);
    }
}
