// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomePageItemGVAdapter$ViewHolder_ViewBinding<T extends HomePageItemGVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HomePageItemGVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.iv_home_gv_item1, "field 'iv_icon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_icon = null;

    this.target = null;
  }
}
