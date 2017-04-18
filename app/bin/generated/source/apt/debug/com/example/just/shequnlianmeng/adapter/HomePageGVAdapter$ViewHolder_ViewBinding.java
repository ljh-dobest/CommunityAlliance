// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomePageGVAdapter$ViewHolder_ViewBinding<T extends HomePageGVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HomePageGVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.homepage_gv_img, "field 'iv_icon'", ImageView.class);
    target.tv_item = Utils.findRequiredViewAsType(source, R.id.homepage_gv_tv, "field 'tv_item'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_icon = null;
    target.tv_item = null;

    this.target = null;
  }
}
