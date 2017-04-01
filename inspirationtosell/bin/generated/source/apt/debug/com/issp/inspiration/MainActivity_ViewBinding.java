// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131624195;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.lt_main_title_left = Utils.findRequiredViewAsType(source, R.id.lt_main_title_left, "field 'lt_main_title_left'", TextView.class);
    target.lt_main_title = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'lt_main_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lt_main_title_right, "field 'lt_main_title_right' and method 'initPopupWindow'");
    target.lt_main_title_right = Utils.castView(view, R.id.lt_main_title_right, "field 'lt_main_title_right'", TextView.class);
    view2131624195 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.initPopupWindow();
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view_test_rv, "field 'recyclerView'", RecyclerView.class);
    target.xRefreshView = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xRefreshView'", XRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lt_main_title_left = null;
    target.lt_main_title = null;
    target.lt_main_title_right = null;
    target.recyclerView = null;
    target.xRefreshView = null;

    view2131624195.setOnClickListener(null);
    view2131624195 = null;
  }
}