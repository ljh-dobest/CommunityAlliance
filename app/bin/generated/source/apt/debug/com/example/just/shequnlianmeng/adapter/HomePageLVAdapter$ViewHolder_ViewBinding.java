// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.views.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomePageLVAdapter$ViewHolder_ViewBinding<T extends HomePageLVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HomePageLVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_home_item_userIcon = Utils.findRequiredViewAsType(source, R.id.iv_home_item_userIcon, "field 'iv_home_item_userIcon'", CircleImageView.class);
    target.tv_home_item_name = Utils.findRequiredViewAsType(source, R.id.tv_home_item_name, "field 'tv_home_item_name'", TextView.class);
    target.tv_home_item_userNum = Utils.findRequiredViewAsType(source, R.id.tv_home_item_userNum, "field 'tv_home_item_userNum'", TextView.class);
    target.tv_home_item_recommender = Utils.findRequiredViewAsType(source, R.id.tv_home_item_recommender, "field 'tv_home_item_recommender'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_home_item_userIcon = null;
    target.tv_home_item_name = null;
    target.tv_home_item_userNum = null;
    target.tv_home_item_recommender = null;

    this.target = null;
  }
}
