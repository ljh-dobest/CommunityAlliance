package com.example.just.shequnlianmeng.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpFragment;
import com.example.just.shequnlianmeng.bean.UserInfo;
import com.example.just.shequnlianmeng.interfaces.IMineFragmentView;
import com.example.just.shequnlianmeng.presenters.MineFragmentPresenter;
import com.example.just.shequnlianmeng.ui.activitys.RecommendActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by just on 2017/3/1.
 */

public class  MineFragment extends BaseMvpFragment<IMineFragmentView,MineFragmentPresenter> implements IMineFragmentView{
  @BindView(R.id.iv_mine_recommend)
    ImageView iv_mine_recommend;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
      View containerView= inflater.inflate(R.layout.mine_fragment,container,false);
        ButterKnife.bind(this,containerView);
        return  containerView;
    }


    @OnClick(R.id.iv_mine_recommend)
    public void mineFragemntViewOnClick(View view){
        switch (view.getId()) {
            case R.id.iv_mine_recommend:
                Intent intent=new Intent(getActivity(), RecommendActivity.class);
                startActivity(intent);
                break;
        }
    }





    @Override
    public MineFragmentPresenter initPresenter() {
        return new MineFragmentPresenter();
    }

    @Override
    public void setData(ArrayList<UserInfo> data) {

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
}
