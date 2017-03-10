package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.adpater.BaseAdapters;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class YiYuanGVAdapter extends BaseAdapters {
    public YiYuanGVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.yiyuan_gv_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_yydb_item_icon)
        ImageView iv_yydb_item_icon;
        @BindView(R.id.tv_yydb_item_tag)
        TextView tv_yydb_item_tag;
        @BindView(R.id.tv_yydb_item_title)
        TextView tv_yydb_item_title;
        @BindView(R.id.tv_yydb_item_proccess)
        TextView tv_yydb_item_proccess;
        @BindView(R.id.btn_yydb_item)
        Button btn_yydb_item;
        @BindView(R.id.pb_yydb_item)
        ProgressBar pb_yydb_item;
    }

}
