// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131558767;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.homepage_lv = Utils.findRequiredViewAsType(source, R.id.homepage_lv, "field 'homepage_lv'", ListView.class);
    view = Utils.findRequiredView(source, R.id.homepage_iv_top, "field 'homepage_iv_top' and method 'toTopOnClick'");
    target.homepage_iv_top = Utils.castView(view, R.id.homepage_iv_top, "field 'homepage_iv_top'", ImageView.class);
    view2131558767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toTopOnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.homepage_lv = null;
    target.homepage_iv_top = null;

    view2131558767.setOnClickListener(null);
    view2131558767 = null;

    this.target = null;
  }
}
