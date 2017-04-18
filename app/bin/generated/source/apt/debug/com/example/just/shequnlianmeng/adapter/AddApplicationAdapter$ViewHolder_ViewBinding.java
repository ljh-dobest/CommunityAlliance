// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.czp.library.ArcProgress;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddApplicationAdapter$ViewHolder_ViewBinding<T extends AddApplicationAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public AddApplicationAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivApplicationImg = Utils.findRequiredViewAsType(source, R.id.iv_application_img, "field 'ivApplicationImg'", ImageView.class);
    target.pbSchedule = Utils.findRequiredViewAsType(source, R.id.pb_schedule, "field 'pbSchedule'", ArcProgress.class);
    target.ivDownload = Utils.findRequiredViewAsType(source, R.id.iv_download, "field 'ivDownload'", ImageView.class);
    target.rlApplication = Utils.findRequiredViewAsType(source, R.id.rl_application, "field 'rlApplication'", RelativeLayout.class);
    target.tvApplicationTile = Utils.findRequiredViewAsType(source, R.id.tv_application_tile, "field 'tvApplicationTile'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivApplicationImg = null;
    target.pbSchedule = null;
    target.ivDownload = null;
    target.rlApplication = null;
    target.tvApplicationTile = null;

    this.target = null;
  }
}
