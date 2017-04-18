// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommentListAdapter$CommentListAdapterViewHolder_ViewBinding implements Unbinder {
  private CommentListAdapter.CommentListAdapterViewHolder target;

  @UiThread
  public CommentListAdapter$CommentListAdapterViewHolder_ViewBinding(CommentListAdapter.CommentListAdapterViewHolder target,
      View source) {
    this.target = target;

    target.ivShareIcon = Utils.findRequiredViewAsType(source, R.id.iv_share_icon, "field 'ivShareIcon'", ImageView.class);
    target.tvShareUserName = Utils.findRequiredViewAsType(source, R.id.tv_share_user_Name, "field 'tvShareUserName'", TextView.class);
    target.tvOperation = Utils.findRequiredViewAsType(source, R.id.tv_operation, "field 'tvOperation'", TextView.class);
    target.tvShareTitle = Utils.findRequiredViewAsType(source, R.id.tv_share_title, "field 'tvShareTitle'", TextView.class);
    target.tvCommentTime = Utils.findRequiredViewAsType(source, R.id.tv_comment_time, "field 'tvCommentTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommentListAdapter.CommentListAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivShareIcon = null;
    target.tvShareUserName = null;
    target.tvOperation = null;
    target.tvShareTitle = null;
    target.tvCommentTime = null;
  }
}
