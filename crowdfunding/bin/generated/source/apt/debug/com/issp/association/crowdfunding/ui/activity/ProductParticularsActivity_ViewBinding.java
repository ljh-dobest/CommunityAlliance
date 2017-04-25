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

  private View view2131624082;

  private View view2131624083;

  private View view2131624084;

  private View view2131624085;

  private View view2131624086;

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
    view2131624082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_check_indent, "field 'tvCheckIndent', method 'checkIndentClick', and method 'onViewClicked'");
    target.tvCheckIndent = Utils.castView(view, R.id.tv_check_indent, "field 'tvCheckIndent'", TextView.class);
    view2131624083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.checkIndentClick();
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_share_btn, "field 'ivShareBtn' and method 'onViewClicked'");
    target.ivShareBtn = Utils.castView(view, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    view2131624084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_like_btn, "field 'ivLikeBtn' and method 'onViewClicked'");
    target.ivLikeBtn = Utils.castView(view, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    view2131624085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_comment_btn, "field 'ivCommentBtn' and method 'onViewClicked'");
    target.ivCommentBtn = Utils.castView(view, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    view2131624086 = view;
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

    view2131624082.setOnClickListener(null);
    view2131624082 = null;
    view2131624083.setOnClickListener(null);
    view2131624083 = null;
    view2131624084.setOnClickListener(null);
    view2131624084 = null;
    view2131624085.setOnClickListener(null);
    view2131624085 = null;
    view2131624086.setOnClickListener(null);
    view2131624086 = null;
  }
}
