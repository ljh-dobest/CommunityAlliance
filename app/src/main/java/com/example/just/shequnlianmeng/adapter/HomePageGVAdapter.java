package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseAdapters;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class HomePageGVAdapter extends BaseAdapters{
  
    public HomePageGVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_gridview_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder,convertView);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        ArrayList<String> data= (ArrayList<String>) dataSet;
        holder.iv_icon.setImageResource(R.mipmap.ic_launcher);
        holder.tv_item.setText(data.get(position));
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.homepage_gv_img)
          ImageView iv_icon;
        @BindView(R.id.homepage_gv_tv)
          TextView tv_item;
    }
}
