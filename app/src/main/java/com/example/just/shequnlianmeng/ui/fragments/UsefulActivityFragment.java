package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.UsefulActivityLVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class UsefulActivityFragment extends Fragment{
    @BindView(R.id.ua_lv)
    ListView ua_lv;
    RelativeLayout ua_lv_header;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View containerView=inflater.inflate(R.layout.usefulactivity_fragment,container,false);
        ButterKnife.bind(this,containerView);
        ua_lv_header= (RelativeLayout) inflater.inflate(R.layout.usefulactivity_lv_header,null);
        init();
        return  containerView;
    }

    private void init() {
        ArrayList<String> data =new ArrayList<>();
        data.add("1");
        data.add("1");
        data.add("1");
        ua_lv.addHeaderView(ua_lv_header);
        ua_lv.setAdapter(new UsefulActivityLVAdapter(getContext(),data));
    }
}
