package com.example.just.shequnlianmeng.moudle;

import android.content.Context;

import com.example.just.shequnlianmeng.bean.CityBean;
import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.CountyBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.bean.RecommendCode;
import com.example.just.shequnlianmeng.listeners.OnRecommedFinishListener;
import com.example.just.shequnlianmeng.network.HttpUtils;
import com.example.just.shequnlianmeng.utils.AMUtils;
import com.example.just.shequnlianmeng.utils.DataUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Min on 2017/3/6.
 */

public class RecommedMoudle {
    public void recommed(String userId, String fullName, String mobile, String sex, List<String> hobby,
                         List<String> address, List<String> relationship,List<String> character, String creditScore,
                         String birthday, String homeplace, String finishSchool, String company,
                         String fatherName, String motherName, String marriage, String spouseName,
                          String childrenName, String childrenSchool, final OnRecommedFinishListener listener) {
      if(userId.equals("")||fullName.equals("")||mobile.equals("")||sex.equals("")||hobby.size()==0||
              address.size()==0||relationship.size()==0||creditScore.equals("")){
          listener.showTextEmpty();
          return;
      }else if(!AMUtils.isMobile(mobile)){
                 listener.showRecommedError("请输入正确的手机号码");
          return;
      }
          final Gson gson = new Gson();
          String hobbys = gson.toJson(hobby);
          String relationships = gson.toJson(relationship);
          String addressList = gson.toJson(address);
        String characterlist=gson.toJson(character);
          HttpUtils.postRecommend("/friendsRecommend", userId, fullName, mobile, sex, hobbys, addressList, relationships,characterlist, creditScore,
                  birthday, homeplace, finishSchool, company, fatherName, motherName, marriage,
                  spouseName, childrenName, childrenSchool, new StringCallback() {
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

    public void getParserData(final Context mComtext, final String fileName, final OnRecommedFinishListener listener){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String jsonData=DataUtils.getJson(mComtext,fileName);
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



    private HashMap<String,Object> getMap(ArrayList<ProvinceBean> result) {
        HashMap<String,Object> map=new HashMap<>();
        ArrayList<String> options1Items=new ArrayList<>();
        ArrayList<ArrayList<String>> options2Items=new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> options3Items=new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            options1Items.add(result.get(i).getName());
           ArrayList<String> options2Items_item=new ArrayList<>();
            ArrayList<ArrayList<String>> options3Items_item=new ArrayList<>();
            ArrayList<CityBean> citys= (ArrayList<CityBean>) result.get(i).getSub();
            if(citys==null){
                options2Items_item.add("");
                continue;
            }else {
                for (int j = 0; j < citys.size(); j++) {
                    options2Items_item.add(citys.get(j).getName());
                    ArrayList<String> options3Items_item_item = new ArrayList<>();
                    ArrayList<CountyBean> countys = (ArrayList<CountyBean>) citys.get(j).getSub();
                    if (countys == null) {
                        options3Items_item_item.add("");
                        continue;
                    } else {
                        for (int k = 0; k < countys.size(); k++) {
                            options3Items_item_item.add(countys.get(k).getName());
                        }
                    }
                    options3Items_item.add(options3Items_item_item);
                }
                options2Items.add(options2Items_item);
                options3Items.add(options3Items_item);
            }
        }
        options1Items.remove(0);
           map.put("options1Items",options1Items);
           map.put("options2Items",options2Items);
           map.put("options3Items",options3Items);
        return map;
    }
}
