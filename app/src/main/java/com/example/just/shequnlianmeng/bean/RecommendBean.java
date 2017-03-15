package com.example.just.shequnlianmeng.bean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/8.
 */

public class RecommendBean {
    private String userId;
    private String fullName;
    private String mobile;
    private String sex;
    private ArrayList<String> hobby;
    private ArrayList<String> address;
    private ArrayList<String> relationship;
    private ArrayList<String> character;
    private String creditScore;
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String company;
    private String fatherName;
    private String motherName;
    private String marriage;
    private String spouseName;
    private String childrenName;
    private String childrenSchool;

    public RecommendBean(String userId, String fullName, String mobile, String sex, ArrayList<String> hobby, ArrayList<String> address, ArrayList<String> relationship, ArrayList<String> character, String creditScore, String birthday, String homeplace, String finishSchool, String company, String fatherName, String motherName, String marriage, String spouseName, String childrenName, String childrenSchool) {
        this.userId = userId;
        this.fullName = fullName;
        this.mobile = mobile;
        this.sex = sex;
        this.hobby = hobby;
        this.address = address;
        this.relationship = relationship;
        this.character = character;
        this.creditScore = creditScore;
        this.birthday = birthday;
        this.homeplace = homeplace;
        this.finishSchool = finishSchool;
        this.company = company;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.marriage = marriage;
        this.spouseName = spouseName;
        this.childrenName = childrenName;
        this.childrenSchool = childrenSchool;
    }

    public ArrayList<String> getCharacter() {
        return character;
    }

    public void setCharacter(ArrayList<String> character) {
        this.character = character;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getHobby() {
        return hobby;
    }

    public void setHobby(ArrayList<String> hobby) {
        this.hobby = hobby;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public ArrayList<String> getRelationship() {
        return relationship;
    }

    public void setRelationship(ArrayList<String> relationship) {
        this.relationship = relationship;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }

    public String getFinishSchool() {
        return finishSchool;
    }

    public void setFinishSchool(String finishSchool) {
        this.finishSchool = finishSchool;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public String getChildrenSchool() {
        return childrenSchool;
    }

    public void setChildrenSchool(String childrenSchool) {
        this.childrenSchool = childrenSchool;
    }
}
