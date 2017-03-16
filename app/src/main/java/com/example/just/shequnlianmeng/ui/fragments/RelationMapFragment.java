package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpFragment;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.interfaces.IRelationMapView;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.presenters.RelationMapPresenter;
import com.example.just.shequnlianmeng.utils.CircleTransform;
import com.example.just.shequnlianmeng.utils.T;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/14.
 */

public class RelationMapFragment extends BaseMvpFragment<IRelationMapView, RelationMapPresenter> implements IRelationMapView  {
    @BindView(R.id.iv_recommender)
    ImageView iv_recommender;
    @BindView(R.id.iv_mine)
    ImageView iv_mine;
    @BindView(R.id.iv_was_claimed)
    ImageView iv_was_claimed;
    @BindView(R.id.tv_mender)
    TextView tv_mender;
    @BindView(R.id.tv_claim)
    TextView tv_claim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View containerView = inflater.inflate(R.layout.fragment_relation_map, container, false);
        ButterKnife.bind(this,containerView);
        initDate();
        return containerView;
    }
    private void initDate(){

        Map<String, String> formData=new HashMap<String, String>(0);
        formData.put("userId","111");
        presenter.postRelationMapData(formData);
    }

    @Override
    public boolean checkInputInfo() {
        return false;
    }

    @Override
    public void onRelationSucceed(RelationBean relation) {
        Picasso.with(getActivity()).load(HttpUtils.IMAGE_RUL+relation.getBeRecommender().getUserPortraitUrl())
                .transform(new CircleTransform(relation.getBeRecommender().getNickname())).into(iv_recommender);
        Picasso.with(getActivity()).load(HttpUtils.IMAGE_RUL+relation.getWasClaimed().getUserPortraitUrl())
                .transform(new CircleTransform(relation.getWasClaimed().getNickname())).into(iv_was_claimed);
       /* tv_mender.setText();
        tv_claim*/
    }

    @Override
    public void onRelationFailed(String failed) {
        T.showShort(RelationMapFragment.this.getActivity(),failed);
    }

    @Override
    public RelationMapPresenter initPresenter() {
        return new RelationMapPresenter();
    }
}
