package com.issp.association.crowdfunding.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.issp.association.crowdfunding.bean.Code;
import com.issp.association.crowdfunding.listeners.OnAddProductCollectListener;
import com.issp.association.crowdfunding.listeners.OnProductIDCardListener;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by T-BayMax on 2017/4/21.
 */

public class ProductIDCardModel {
    public void productIDCard(Map<String, String> formData, final OnProductIDCardListener listener) {
        HttpUtils.sendGsonPostRequest("/productIdcardInfo", formData, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.showError(e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<Code>() {
                }.getType();
                Code code = gson.fromJson(response, type);
                switch (code.getCode()) {
                    case 200:
                        listener.productIDCard("身份验证成功");
                        break;
                    case 100:
                        listener.showError(code.getMsgs());
                        break;
                    case 0:
                        listener.showError("身份验证失败");
                        break;
                }
            }
        });
    }

    public void checkIdCard(String formData, final OnProductIDCardListener listener) {
        OkHttpUtils
                .get()
                .url("http://api.avatardata.cn/IdCard/LookUp?key=37ee212c6e114106ac69df217891395b&id="+formData)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.showError(e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<IdCard>() {
                        }.getType();
                        IdCard code = gson.fromJson(response, type);
                        switch (code.getError_code()) {
                            case 1:
                                listener.showError(code.getReason());
                                break;
                            case 0:
                                listener.checkIdCard("身份验证成功");
                                break;
                            default:
                                listener.showError(code.getReason());
                                break;
                        }
                    }
                });
    }
    private class IdCard{
       // private String result;
        private int error_code;
        private String reason;

       /* public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
*/
        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
