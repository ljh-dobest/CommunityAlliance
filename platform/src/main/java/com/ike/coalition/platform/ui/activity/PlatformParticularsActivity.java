package com.ike.coalition.platform.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ike.coalition.platform.R;
import com.ike.coalition.platform.adapter.PlatformRegisteredAdapter;
import com.ike.coalition.platform.base.view.BaseMvpActivity;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.interfaces.IPlatformParticularsView;
import com.ike.coalition.platform.network.HttpUtils;
import com.ike.coalition.platform.presenters.PlatformParticularsPresenter;
import com.ike.coalition.platform.utils.T;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by T-BayMax on 2017/4/8.
 */

public class PlatformParticularsActivity extends BaseMvpActivity<IPlatformParticularsView, PlatformParticularsPresenter> implements IPlatformParticularsView {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.iv_platform)
    ImageView ivPlatform;
    @BindView(R.id.tv_platform_title)
    TextView tvPlatformTitle;
    @BindView(R.id.tv_actives_address)
    TextView tvActivesAddress;
    @BindView(R.id.tv_actives_time)
    TextView tvActivesTime;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_deadline)
    TextView tvDeadline;
    @BindView(R.id.tv_cost_money)
    TextView tvCostMoney;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.wv_content)
    WebView wvContent;
    @BindView(R.id.tv_join_users_number)
    TextView tvJoinUsersNumber;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.gv_user)
    GridView gvUser;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.iv_like)
    ImageView ivLike;
    @BindView(R.id.iv_comment_btn)
    ImageView ivCommentBtn;
    @BindView(R.id.tv_add_register)
    TextView tvAddRegister;
    @BindView(R.id.ll_handle)
    LinearLayout llHandle;

    Dialog mDialog;
    PlatformBean bean;

    PlatformRegisteredAdapter adapter;

    int joinUsersNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_particulars);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        bean = (PlatformBean) getIntent().getSerializableExtra("bean");
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("activesId", bean.getId());
        presenter.ParticularsPresenter(formData);
    }

    private void TakePhotoPopWin() {
        mDialog = new Dialog(PlatformParticularsActivity.this, R.style.dialog);
        mDialog.setContentView(R.layout.popwindow_add_register);// 设置View
        mDialog.setCanceledOnTouchOutside(false); // 设置点击外部不消失
        ViewGroup.LayoutParams layoutParams = getWindow().getAttributes();
        Window window = mDialog.getWindow();
        ViewGroup.LayoutParams attributes = window.getAttributes();
        layoutParams.height = attributes.height;// 获取Dialog View的高度，设置高度,View 的高度
        layoutParams.width = layoutParams.width;// 设置宽度，是屏幕的宽度
        int gravity = Gravity.BOTTOM;// 底部弹出
        window.setGravity(gravity);
        window.setLayout(layoutParams.width, layoutParams.height);
        window.setWindowAnimations(R.style.take_photo_anim);//设置弹出动画
        mDialog.show();
        final EditText etUserName = (EditText) mDialog.findViewById(R.id.et_userName);
        EditText etMobile = (EditText) mDialog.findViewById(R.id.et_mobile);
        EditText etWechat = (EditText) mDialog.findViewById(R.id.et_wechat);
        EditText etCompany = (EditText) mDialog.findViewById(R.id.et_company);
        mDialog.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("activesId", bean.getId());
                formData.put("userName", etUserName.getText().toString().trim());
                formData.put("mobile", etUserName.getText().toString().trim());
                formData.put("wechat", etUserName.getText().toString().trim());
                formData.put("company", etUserName.getText().toString().trim());
                presenter.platformActivesJoin(formData);
            }
        });
        mDialog.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
    }
    @OnClick(R.id.iv_like)
    void onClick(){
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("articleId",bean.getId());
        formData.put("type","6");
        formData.put("status", bean.getStatus()==0?"1":"0");
        presenter.addUserPraise(formData);
    }

    @Override
    public PlatformParticularsPresenter initPresenter() {

        return new PlatformParticularsPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {
        T.showLong(PlatformParticularsActivity.this, errorString);
    }

    @Override
    public void setPlatformParticularsData(PlatformBean data) {
        tvPlatformTitle.setText(data.getTitle());
        tvActivesAddress.setText(data.getAddress());
        tvActivesTime.setText(data.getStartingTime() + "至" + data.getEndTime());
        tvAddress.setText(data.getAddress());
        tvDeadline.setText(data.getDeadline());
        tvCostMoney.setText("￥" + data.getCostMoney() + "/人");
        tvDescription.setText(data.getDeadline());
        wvContent.loadData(data.getContent(), "text/html; charset=UTF-8", null);
        if (data.getJoinStatus()==0){
            tvAddRegister.setBackgroundResource(R.color.color_10);
            tvAddRegister.setText("立即报名");
        }else {
            tvAddRegister.setBackgroundResource(R.color.aam_item_border);
            tvAddRegister.setText("已报名");
        }
        joinUsersNumber=data.getJoinUsersNumber();
        tvJoinUsersNumber.setText("已报名 （" + data.getJoinUsersNumber() + "）");
        if (null != data.getActivesImage()) {
            Picasso.with(PlatformParticularsActivity.this).load(HttpUtils.IMAGE_RUL + data.getActivesImage())
                    .into(ivPlatform);
        }
        if (data.getStatus() == 1) {
            ivLike.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
        } else {
            ivLike.setImageResource(R.mipmap.img_like_btn_no);
        }
        adapter=new PlatformRegisteredAdapter(data.getJoinUsers(),PlatformParticularsActivity.this);
        gvUser.setAdapter(adapter);
        data.setId(bean.getId());
        bean=data;
    }

    @Override
    public void platformActivesJoinSucceed(String data) {
        T.showLong(PlatformParticularsActivity.this, data);
        mDialog.dismiss();
    }

    @Override
    public void userPraise(String data) {
        if (bean.getStatus() == 0) {
            ivLike.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
            T.showLong(PlatformParticularsActivity.this,"点赞成功！");
            bean.setStatus(1);
        } else {
            ivLike.setImageResource(R.mipmap.img_like_btn_no);
            T.showLong(PlatformParticularsActivity.this,"取消点赞！");
            bean.setStatus(0);
        }
    }

    @OnClick({R.id.lt_main_title_left, R.id.tv_more, R.id.iv_comment_btn,R.id.iv_like, R.id.tv_add_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                PlatformParticularsActivity.this.finish();
                break;
            case R.id.tv_more:
                Intent intent = new Intent(PlatformParticularsActivity.this, PlatformRegisteredActivity.class);
                bean.setJoinUsersNumber(joinUsersNumber);
                intent.putExtra("bean", bean);
                startActivity(intent);
                break;
            case R.id.iv_comment_btn:
                Intent feedIntent = new Intent(PlatformParticularsActivity.this, FeedForCommentActivity.class);
                feedIntent.putExtra("bean", bean);
                startActivity(feedIntent);
                break;
            case R.id.iv_like:

                break;
            case R.id.tv_add_register:
                if (joinUsersNumber==0) {
                    TakePhotoPopWin();
                }else {
                    T.showLong(PlatformParticularsActivity.this, "亲，你已经报过名了！");
                }
                break;
        }
    }


}
