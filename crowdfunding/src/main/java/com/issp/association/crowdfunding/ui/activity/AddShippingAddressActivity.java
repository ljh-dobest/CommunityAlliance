package com.issp.association.crowdfunding.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.interfaces.IAddShippingAddressListView;
import com.issp.association.crowdfunding.presenters.AddShippingAddressPresenter;
import com.issp.association.crowdfunding.utils.AMUtils;
import com.issp.association.crowdfunding.utils.T;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 新增收货地址
 * Created by T-BayMax on 2017/3/25.
 */

public class AddShippingAddressActivity extends BaseMvpActivity<IAddShippingAddressListView, AddShippingAddressPresenter> implements IAddShippingAddressListView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(R.id.et_user_address)
    EditText etUserAddress;
    @BindView(R.id.btn_address_submit)
    Button btnAddressSubmit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shipping_address);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public AddShippingAddressPresenter initPresenter() {
        return new AddShippingAddressPresenter();
    }

    private void initView() {
        ltMainTitle.setText(getString(R.string.str_add_shipping_address));

    }

    private void initData() {

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        AddShippingAddressActivity.this.finish();
    }

    @OnClick(R.id.btn_address_submit)
    void addressSubmit() {
        if (checkInputInfo()) {
            Map<String, String> fromData = new HashMap<String, String>();
            presenter.OrderDetailPresenter(fromData);
        }
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
            T.showShort(AddShippingAddressActivity.this, "姓名不能为空");
            return false;
        }
        if ("" == etUserPhone.getText().toString().trim()) {
            T.showShort(AddShippingAddressActivity.this, "电话号码不能为空");
            return false;
        }
        if ("" == etUserAddress.getText().toString().trim()) {
            T.showShort(AddShippingAddressActivity.this, "地址不能为空");
            return false;
        }
        if (!AMUtils.isMobile(etUserPhone.getText().toString().trim())) {
            T.showShort(AddShippingAddressActivity.this, "电话号码格式错误");
            return false;
        }
        return true;
    }

    @Override
    public void setShippingAddressData(String data) {

    }
}
