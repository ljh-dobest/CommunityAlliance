// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RelationMapActivity_ViewBinding<T extends RelationMapActivity> implements Unbinder {
  protected T target;

  private View view2131558659;

  @UiThread
  public RelationMapActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.rg_relation, "field 'radioGroup'", RadioGroup.class);
    target.rb_connection = Utils.findRequiredViewAsType(source, R.id.rb_connection, "field 'rb_connection'", RadioButton.class);
    target.rb_relation_map = Utils.findRequiredViewAsType(source, R.id.rb_relation_map, "field 'rb_relation_map'", RadioButton.class);
    target.relation_vp = Utils.findRequiredViewAsType(source, R.id.relation_vp, "field 'relation_vp'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.tv_back, "field 'tvBack' and method 'onViewClicked'");
    target.tvBack = Utils.castView(view, R.id.tv_back, "field 'tvBack'", TextView.class);
    view2131558659 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.radioGroup = null;
    target.rb_connection = null;
    target.rb_relation_map = null;
    target.relation_vp = null;
    target.tvBack = null;

    view2131558659.setOnClickListener(null);
    view2131558659 = null;

    this.target = null;
  }
}
