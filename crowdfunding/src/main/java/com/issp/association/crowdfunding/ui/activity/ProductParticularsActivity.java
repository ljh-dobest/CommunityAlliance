package com.issp.association.crowdfunding.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
 * 众筹详情
>>>>>>> bxh
=======
 * 众筹详情
>>>>>>> bxh
 * Created by T-BayMax on 2017/3/23.
 */

public class ProductParticularsActivity extends BaseMvpActivity {


    @BindView(R.id.tv_release_time)
    TextView tvReleaseTime;
    @BindView(R.id.tv_inform)
    TextView tvInform;
    @BindView(R.id.tv_comment)
    TextView tvComment;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_product_particulars);
        ButterKnife.bind(this);
    }

    @Override
    public BasePersenter initPresenter() {
        return null;
    }
}
