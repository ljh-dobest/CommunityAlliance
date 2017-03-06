package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseAdapters;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class PlatformlActivityLVAdapter extends BaseAdapters {
    public PlatformlActivityLVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.platformactivity_lv_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_fa_lv_item_image)
        ImageView iv_fa_lv_item_image;
        @BindView(R.id.tv_fa_item_status)
        TextView tv_fa_item_status;
    }

}
