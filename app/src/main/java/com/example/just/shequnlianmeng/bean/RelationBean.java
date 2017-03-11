package com.example.just.shequnlianmeng.bean;

import com.example.just.shequnlianmeng.utils.L;

import java.io.Serializable;
import java.util.List;

/**
 * 关系表
 * Created by T-BayMax on 2017/3/10.
 */

public class RelationBean implements Serializable {
    private List<UserInfo> recommender;     //该用户推荐人列表
    private UserInfo beRecommender;         //其他用户推荐该用户
    private List<UserInfo> claimUser;       //该用户认领用户列表
    private UserInfo wasClaimed;            //其他用户认领该用户

    public List<UserInfo> getRecommender() {
        return recommender;
    }

    public void setRecommender(List<UserInfo> recommender) {
        this.recommender = recommender;
    }

    public UserInfo getBeRecommender() {
        return beRecommender;
    }

    public void setBeRecommender(UserInfo beRecommender) {
        this.beRecommender = beRecommender;
    }

    public List<UserInfo> getClaimUser() {
        return claimUser;
    }

    public void setClaimUser(List<UserInfo> claimUser) {
        this.claimUser = claimUser;
    }

    public UserInfo getWasClaimed() {
        return wasClaimed;
    }

    public void setWasClaimed(UserInfo wasClaimed) {
        this.wasClaimed = wasClaimed;
    }
}
