// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddApplicationActivity_ViewBinding<T extends AddApplicationActivity> implements Unbinder {
  protected T target;

  private View view2131558877;

  private View view2131558547;

  @UiThread
  public AddApplicationActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131558877 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view = Utils.findRequiredView(source, R.id.gv_application, "field 'gvApplication' and method 'itemClick'");
    target.gvApplication = Utils.castView(view, R.id.gv_application, "field 'gvApplication'", GridView.class);
    view2131558547 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.itemClick(p1, p2);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.gvApplication = null;

    view2131558877.setOnClickListener(null);
    view2131558877 = null;
    ((AdapterView<?>) view2131558547).setOnItemClickListener(null);
    view2131558547 = null;

    this.target = null;
  }
}
