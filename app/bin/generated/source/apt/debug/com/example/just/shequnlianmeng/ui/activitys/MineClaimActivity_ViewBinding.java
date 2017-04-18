// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineClaimActivity_ViewBinding<T extends MineClaimActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MineClaimActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_mineclaim_back = Utils.findRequiredViewAsType(source, R.id.iv_mineclaim_back, "field 'iv_mineclaim_back'", ImageView.class);
    target.rv_mineClaim = Utils.findRequiredViewAsType(source, R.id.rv_mineClaim, "field 'rv_mineClaim'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_mineclaim_back = null;
    target.rv_mineClaim = null;

    this.target = null;
  }
}
