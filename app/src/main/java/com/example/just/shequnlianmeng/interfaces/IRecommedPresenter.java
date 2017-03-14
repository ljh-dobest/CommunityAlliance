package com.example.just.shequnlianmeng.interfaces;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by just on 2017/3/5.
 */

public interface IRecommedPresenter {
    void verifyRecommedInfo(String userId, String fullName, String mobile, String sex, List<String> hobby,
                            List<String> address,List<String> relationship,List<String> character,String creditScore,String birthday,
                            String homeplace,String finishSchool,String company,String fatherName,
                            String motherName,String marriage,String spouseName,
                            String childrenName,String childrenSchool);
   void getParserData(Context context,String fileName);
    void getHobby(ViewGroup group);
    void getCharacters(ViewGroup group);
}
