package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.interfaces.IProductIDCardView;
import com.issp.association.crowdfunding.presenters.ProductIdCardPresenter;
import com.issp.association.crowdfunding.utils.AMUtils;
import com.issp.association.crowdfunding.utils.T;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by T-BayMax on 2017/4/22.
 */

public class ProductIDCardActivity extends BaseMvpActivity<IProductIDCardView, ProductIdCardPresenter> implements IProductIDCardView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_idcard)
    EditText etIdcard;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    private boolean isIDCard;
    private boolean isCheckId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_idcard);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ltMainTitleLeft.setText("返回");
        ltMainTitle.setText("身份验证");
        ltMainTitleRight.setCompoundDrawables(null, null, null, null);
        etIdcard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 15 || s.length() == 18) {
                    presenter.checkIdCardPresenter(s.toString());
                    isCheckId = true;
                }
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
    public void showError(String errorString) {
        if (isCheckId) {
            if (etIdcard.getText().length() == 18) {
                T.showLong(ProductIDCardActivity.this, errorString);
            }
            isIDCard = false;
        }else {
            T.showLong(ProductIDCardActivity.this, errorString);
        }
    }

    @Override
    public void productIDcardView(String data) {
        T.showLong(ProductIDCardActivity.this, data);
        Intent intent=new Intent(ProductIDCardActivity.this,AddCrowdFundingActivity.class);
        startActivity(intent);
    }

    @Override
    public void checkIdCardView(String data) {
        isIDCard = true;
    }

    @Override
    public ProductIdCardPresenter initPresenter() {
        return new ProductIdCardPresenter();
    }

    @OnClick({R.id.lt_main_title_left, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                ProductIDCardActivity.this.finish();
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }

    private void submit() {
        String userName = etUserName.getText().toString().trim();
        String idCard = etIdcard.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        if (!isIDCard) {
            T.showLong(ProductIDCardActivity.this, "身份证输出不正确");
            return;
        }
        if (!AMUtils.isMobile(mobile)) {
            T.showLong(ProductIDCardActivity.this, "手机号码不正确");
            return;
        }
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("userName", userName);
        formData.put("idcard", idCard);
        formData.put("mobile", mobile);
        presenter.addProductIdCard(formData);
        isCheckId=false;
    }
}
