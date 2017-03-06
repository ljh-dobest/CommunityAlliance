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
import com.example.just.shequnlianmeng.adapter.PlatformlActivityLVAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class PlatformActivityFragment extends Fragment{
    @BindView(R.id.pa_lv)
    ListView pa_lv;
    RelativeLayout pa_lv_header;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View containerView=inflater.inflate(R.layout.platformactivity_fragment,container,false);
        ButterKnife.bind(this,containerView);
        pa_lv_header= (RelativeLayout) inflater.inflate(R.layout.platformactivity_lv_header,null);

        init();
        return  containerView;
    }

    private void init() {
        ArrayList<String> data =new ArrayList<>();
        data.add("1");
        data.add("1");
        data.add("1");
        pa_lv.addHeaderView(pa_lv_header);
        pa_lv.setAdapter(new PlatformlActivityLVAdapter(getContext(),data));
    }
}
