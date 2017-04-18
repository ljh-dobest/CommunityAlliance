// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RelationMapActivity_ViewBinding<T extends RelationMapActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RelationMapActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.rg_relation, "field 'radioGroup'", RadioGroup.class);
    target.rb_connection = Utils.findRequiredViewAsType(source, R.id.rb_connection, "field 'rb_connection'", RadioButton.class);
    target.rb_relation_map = Utils.findRequiredViewAsType(source, R.id.rb_relation_map, "field 'rb_relation_map'", RadioButton.class);
    target.relation_vp = Utils.findRequiredViewAsType(source, R.id.relation_vp, "field 'relation_vp'", ViewPager.class);
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

    this.target = null;
  }
}
