package com.issp.association.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.bean.Code;
import com.issp.association.bean.ShareBean;
import com.issp.association.listeners.OnShareListener;
import com.issp.association.network.HttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class ShareInfoModel {
    public void getShareInfo(String userId, final OnShareListener listener){
        if(userId==null){
            return;
        }
        HttpUtils.sendGsonPostRequest("/allRecommendsUsers", userId, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
              listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Type type = new TypeToken<Code<List<ShareBean>>>() {
                }.getType();
                Code<List<ShareBean>> code = gson.fromJson(response,type);
                switch (code.getCode()) {
                    case 200:
                        ArrayList<ShareBean> data= (ArrayList<ShareBean>) code.getData();
                        listener.getShareInfo(data);
                        break;
                    case 0:
                        listener.showError("查询失败");
                        break;
                }
            }
        });
    }
}
