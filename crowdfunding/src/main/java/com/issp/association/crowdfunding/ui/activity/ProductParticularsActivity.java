package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.MainActivity;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductParticularsInfoView;
import com.issp.association.crowdfunding.presenters.ProductParticularsPresenter;
import com.issp.association.crowdfunding.utils.T;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 众筹详情
 * <p>
 * Created by T-BayMax on 2017/3/23.
 */

public class ProductParticularsActivity extends BaseMvpActivity<IProductParticularsInfoView, ProductParticularsPresenter> implements IProductParticularsInfoView {


    @BindView(R.id.tv_release_time)
    TextView tvReleaseTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_inform)
    TextView tvInform;
    @BindView(R.id.wv_comment)
    WebView wvContent;
    @BindView(R.id.tv_back_left)
    TextView tvBackLeft;
    @BindView(R.id.tv_check_indent)
    TextView tvCheckIndent;
    @BindView(R.id.iv_share_btn)
    ImageView ivShareBtn;
    @BindView(R.id.iv_like_btn)
    ImageView ivLikeBtn;
    @BindView(R.id.iv_comment_btn)
    ImageView ivCommentBtn;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;

    private ProductCollectBean bean;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_product_particulars);
        ButterKnife.bind(this);
        initData();
    }

    void initData() {
        bean = (ProductCollectBean) getIntent().getSerializableExtra("bean");
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId", bean.getId());
        formData.put("type", "1");
        presenter.productCommentInfoPresenter(formData);
    }

    @OnClick(R.id.tv_back_left)
    void leftClick() {
        ProductParticularsActivity.this.finish();
    }

    @OnClick(R.id.tv_check_indent)
    void checkIndentClick() {
        Intent intent = new Intent(ProductParticularsActivity.this, SupportProductActivity.class);
        intent.putExtra("bean", bean);
        startActivity(intent);
    }

    @Override
    public ProductParticularsPresenter initPresenter() {
        return new ProductParticularsPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {
        T.showLong(ProductParticularsActivity.this,errorString);
    }

    @Override
    public void setProductParticularsInfoData(ProductCollectBean data) {
        tvReleaseTime.setText(data.getTime());
        tvTitle.setText(data.getTitle());
        wvContent.loadData(data.getContent(), "text/html; charset=UTF-8", null);
        switch (data.getLikeStatus()) {
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
      /*  Picasso.with(ProductParticularsActivity.this).load(HttpUtils.IMAGE_RUL + bean.getImage())
                .into(iv);*/

    }

    @Override
    public void userPraise(String data) {
        ivLikeBtn.setImageResource(R.mipmap.img_have_thumb_up_btn);
        T.showLong(ProductParticularsActivity.this,data);
    }

    @OnClick({R.id.iv_share_btn, R.id.iv_like_btn, R.id.iv_comment_btn,R.id.tv_check_indent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_share_btn:
                break;
            case R.id.iv_like_btn:
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("articleId", bean.getId());
                formData.put("type", "1");
                formData.put("status","1");
                presenter.postUserPraise(formData);
                break;
            case R.id.iv_comment_btn:
                Intent intent = new Intent(ProductParticularsActivity.this, FeedForCommentActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
                break;
            case R.id.tv_check_indent:
                break;
        }
    }
}
