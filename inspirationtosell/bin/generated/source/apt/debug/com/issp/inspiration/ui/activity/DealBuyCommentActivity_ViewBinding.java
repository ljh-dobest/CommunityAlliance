// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.issp.inspiration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DealBuyCommentActivity_ViewBinding implements Unbinder {
  private DealBuyCommentActivity target;

  private View view2131624196;

  private View view2131624092;

  private View view2131624093;

  @UiThread
  public DealBuyCommentActivity_ViewBinding(DealBuyCommentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DealBuyCommentActivity_ViewBinding(final DealBuyCommentActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624196 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view = Utils.findRequiredView(source, R.id.editText, "field 'editText' and method 'commentClick'");
    target.editText = Utils.castView(view, R.id.editText, "field 'editText'", EditText.class);
    view2131624092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commentClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_submit_comment, "field 'tvSubmitComment' and method 'submitCommentClick'");
    target.tvSubmitComment = Utils.castView(view, R.id.tv_submit_comment, "field 'tvSubmitComment'", TextView.class);
    view2131624093 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submitCommentClick();
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view_test_rv, "field 'recyclerView'", RecyclerView.class);
    target.xRefreshView = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xRefreshView'", XRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DealBuyCommentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.editText = null;
    target.tvSubmitComment = null;
    target.recyclerView = null;
    target.xRefreshView = null;

    view2131624196.setOnClickListener(null);
    view2131624196 = null;
    view2131624092.setOnClickListener(null);
    view2131624092 = null;
    view2131624093.setOnClickListener(null);
    view2131624093 = null;
  }
}
