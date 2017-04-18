// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class YiYuanGVAdapter$ViewHolder_ViewBinding<T extends YiYuanGVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public YiYuanGVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_yydb_item_icon = Utils.findRequiredViewAsType(source, R.id.iv_yydb_item_icon, "field 'iv_yydb_item_icon'", ImageView.class);
    target.tv_yydb_item_tag = Utils.findRequiredViewAsType(source, R.id.tv_yydb_item_tag, "field 'tv_yydb_item_tag'", TextView.class);
    target.tv_yydb_item_title = Utils.findRequiredViewAsType(source, R.id.tv_yydb_item_title, "field 'tv_yydb_item_title'", TextView.class);
    target.tv_yydb_item_proccess = Utils.findRequiredViewAsType(source, R.id.tv_yydb_item_proccess, "field 'tv_yydb_item_proccess'", TextView.class);
    target.btn_yydb_item = Utils.findRequiredViewAsType(source, R.id.btn_yydb_item, "field 'btn_yydb_item'", Button.class);
    target.pb_yydb_item = Utils.findRequiredViewAsType(source, R.id.pb_yydb_item, "field 'pb_yydb_item'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_yydb_item_icon = null;
    target.tv_yydb_item_tag = null;
    target.tv_yydb_item_title = null;
    target.tv_yydb_item_proccess = null;
    target.btn_yydb_item = null;
    target.pb_yydb_item = null;

    this.target = null;
  }
}
