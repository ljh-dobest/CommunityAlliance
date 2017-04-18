// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

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

public class RelationMapFragment_ViewBinding<T extends RelationMapFragment> implements Unbinder {
  protected T target;

  @UiThread
  public RelationMapFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_recommender = Utils.findRequiredViewAsType(source, R.id.iv_recommender, "field 'iv_recommender'", ImageView.class);
    target.iv_mine = Utils.findRequiredViewAsType(source, R.id.iv_mine, "field 'iv_mine'", ImageView.class);
    target.iv_was_claimed = Utils.findRequiredViewAsType(source, R.id.iv_was_claimed, "field 'iv_was_claimed'", ImageView.class);
    target.tv_mender = Utils.findRequiredViewAsType(source, R.id.tv_mender, "field 'tv_mender'", TextView.class);
    target.tv_claim = Utils.findRequiredViewAsType(source, R.id.tv_claim, "field 'tv_claim'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_recommender = null;
    target.iv_mine = null;
    target.iv_was_claimed = null;
    target.tv_mender = null;
    target.tv_claim = null;

    this.target = null;
  }
}
