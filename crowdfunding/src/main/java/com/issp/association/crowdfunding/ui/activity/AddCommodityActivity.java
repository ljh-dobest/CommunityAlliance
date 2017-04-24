package com.issp.association.crowdfunding.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.issp.association.crowdfunding.utils.T;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 添加商品
 * Created by T-BayMax on 2017/4/22.
 */

public class AddCommodityActivity extends AutoLayoutActivity {
    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_commodity_title)
    EditText etCommodityTitle;
    @BindView(R.id.et_commodity_support_money)
    EditText etCommoditySupportMoney;
    @BindView(R.id.ll_commodity_content)
    LinearLayout llCommodityContent;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    private int REQUEST_CODE = 1;
    String comment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_commodity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.lt_main_title_left, R.id.ll_commodity_content, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                AddCommodityActivity.this.finish();
                break;
            case R.id.ll_commodity_content:
                Intent intent = new Intent(AddCommodityActivity.this, TextDetailsActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }

    private void submit() {
        if (etCommodityTitle.getText().toString().trim().equals("")) {
            T.showLong(AddCommodityActivity.this,"请输入商品标题");
            return;
        }if (etCommoditySupportMoney.getText().toString().trim().equals("")) {
            T.showLong(AddCommodityActivity.this,"请输入支持价格");
            return;
        }
        if (null!=comment){
            T.showLong(AddCommodityActivity.this,"请输入文字详情");
            return;
        }
        ProductRewardBean bean = new ProductRewardBean();
        bean.setRewardTitle(etCommodityTitle.getText().toString().trim());
        bean.setSupportMoney(Double.parseDouble(etCommoditySupportMoney.getText().toString().trim()));
        bean.setRewardContent(comment);
        Intent it = new Intent();
        it.putExtra("ProductReward", bean);
        setResult(REQUEST_CODE, it);
        AddCommodityActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REQUEST_CODE) {
            comment = data.getStringExtra("comment");
        }
    }
}
