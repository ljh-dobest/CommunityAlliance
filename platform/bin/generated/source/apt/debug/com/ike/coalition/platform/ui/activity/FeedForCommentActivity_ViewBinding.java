// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.ui.activity;

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
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedForCommentActivity_ViewBinding implements Unbinder {
  private FeedForCommentActivity target;

  private View view2131624090;

  private View view2131624088;

  private View view2131624089;

  @UiThread
  public FeedForCommentActivity_ViewBinding(FeedForCommentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FeedForCommentActivity_ViewBinding(final FeedForCommentActivity target, View source) {
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
    view = Utils.findRequiredView(source, R.id.editText, "field 'editText' and method 'commentClick'");
    target.editText = Utils.castView(view, R.id.editText, "field 'editText'", EditText.class);
    view2131624088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commentClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_submit_comment, "field 'tvSubmitComment' and method 'submitCommentClick'");
    target.tvSubmitComment = Utils.castView(view, R.id.tv_submit_comment, "field 'tvSubmitComment'", TextView.class);
    view2131624089 = view;
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
    FeedForCommentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.editText = null;
    target.tvSubmitComment = null;
    target.recyclerView = null;
    target.xRefreshView = null;

    view2131624090.setOnClickListener(null);
    view2131624090 = null;
    view2131624088.setOnClickListener(null);
    view2131624088 = null;
    view2131624089.setOnClickListener(null);
    view2131624089 = null;
  }
}
