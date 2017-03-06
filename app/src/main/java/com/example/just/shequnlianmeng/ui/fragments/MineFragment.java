package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.R;

/**
 * Created by just on 2017/3/1.
 */

public class MineFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View containerView= inflater.inflate(R.layout.mine_fragment,container,false);
        return  containerView;
    }
}
