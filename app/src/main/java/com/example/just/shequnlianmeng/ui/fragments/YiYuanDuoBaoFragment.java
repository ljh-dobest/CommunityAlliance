package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.YiYuanGVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class YiYuanDuoBaoFragment extends Fragment{
    @BindView(R.id.yydb_gv)
    GridView yydb_gv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View containerView=inflater.inflate(R.layout.yiyuan_fragment,container,false);
        ButterKnife.bind(this,containerView);
        init();
        return  containerView;
    }

    private void init() {
        ArrayList<String> data=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
               data.add(i+"");
        }
        yydb_gv.setAdapter(new YiYuanGVAdapter(getContext(),data));
    }
}
