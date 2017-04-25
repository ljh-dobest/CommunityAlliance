// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TextDetailsActivity_ViewBinding implements Unbinder {
  private TextDetailsActivity target;

  private View view2131624139;

  private View view2131624275;

  @UiThread
  public TextDetailsActivity_ViewBinding(TextDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TextDetailsActivity_ViewBinding(final TextDetailsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lt_main_title_right, "field 'ltMainTitleRight' and method 'onViewClicked'");
    target.ltMainTitleRight = Utils.castView(view, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view2131624275 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etComment = Utils.findRequiredViewAsType(source, R.id.et_comment, "field 'etComment'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TextDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.etComment = null;

    view2131624139.setOnClickListener(null);
    view2131624139 = null;
    view2131624275.setOnClickListener(null);
    view2131624275 = null;
  }
}
