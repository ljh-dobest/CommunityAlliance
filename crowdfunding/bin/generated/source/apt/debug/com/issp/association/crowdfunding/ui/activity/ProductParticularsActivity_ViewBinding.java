// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductParticularsActivity_ViewBinding implements Unbinder {
  private ProductParticularsActivity target;

  private View view2131624088;

  private View view2131624089;

  private View view2131624090;

  private View view2131624091;

  private View view2131624092;

  @UiThread
  public ProductParticularsActivity_ViewBinding(ProductParticularsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductParticularsActivity_ViewBinding(final ProductParticularsActivity target,
      View source) {
    this.target = target;

    View view;
    target.tvReleaseTime = Utils.findRequiredViewAsType(source, R.id.tv_release_time, "field 'tvReleaseTime'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvInform = Utils.findRequiredViewAsType(source, R.id.tv_inform, "field 'tvInform'", TextView.class);
    target.wvContent = Utils.findRequiredViewAsType(source, R.id.wv_comment, "field 'wvContent'", WebView.class);
    view = Utils.findRequiredView(source, R.id.tv_back_left, "field 'tvBackLeft' and method 'leftClick'");
    target.tvBackLeft = Utils.castView(view, R.id.tv_back_left, "field 'tvBackLeft'", TextView.class);
    view2131624088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_check_indent, "field 'tvCheckIndent', method 'checkIndentClick', and method 'onViewClicked'");
    target.tvCheckIndent = Utils.castView(view, R.id.tv_check_indent, "field 'tvCheckIndent'", TextView.class);
    view2131624089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.checkIndentClick();
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_share_btn, "field 'ivShareBtn' and method 'onViewClicked'");
    target.ivShareBtn = Utils.castView(view, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    view2131624090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_like_btn, "field 'ivLikeBtn' and method 'onViewClicked'");
    target.ivLikeBtn = Utils.castView(view, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    view2131624091 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_comment_btn, "field 'ivCommentBtn' and method 'onViewClicked'");
    target.ivCommentBtn = Utils.castView(view, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    view2131624092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.relativeLayout = Utils.findRequiredViewAsType(source, R.id.relativeLayout, "field 'relativeLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductParticularsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvReleaseTime = null;
    target.tvTitle = null;
    target.tvInform = null;
    target.wvContent = null;
    target.tvBackLeft = null;
    target.tvCheckIndent = null;
    target.ivShareBtn = null;
    target.ivLikeBtn = null;
    target.ivCommentBtn = null;
    target.relativeLayout = null;

    view2131624088.setOnClickListener(null);
    view2131624088 = null;
    view2131624089.setOnClickListener(null);
    view2131624089 = null;
    view2131624090.setOnClickListener(null);
    view2131624090 = null;
    view2131624091.setOnClickListener(null);
    view2131624091 = null;
    view2131624092.setOnClickListener(null);
    view2131624092 = null;
  }
}
