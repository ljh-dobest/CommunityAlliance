// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecommendInfoActivity_ViewBinding<T extends RecommendInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RecommendInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rv_recom_info = Utils.findRequiredViewAsType(source, R.id.rv_recom_info, "field 'rv_recom_info'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rv_recom_info = null;

    this.target = null;
  }
}
