// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.suke.widget.SwitchButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VerifyRecommedInfoActivity_ViewBinding<T extends VerifyRecommedInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public VerifyRecommedInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.et_verifyInfo_username = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_username, "field 'et_verifyInfo_username'", EditText.class);
    target.et_verifyInfo_mobile = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_mobile, "field 'et_verifyInfo_mobile'", EditText.class);
    target.rg_verifyInfo_sex = Utils.findRequiredViewAsType(source, R.id.rg_verifyInfo_sex, "field 'rg_verifyInfo_sex'", RadioGroup.class);
    target.rg_verifyInfo_like = Utils.findRequiredViewAsType(source, R.id.rg_verifyInfo_like, "field 'rg_verifyInfo_like'", RadioGroup.class);
    target.sp_verifyInfo_province = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_province, "field 'sp_verifyInfo_province'", Spinner.class);
    target.sp_verifyInfo_citys = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_citys, "field 'sp_verifyInfo_citys'", Spinner.class);
    target.sp_verifyInfo_countys = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_countys, "field 'sp_verifyInfo_countys'", Spinner.class);
    target.et_verifyInfo_birthday = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_birthday, "field 'et_verifyInfo_birthday'", EditText.class);
    target.sp_verifyInfo_jgprovince = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_jgprovince, "field 'sp_verifyInfo_jgprovince'", Spinner.class);
    target.sp_verifyInfo_jgcitys = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_jgcitys, "field 'sp_verifyInfo_jgcitys'", Spinner.class);
    target.sp_verifyInfo_jgcountys = Utils.findRequiredViewAsType(source, R.id.sp_verifyInfo_jgcountys, "field 'sp_verifyInfo_jgcountys'", Spinner.class);
    target.et_verifyInfo_finishSchool = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_finishSchool, "field 'et_verifyInfo_finishSchool'", EditText.class);
    target.et_verifyInfo_degree = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_degree, "field 'et_verifyInfo_degree'", EditText.class);
    target.et_verifyInfo_company = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_company, "field 'et_verifyInfo_company'", EditText.class);
    target.et_verifyInfo_position = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_position, "field 'et_verifyInfo_position'", EditText.class);
    target.et_verifyInfo_email = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_email, "field 'et_verifyInfo_email'", EditText.class);
    target.et_verifyInfo_QQ = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_QQ, "field 'et_verifyInfo_QQ'", EditText.class);
    target.et_verifyInfo_wechat = Utils.findRequiredViewAsType(source, R.id.et_verifyInfo_wechat, "field 'et_verifyInfo_wechat'", EditText.class);
    target.btn_verifyRecommedInfo = Utils.findRequiredViewAsType(source, R.id.btn_verifyRecommedInfo, "field 'btn_verifyRecommedInfo'", Button.class);
    target.ll_verifyInfo_birthday = Utils.findRequiredViewAsType(source, R.id.ll_verifyInfo_birthday, "field 'll_verifyInfo_birthday'", LinearLayout.class);
    target.sw_verifyInfo_showname = Utils.findRequiredViewAsType(source, R.id.sw_verifyInfo_showname, "field 'sw_verifyInfo_showname'", SwitchButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.et_verifyInfo_username = null;
    target.et_verifyInfo_mobile = null;
    target.rg_verifyInfo_sex = null;
    target.rg_verifyInfo_like = null;
    target.sp_verifyInfo_province = null;
    target.sp_verifyInfo_citys = null;
    target.sp_verifyInfo_countys = null;
    target.et_verifyInfo_birthday = null;
    target.sp_verifyInfo_jgprovince = null;
    target.sp_verifyInfo_jgcitys = null;
    target.sp_verifyInfo_jgcountys = null;
    target.et_verifyInfo_finishSchool = null;
    target.et_verifyInfo_degree = null;
    target.et_verifyInfo_company = null;
    target.et_verifyInfo_position = null;
    target.et_verifyInfo_email = null;
    target.et_verifyInfo_QQ = null;
    target.et_verifyInfo_wechat = null;
    target.btn_verifyRecommedInfo = null;
    target.ll_verifyInfo_birthday = null;
    target.sw_verifyInfo_showname = null;

    this.target = null;
  }
}
