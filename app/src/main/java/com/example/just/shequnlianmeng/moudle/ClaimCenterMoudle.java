package com.example.just.shequnlianmeng.moudle;

import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;
import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.listeners.OnClaimPeopleFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimCenterMoudle {
 public void getClaimPeopleData(String userId, final OnClaimPeopleFinishListener listener){
             if(userId==null){
                 return;
             }
     HttpUtils.getClaimPeopleInfo("/allFriendsClaim", userId, new StringCallback() {
         @Override
         public void onError(Call call, Exception e, int id) {
               listener.showErrorString(e.toString());
         }

         @Override
         public void onResponse(String response, int id) {
             Gson gson=new Gson();
             Type type = new TypeToken<Code<List<ClaimPeopleBean>>>() {
             }.getType();
             Code<List<ClaimPeopleBean>> code = gson.fromJson(response,type);
             switch (code.getCode()) {
                 case 200:
                     List<ClaimPeopleBean> claimPeoples=code.getData();
                     listener.succeedToGetClaimPeople(claimPeoples);
                     break;
                 case 0:
                     listener.failedToGetClaimPeople("没有注册的用户");
                     break;
             }

         }
     });
 }

}
