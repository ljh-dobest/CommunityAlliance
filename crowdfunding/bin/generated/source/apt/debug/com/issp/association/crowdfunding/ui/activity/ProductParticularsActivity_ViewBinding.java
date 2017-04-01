// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductParticularsActivity_ViewBinding implements Unbinder {
  private ProductParticularsActivity target;

  @UiThread
  public ProductParticularsActivity_ViewBinding(ProductParticularsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductParticularsActivity_ViewBinding(ProductParticularsActivity target, View source) {
    this.target = target;

    target.tvReleaseTime = Utils.findRequiredViewAsType(source, R.id.tv_release_time, "field 'tvReleaseTime'", TextView.class);
    target.tvInform = Utils.findRequiredViewAsType(source, R.id.tv_inform, "field 'tvInform'", TextView.class);
    target.tvComment = Utils.findRequiredViewAsType(source, R.id.tv_comment, "field 'tvComment'", TextView.class);
    target.tvBackLeft = Utils.findRequiredViewAsType(source, R.id.tv_back_left, "field 'tvBackLeft'", TextView.class);
    target.tvCheckIndent = Utils.findRequiredViewAsType(source, R.id.tv_check_indent, "field 'tvCheckIndent'", TextView.class);
    target.ivShareBtn = Utils.findRequiredViewAsType(source, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    target.ivLikeBtn = Utils.findRequiredViewAsType(source, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    target.ivCommentBtn = Utils.findRequiredViewAsType(source, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    target.relativeLayout = Utils.findRequiredViewAsType(source, R.id.relativeLayout, "field 'relativeLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductParticularsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvReleaseTime = null;
    target.tvInform = null;
    target.tvComment = null;
    target.tvBackLeft = null;
    target.tvCheckIndent = null;
    target.ivShareBtn = null;
    target.ivLikeBtn = null;
    target.ivCommentBtn = null;
    target.relativeLayout = null;
  }
}
