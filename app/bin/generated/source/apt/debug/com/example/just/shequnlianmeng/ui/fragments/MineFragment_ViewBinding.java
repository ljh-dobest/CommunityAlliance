// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineFragment_ViewBinding<T extends MineFragment> implements Unbinder {
  protected T target;

  private View view2131558816;

  @UiThread
  public MineFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_mine_recommend, "field 'iv_mine_recommend' and method 'mineFragemntViewOnClick'");
    target.iv_mine_recommend = Utils.castView(view, R.id.iv_mine_recommend, "field 'iv_mine_recommend'", ImageView.class);
    view2131558816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.mineFragemntViewOnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_mine_recommend = null;

    view2131558816.setOnClickListener(null);
    view2131558816 = null;

    this.target = null;
  }
}
