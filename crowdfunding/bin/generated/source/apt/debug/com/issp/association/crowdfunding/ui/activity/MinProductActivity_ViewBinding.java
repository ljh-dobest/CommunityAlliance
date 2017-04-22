// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MinProductActivity_ViewBinding implements Unbinder {
  private MinProductActivity target;

  private View view2131624137;

  private View view2131624139;

  private View view2131624140;

  @UiThread
  public MinProductActivity_ViewBinding(MinProductActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MinProductActivity_ViewBinding(final MinProductActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'lt_main_title_left' and method 'backClick'");
    target.lt_main_title_left = Utils.castView(view, R.id.lt_main_title_left, "field 'lt_main_title_left'", TextView.class);
    view2131624137 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.backClick();
      }
    });
    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.rg_relation, "field 'radioGroup'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.rb_connection, "field 'rb_connection' and method 'connectionClick'");
    target.rb_connection = Utils.castView(view, R.id.rb_connection, "field 'rb_connection'", RadioButton.class);
    view2131624139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.connectionClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_relation_map, "field 'rb_relation_map' and method 'relationMapClick'");
    target.rb_relation_map = Utils.castView(view, R.id.rb_relation_map, "field 'rb_relation_map'", RadioButton.class);
    view2131624140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.relationMapClick();
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view_test_rv, "field 'recyclerView'", RecyclerView.class);
    target.xRefreshView = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xRefreshView'", XRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MinProductActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lt_main_title_left = null;
    target.radioGroup = null;
    target.rb_connection = null;
    target.rb_relation_map = null;
    target.recyclerView = null;
    target.xRefreshView = null;

    view2131624137.setOnClickListener(null);
    view2131624137 = null;
    view2131624139.setOnClickListener(null);
    view2131624139 = null;
    view2131624140.setOnClickListener(null);
    view2131624140 = null;
  }
}
