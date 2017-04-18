// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedForCommentListAdapter$AdapterViewHolder_ViewBinding implements Unbinder {
  private FeedForCommentListAdapter.AdapterViewHolder target;

  @UiThread
  public FeedForCommentListAdapter$AdapterViewHolder_ViewBinding(FeedForCommentListAdapter.AdapterViewHolder target,
      View source) {
    this.target = target;

    target.ivShareIcon = Utils.findRequiredViewAsType(source, R.id.iv_share_icon, "field 'ivShareIcon'", ImageView.class);
    target.tvShareUserName = Utils.findRequiredViewAsType(source, R.id.tv_share_user_Name, "field 'tvShareUserName'", TextView.class);
    target.tvLikeBtn = Utils.findRequiredViewAsType(source, R.id.tv_like_btn, "field 'tvLikeBtn'", TextView.class);
    target.ivLikeBtn = Utils.findRequiredViewAsType(source, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    target.tvContent = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tvContent'", TextView.class);
    target.tvShareCommentTime = Utils.findRequiredViewAsType(source, R.id.tv_share_comment_time, "field 'tvShareCommentTime'", TextView.class);
    target.llLike = Utils.findRequiredViewAsType(source, R.id.ll_like, "field 'llLike'", LinearLayout.class);
    target.rlItem = Utils.findRequiredViewAsType(source, R.id.rl_item, "field 'rlItem'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FeedForCommentListAdapter.AdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivShareIcon = null;
    target.tvShareUserName = null;
    target.tvLikeBtn = null;
    target.ivLikeBtn = null;
    target.tvContent = null;
    target.tvShareCommentTime = null;
    target.llLike = null;
    target.rlItem = null;
  }
}
