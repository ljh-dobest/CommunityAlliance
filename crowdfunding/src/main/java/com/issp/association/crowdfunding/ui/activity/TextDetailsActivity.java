package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.utils.T;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 文字详情
 * Created by T-BayMax on 2017/4/22.
 */

public class TextDetailsActivity extends AutoLayoutActivity {
    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_comment)
    EditText etComment;

    private int REQUEST_CODE = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ltMainTitleLeft.setText("取消");
        ltMainTitle.setText("文字详情");
        ltMainTitleRight.setText("保存");
        ltMainTitleLeft.setCompoundDrawables(null, null, null, null);
        ltMainTitleRight.setCompoundDrawables(null, null, null, null);
    }

    @OnClick({R.id.lt_main_title_left, R.id.lt_main_title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                TextDetailsActivity.this.finish();
                break;
            case R.id.lt_main_title_right:
                if(etComment.getText().toString().trim().equals("")){

                    T.showLong(TextDetailsActivity.this,"请输入文字详情");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("comment", etComment.getText().toString().trim());
                setResult(REQUEST_CODE, intent);
                TextDetailsActivity.this.finish();
                break;
        }
    }

}
