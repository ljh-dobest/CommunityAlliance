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

public class PlatformlActivityLVAdapter$ViewHolder_ViewBinding<T extends PlatformlActivityLVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public PlatformlActivityLVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_fa_lv_item_image = Utils.findRequiredViewAsType(source, R.id.iv_fa_lv_item_image, "field 'iv_fa_lv_item_image'", ImageView.class);
    target.tv_fa_item_status = Utils.findRequiredViewAsType(source, R.id.tv_fa_item_status, "field 'tv_fa_item_status'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_fa_lv_item_image = null;
    target.tv_fa_item_status = null;

    this.target = null;
  }
}
