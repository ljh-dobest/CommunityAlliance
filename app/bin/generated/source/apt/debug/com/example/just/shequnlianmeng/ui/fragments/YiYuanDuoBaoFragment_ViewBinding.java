// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class YiYuanDuoBaoFragment_ViewBinding<T extends YiYuanDuoBaoFragment> implements Unbinder {
  protected T target;

  @UiThread
  public YiYuanDuoBaoFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.yydb_gv = Utils.findRequiredViewAsType(source, R.id.yydb_gv, "field 'yydb_gv'", GridView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.yydb_gv = null;

    this.target = null;
  }
}
