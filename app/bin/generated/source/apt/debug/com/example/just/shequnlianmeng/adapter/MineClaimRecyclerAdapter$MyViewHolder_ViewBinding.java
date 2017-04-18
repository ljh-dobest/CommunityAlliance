// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineClaimRecyclerAdapter$MyViewHolder_ViewBinding<T extends MineClaimRecyclerAdapter.MyViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public MineClaimRecyclerAdapter$MyViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_mineclaim_userHeader = Utils.findRequiredViewAsType(source, R.id.iv_mineclaim_userHeader, "field 'iv_mineclaim_userHeader'", RoundedImageView.class);
    target.tv_mineclaim_name = Utils.findRequiredViewAsType(source, R.id.tv_mineclaim_name, "field 'tv_mineclaim_name'", TextView.class);
    target.tv_mineClaim_time = Utils.findRequiredViewAsType(source, R.id.tv_mineClaim_time, "field 'tv_mineClaim_time'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_mineclaim_userHeader = null;
    target.tv_mineclaim_name = null;
    target.tv_mineClaim_time = null;

    this.target = null;
  }
}
