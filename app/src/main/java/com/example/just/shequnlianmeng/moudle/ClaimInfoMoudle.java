package com.example.just.shequnlianmeng.moudle;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.just.shequnlianmeng.bean.ClaimInfoBean;
import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.listeners.OnClaimFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.utils.AMUtils;
import com.example.just.shequnlianmeng.utils.CommonUtils;
import com.example.just.shequnlianmeng.utils.DataUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimInfoMoudle {
 public void postClaimInfo(ClaimInfoBean claimInfo, final OnClaimFinishListener listener){
       if (claimInfo.getFullName().equals("")||claimInfo.getMobile().equals("")||claimInfo.getSex().equals("")
           ||claimInfo.getHobby().size()==0||claimInfo.getAddress().size()==0||claimInfo.getRelationship().equals("")
           ||claimInfo.getCreditScore().equals("")){
       listener.showTextEmpty();
        return;
       }
  if(!AMUtils.isMobile(claimInfo.getMobile())) {
   listener.failedToClaim("请输入正确的手机号码");
   return;
  }
if(!CommonUtils.isEmail(claimInfo.getEmail())){
 listener.failedToClaim("请输入正确的邮箱");
 return;
}
  HttpUtils.postClaimInfo("/claimUser", claimInfo, new StringCallback() {
   @Override
   public void onError(Call call, Exception e, int id) {
    listener.failedToClaim(e.toString());
   }

   @Override
   public void onResponse(String response, int id) {
         Gson gson=new Gson();
    Type type = new TypeToken<Code<Object>>() {
    }.getType();
    Code<Object> code=gson.fromJson(response,type);
    switch (code.getCode()) {
     case 200:
      listener.succeedToClaim();
      break;
     case 0:
      listener.failedToClaim("认领失败");
      break;
     case 100:
      listener.failedToClaim("已认领");
      break;
     case 101:
      listener.failedToClaim("认领已回答");
      break;
    }
   }
  });
  }
 public void getParserData(final Context mComtext, final String fileName, final OnClaimFinishListener listener){
  new Thread(new Runnable() {
   @Override
   public void run() {
    String jsonData= DataUtils.getJson(mComtext,fileName);
    //解析数据
    Gson gson=new Gson();
    Type type = new TypeToken<ArrayList<ProvinceBean>>() {
    }.getType();
    ArrayList<ProvinceBean> result=gson.fromJson(jsonData,type);
    // HashMap<String,Object> map =getMap(result);
    listener.returnParserData(result);
   }
  }).start();
 }
 //获取选择的爱好
 public void getHobby(ViewGroup group,OnClaimFinishListener listener) {
  ArrayList<String> hobbys=new ArrayList<>();
  for (int i = 0; i < group.getChildCount(); i++) {
   LinearLayout ll= (LinearLayout) group.getChildAt(i);
   for (int j= 1; j < ll.getChildCount(); j++) { //j从第一个开始，跳过Textview
    RadioButton rb= (RadioButton) ll.getChildAt(j);
    if (rb.isChecked()){
     hobbys.add(rb.getText().toString());
    }
   }
  }
     listener.retturnHobbys(hobbys);
 }
}
