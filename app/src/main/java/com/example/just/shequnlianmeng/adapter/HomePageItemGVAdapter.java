package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseAdapters;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class HomePageItemGVAdapter extends BaseAdapters{
   private int[] icons={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pci4,
           R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
    public HomePageItemGVAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_gv_item2, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder,convertView);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.iv_icon.setImageResource(icons[position]);
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.iv_home_gv_item1)
          ImageView iv_icon;
    }
}
