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

public class UsefulActivityFragment_ViewBinding<T extends UsefulActivityFragment> implements Unbinder {
  protected T target;

  @UiThread
  public UsefulActivityFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.ua_lv = Utils.findRequiredViewAsType(source, R.id.ua_lv, "field 'ua_lv'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ua_lv = null;

    this.target = null;
  }
}
