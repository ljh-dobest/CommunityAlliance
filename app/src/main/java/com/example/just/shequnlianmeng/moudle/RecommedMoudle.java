package com.example.just.shequnlianmeng.moudle;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.RecommendCode;
import com.example.just.shequnlianmeng.listeners.OnRecommedFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/6.
 */

public class RecommedMoudle {
    public void recommed(String userId, String fullName, String mobile, String sex, List<String> hobby, List<String> address, List<String> relationship, String creditScore, String birthday, String homeplace, String finishSchool, String company, String fatherName, String motherName, String marriage, String spouseName, String spouseAge, String childrenName, String childrenSchool, final OnRecommedFinishListener listener) {
      if(userId.equals("")||fullName.equals("")||mobile.equals("")||sex.equals("")||hobby.size()==0||
              address.size()==0||relationship.size()==0||creditScore.equals("")){
          listener.showTextEmpty();
      }else {
          final Gson gson = new Gson();
          String hobbys = gson.toJson(hobby);
          String relationships = gson.toJson(relationship);
          String addressList = gson.toJson(address);
          HttpUtils.postRecommend("/friendsRecommend", userId, fullName, mobile, sex, hobbys, addressList, relationships, creditScore,
                  birthday, homeplace, finishSchool, company, fatherName, motherName, marriage,
                  spouseName, spouseAge, childrenName, childrenSchool, new StringCallback() {
                      @Override
                      public void onError(Call call, Exception e, int id) {
                          listener.showRecommedError(e.toString());
                      }

                      @Override
                      public void onResponse(String response, int id) {
                          Type type = new TypeToken<Code<RecommendCode>>() {
                          }.getType();
                          Code<RecommendCode> code = gson.fromJson(response, type);
                          switch (code.getCode()) {
                              case 200:
                                  RecommendCode recommendCode = code.getData();
                                  String recommendId = recommendCode.getRecommendId();
                                  listener.succeedToRecommed(recommendId);
                                  break;
                              case 0:
                                  listener.showRecommedError("推荐失败");
                                  break;
                              case 100:
                                  listener.showRecommedError("账户已存在");
                                  break;
                              case 300:
                                  listener.showRecommedError("账户已推荐");
                                  break;
                          }
                      }
                  });
      }
     }
    }
