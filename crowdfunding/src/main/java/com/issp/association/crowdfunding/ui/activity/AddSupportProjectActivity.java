package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.interfaces.IAddSupportProjectView;
import com.issp.association.crowdfunding.presenters.AddSupportProjectPresenter;
import com.issp.association.crowdfunding.utils.AMUtils;
import com.issp.association.crowdfunding.utils.T;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支持项目
 * Created by T-BayMax on 2017/3/25.
 */

public class AddSupportProjectActivity extends BaseMvpActivity<IAddSupportProjectView, AddSupportProjectPresenter> implements IAddSupportProjectView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.tv_project_title)
    TextView tvProjectTitle;
    @BindView(R.id.tv_project_confess)
    TextView tvProjectConfess;
    @BindView(R.id.iv_shipping_address)
    ImageView ivShippingAddress;
    @BindView(R.id.tv_shipping_address)
    TextView tvShippingAddress;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(R.id.iv_zhifubao)
    ImageView ivZhifubao;
    @BindView(R.id.iv_weixin)
    ImageView ivWeixin;
    @BindView(R.id.ll_add_address)
    LinearLayout llAddAddress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supported_project);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public AddSupportProjectPresenter initPresenter() {
        return new AddSupportProjectPresenter();
    }

    private void initView() {
        ltMainTitle.setText(getString(R.string.str_add_support_project));

    }

    private void initData() {

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        AddSupportProjectActivity.this.finish();
    }

    @OnClick(R.id.btn_address_submit)
    void addressSubmit() {
        if (checkInputInfo()) {
            Map<String, String> fromData = new HashMap<String, String>();
            presenter.ShareInfoPresenter(fromData);
        }
    }

    @OnClick(R.id.ll_add_address)
    void addAddress(){
        Intent intent=new Intent(AddSupportProjectActivity.this,AddShippingAddressActivity.class);
       startActivity(intent);
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
    public boolean checkInputInfo() {
        if ("" == etUserName.getText().toString().trim()) {
            T.showShort(AddSupportProjectActivity.this, "姓名不能为空");
            return false;
        }
        if ("" == etUserPhone.getText().toString().trim()) {
            T.showShort(AddSupportProjectActivity.this, "电话号码不能为空");
            return false;
        }
        if (!AMUtils.isMobile(etUserPhone.getText().toString().trim())) {
            T.showShort(AddSupportProjectActivity.this, "电话号码格式错误");
            return false;
        }
        return true;
    }

    @Override
    public void setAddSupportProjectData(String data) {

    }

}
