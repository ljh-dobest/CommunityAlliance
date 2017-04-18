// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlatformActivityFragment_ViewBinding<T extends PlatformActivityFragment> implements Unbinder {
  protected T target;

  @UiThread
  public PlatformActivityFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.pa_lv = Utils.findRequiredViewAsType(source, R.id.pa_lv, "field 'pa_lv'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.pa_lv = null;

    this.target = null;
  }
}
