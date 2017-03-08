package com.example.just.shequnlianmeng.interfaces;

import java.util.List;

/**
 * Created by just on 2017/3/5.
 */

public interface IRecommedPresenter {
    void verifyRecommedInfo(String userId, String fullName, String mobile, String sex, List<String> hobby,
                            List<String> address,List<String> relationship,String creditScore,String birthday,
                            String homeplace,String finishSchool,String company,String fatherName,
                            String motherName,String marriage,String spouseName,String spouseAge,
                            String childrenName,String childrenSchool);
    void onDestroy();
}
