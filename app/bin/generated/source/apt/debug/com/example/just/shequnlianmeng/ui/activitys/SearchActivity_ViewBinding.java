// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding<T extends SearchActivity> implements Unbinder {
  protected T target;

  private View view2131558667;

  @UiThread
  public SearchActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.rv_search = Utils.findRequiredViewAsType(source, R.id.rv_search, "field 'rv_search'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_search_clear, "field 'tv_search_clear' and method 'onViewClick'");
    target.tv_search_clear = Utils.castView(view, R.id.tv_search_clear, "field 'tv_search_clear'", TextView.class);
    view2131558667 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rv_search = null;
    target.tv_search_clear = null;

    view2131558667.setOnClickListener(null);
    view2131558667 = null;

    this.target = null;
  }
}
