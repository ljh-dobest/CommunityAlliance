// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MInPlatformActivity_ViewBinding implements Unbinder {
  private MInPlatformActivity target;

  private View view2131624090;

  @UiThread
  public MInPlatformActivity_ViewBinding(MInPlatformActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MInPlatformActivity_ViewBinding(final MInPlatformActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.recyclerViewTestRv = Utils.findRequiredViewAsType(source, R.id.recycler_view_test_rv, "field 'recyclerViewTestRv'", RecyclerView.class);
    target.xrefreshview = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xrefreshview'", XRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MInPlatformActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.recyclerViewTestRv = null;
    target.xrefreshview = null;

    view2131624090.setOnClickListener(null);
    view2131624090 = null;
  }
}
