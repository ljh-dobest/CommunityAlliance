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
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClaimInfoActivity_ViewBinding<T extends ClaimInfoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ClaimInfoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_claim_back = Utils.findRequiredViewAsType(source, R.id.tv_claim_back, "field 'tv_claim_back'", TextView.class);
    target.iv_claim_userHeader = Utils.findRequiredViewAsType(source, R.id.iv_claim_userHeader, "field 'iv_claim_userHeader'", RoundedImageView.class);
    target.tv_claiminfo_othername = Utils.findRequiredViewAsType(source, R.id.tv_claiminfo_othername, "field 'tv_claiminfo_othername'", TextView.class);
    target.et_claiminfo_username = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_username, "field 'et_claiminfo_username'", EditText.class);
    target.et_claiminfo_mobile = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_mobile, "field 'et_claiminfo_mobile'", EditText.class);
    target.rg_claimInfo_sex = Utils.findRequiredViewAsType(source, R.id.rg_claimInfo_sex, "field 'rg_claimInfo_sex'", RadioGroup.class);
    target.rg_claimInfo_like = Utils.findRequiredViewAsType(source, R.id.rg_claimInfo_like, "field 'rg_claimInfo_like'", RadioGroup.class);
    target.sp_claimInfo_province = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_province, "field 'sp_claimInfo_province'", Spinner.class);
    target.sp_claimInfo_citys = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_citys, "field 'sp_claimInfo_citys'", Spinner.class);
    target.sp_claimInfo_countys = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_countys, "field 'sp_claimInfo_countys'", Spinner.class);
    target.et_claiminfo_relationship = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_relationship, "field 'et_claiminfo_relationship'", EditText.class);
    target.et_claiminfo_creditScore = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_creditScore, "field 'et_claiminfo_creditScore'", EditText.class);
    target.et_claiminfo_birthday = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_birthday, "field 'et_claiminfo_birthday'", EditText.class);
    target.sp_claimInfo_jgprovince = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_jgprovince, "field 'sp_claimInfo_jgprovince'", Spinner.class);
    target.sp_claimInfo_jgcitys = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_jgcitys, "field 'sp_claimInfo_jgcitys'", Spinner.class);
    target.sp_claimInfo_jgcountys = Utils.findRequiredViewAsType(source, R.id.sp_claimInfo_jgcountys, "field 'sp_claimInfo_jgcountys'", Spinner.class);
    target.et_claiminfo_finishSchool = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_finishSchool, "field 'et_claiminfo_finishSchool'", EditText.class);
    target.et_claiminfo_company = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_company, "field 'et_claiminfo_company'", EditText.class);
    target.et_claiminfo_position = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_position, "field 'et_claiminfo_position'", EditText.class);
    target.et_claiminfo_email = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_email, "field 'et_claiminfo_email'", EditText.class);
    target.et_claiminfo_QQ = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_QQ, "field 'et_claiminfo_QQ'", EditText.class);
    target.et_claiminfo_wechat = Utils.findRequiredViewAsType(source, R.id.et_claiminfo_wechat, "field 'et_claiminfo_wechat'", EditText.class);
    target.btn_verifyclaim = Utils.findRequiredViewAsType(source, R.id.btn_verifyclaim, "field 'btn_verifyclaim'", Button.class);
    target.ll_claiminfo_birthday = Utils.findRequiredViewAsType(source, R.id.ll_claiminfo_birthday, "field 'll_claiminfo_birthday'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_claim_back = null;
    target.iv_claim_userHeader = null;
    target.tv_claiminfo_othername = null;
    target.et_claiminfo_username = null;
    target.et_claiminfo_mobile = null;
    target.rg_claimInfo_sex = null;
    target.rg_claimInfo_like = null;
    target.sp_claimInfo_province = null;
    target.sp_claimInfo_citys = null;
    target.sp_claimInfo_countys = null;
    target.et_claiminfo_relationship = null;
    target.et_claiminfo_creditScore = null;
    target.et_claiminfo_birthday = null;
    target.sp_claimInfo_jgprovince = null;
    target.sp_claimInfo_jgcitys = null;
    target.sp_claimInfo_jgcountys = null;
    target.et_claiminfo_finishSchool = null;
    target.et_claiminfo_company = null;
    target.et_claiminfo_position = null;
    target.et_claiminfo_email = null;
    target.et_claiminfo_QQ = null;
    target.et_claiminfo_wechat = null;
    target.btn_verifyclaim = null;
    target.ll_claiminfo_birthday = null;

    this.target = null;
  }
}
