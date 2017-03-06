package com.example.just.shequnlianmeng.network;

import com.example.just.shequnlianmeng.bean.Code;
import com.example.just.shequnlianmeng.bean.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Min on 2016/12/21.
 */

public class JsonParser {


    //解析登录用户信息
    public static Code<UserInfo> parserLoginBeanRespon(String json) {
        Code<UserInfo> code = new Code<>();
        UserInfo userInfo = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            int concode = jsonObject.getInt("code");
            code.setCode(concode);
            JSONObject userObject = jsonObject.getJSONObject("data");
            String userId = userObject.getString("userId");
            String nickname = userObject.getString("nickname");
            String userPortraitUrl = userObject.getString("userPortraitUrl");
            String token = "";
            try {
                token = userObject.getString("token");
            } catch (JSONException e) {
            }
            int sex = userObject.getInt("sex");
            String email = userObject.getString("email");
            String mobile = userObject.getString("mobile");
            String address = userObject.getString("address");
            String birthday = userObject.getString("birthday");
            String recommendUserId = userObject.getString("recommendUserId");
            int age = 0;
            try {
                age = userObject.getInt("age");
            } catch (JSONException e) {
            }
            userInfo = new UserInfo(userId, token, nickname, sex, mobile, address, birthday, age, email, userPortraitUrl,recommendUserId);
            code.setData(userInfo);
        } catch (JSONException e) {
            return code;
        }
        return code;
    }
    //解析注册信息
    public static Code<Object> parserRegisterRespon(String json) {
        Code<Object> code = new Code<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            int concode = jsonObject.getInt("code");
            code.setCode(concode);
        } catch (JSONException e) {
            return code;
        }
        return code;
    }

//    //解析查找到好友用户信息
//    public static Code<LoginBean> parserSearchFriendBeanRespon(String json) {
//        Code<LoginBean> code = new Code<>();
//        LoginBean loginBean = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            int concode = jsonObject.getInt("code");
//            code.setCode(concode);
//            JSONObject userObject = jsonObject.getJSONObject("data");
//            String userId = userObject.getString("userId");
//            String nickname = userObject.getString("nickname");
//            String userPortraitUrl = userObject.getString("userPortraitUrl");
//            loginBean = new LoginBean(userId, nickname, userPortraitUrl);
//            code.setMsg(loginBean);
//        } catch (JSONException e) {
//            return code;
//        }
//
//        return code;
//    }
//
//    //解析所有朋友数据
//    public static Code<List<AllAddFriends>> paserAddAllFriends(String json) {
//        Code<List<AllAddFriends>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<AllAddFriends> allAddFriendsList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject addFrendObject = arrays.getJSONObject(i);
//                String userId = addFrendObject.getString("userId");
//                String nickname = addFrendObject.getString("nickname");
//                String userPortraitUrl = addFrendObject.getString("userPortraitUrl");
//                String addFriendMessage = addFrendObject.getString("addFriendMessage");
//                String addtime = addFrendObject.getString("addtime");
//                String mobile = addFrendObject.getString("mobile");
//                String email = addFrendObject.getString("email");
//                int status = addFrendObject.getInt("status");
//                AllAddFriends allAddFriends = new AllAddFriends(userId, nickname, addFriendMessage, status, addtime, userPortraitUrl, mobile, email);
//                allAddFriendsList.add(allAddFriends);
//            }
//            code.setMsg(allAddFriendsList);
//        } catch (JSONException e) {
//            return code;
//        }
//
//        return code;
//    }
//
//    //解析用户
//    public static Code<List<UserId>> parserUseId(String json) {
//        Code<List<UserId>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<UserId> FriendsList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject addFrendObject = arrays.getJSONObject(i);
//                String userId = addFrendObject.getString("userId");
//                UserId userInfo = new UserId(userId);
//                FriendsList.add(userInfo);
//            }
//            code.setMsg(FriendsList);
//        } catch (JSONException e) {
//            return code;
//        }
//
//        return code;
//
//    }
//
//    //解析好友列表
//    public static Code<List<FriendInfo>> parserFriends(String json) {
//        Code<List<FriendInfo>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<FriendInfo> friendInfosList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject frendInfosObject = arrays.getJSONObject(i);
//                String userId = frendInfosObject.getString("userId");
//                String name = frendInfosObject.getString("name");
//                String userPortraitUrl = frendInfosObject.getString("userPortraitUrl");
//                String displayName = frendInfosObject.getString("displayName");
//                String mobile = frendInfosObject.getString("mobile");
//                String email = frendInfosObject.getString("email");
//                FriendInfo friendInfo = new FriendInfo(userId, name, displayName, userPortraitUrl, email, mobile);
//                friendInfosList.add(friendInfo);
//            }
//            code.setMsg(friendInfosList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析好友列表
//    public static Code<FriendInfo> parserConfirmFriends(String json) {
//        Code<FriendInfo> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONObject frendInfosObject = jsonObject.getJSONObject("data");
//            String userId = frendInfosObject.getString("userId");
//            String name = frendInfosObject.getString("name");
//            String userPortraitUrl = frendInfosObject.getString("userPortraitUrl");
//            String displayName = frendInfosObject.getString("displayName");
//            String mobile = frendInfosObject.getString("mobile");
//            String email = frendInfosObject.getString("email");
//            FriendInfo friendInfo = new FriendInfo(userId, name, displayName, userPortraitUrl, mobile, email);
//            code.setMsg(friendInfo);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //登录时解析用户所有群组
//    public static Code<List<Groups>> parserAllGroups(String json) {
//        Code<List<Groups>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<Groups> groupsList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject groupObject = arrays.getJSONObject(i);
//                String groupId = groupObject.getString("groupId");
//                String groupName = groupObject.getString("groupName");
//                String groupPortraitUrl = groupObject.getString("groupPortraitUrl");
//                String role = groupObject.getString("role");
//                Groups groups = new Groups(groupId, groupName, groupPortraitUrl, role);
//                groupsList.add(groups);
//            }
//            code.setMsg(groupsList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析新建群组信息
//    public static Code<GroupId> parserNewGroupId(String json) {
//        Code<GroupId> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONObject groupObject = jsonObject.getJSONObject("data");
//            String Id = groupObject.getString("groupId");
//            String avatar_image=groupObject.getString("avatar_image");
//            GroupId groupId = new GroupId(Id,avatar_image);
//            code.setMsg(groupId);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析群组人员信息
//    public static Code<List<GroupMember>> parserGroupMembers(String json) {
//        Code<List<GroupMember>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<GroupMember> groupMembersList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject groupMenberObject = arrays.getJSONObject(i);
//                String userId = groupMenberObject.getString("userId");
//                String userName = groupMenberObject.getString("userName");
//                String userPortraitUrl = groupMenberObject.getString("userPortraitUrl");
//                String role = groupMenberObject.getString("role");
//                String mobile = groupMenberObject.getString("mobile");
//                GroupMember groupMenber = new GroupMember(userId, userName, userPortraitUrl, mobile, role);
//                groupMembersList.add(groupMenber);
//            }
//            code.setMsg(groupMembersList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析群活动信息
//    public static Code<List<GroupFlexible>> parserGroupFlexible(String json) {
//        Code<List<GroupFlexible>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<GroupFlexible> groupFlexibleList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject groupFlexibleObject = arrays.getJSONObject(i);
//                String actives_id = groupFlexibleObject.getString("actives_id");
//                String actives_title = groupFlexibleObject.getString("actives_title");
//                String actives_image = groupFlexibleObject.getString("actives_image");
//                String actives_limit = groupFlexibleObject.getString("actives_limit");
//                String actives_start = groupFlexibleObject.getString("actives_start");
//                String actives_end = groupFlexibleObject.getString("actives_end");
//                String actives_address = groupFlexibleObject.getString("actives_address");
//                String actives_content = groupFlexibleObject.getString("actives_content");
//                GroupFlexible groupFlexible = new GroupFlexible(actives_id, actives_title, actives_image, actives_limit, actives_start, actives_end, actives_address, actives_content);
//                groupFlexibleList.add(groupFlexible);
//            }
//            code.setMsg(groupFlexibleList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析群组活动人员信息
//    public static Code<List<FlexibleMember>> parserFlexibleMember(String json) {
//        Code<List<FlexibleMember>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<FlexibleMember> flexibleMemberList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject FlexibleMemberObject = arrays.getJSONObject(i);
//                String tu_id = FlexibleMemberObject.getString("tu_id");
//                String nickname = FlexibleMemberObject.getString("nickname");
//                int sex = FlexibleMemberObject.getInt("sex");
//                String avatar_image = FlexibleMemberObject.getString("avatar_image");
//                FlexibleMember flexibleMember = new FlexibleMember(tu_id, nickname, sex, avatar_image);
//                flexibleMemberList.add(flexibleMember);
//            }
//            code.setMsg(flexibleMemberList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析修改个人信息返回数据
//    public static Code<Image> parserPersonData(String json) {
//        Code<Image> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONObject imgObject = jsonObject.getJSONObject("data");
//            String avatar_image = imgObject.getString("avatar_image");
//            Image image = new Image(avatar_image);
//            code.setMsg(image);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析群投票列表信息
//    public static Code<List<GroupVote>> parserGroupVoteList(String json) {
//        Code<List<GroupVote>> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONArray arrays = jsonObject.getJSONArray("data");
//            ArrayList<GroupVote> groupVoteList = new ArrayList<>();
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject groupVoteObject = arrays.getJSONObject(i);
//                String vote_id = groupVoteObject.getString("vote_id");
//                String vote_title = groupVoteObject.getString("vote_title");
//                String add_time = groupVoteObject.getString("add_time");
//                String end_time = groupVoteObject.getString("end_time");
//                int status = groupVoteObject.getInt("status");
//                GroupVote groupVote = new GroupVote(vote_id, vote_title, add_time, end_time, status);
//                groupVoteList.add(groupVote);
//            }
//            code.setMsg(groupVoteList);
//        } catch (JSONException e) {
//            return code;
//        }
//        return code;
//    }
//
//    //解析群投票详细信息
//    public static Code<GroupVote> parserGroupVoteDetail(String json) {
//        Code<GroupVote> code = null;
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            code = new Code<>();
//            int connCode = jsonObject.getInt("code");
//            code.setCode(connCode);
//            JSONObject groupVoteObject = jsonObject.getJSONObject("data");
//            HashMap<String, String> optionMap = new HashMap<>();
//            String vote_id = groupVoteObject.getString("vote_id");
//            String userId = groupVoteObject.getString("createUser");
//            String vote_title = groupVoteObject.getString("vote_title");
//            String add_time = groupVoteObject.getString("add_time");
//            String end_time = groupVoteObject.getString("end_time");
//            int mode = groupVoteObject.getInt("mode");
//            JSONArray arrays = groupVoteObject.getJSONArray("option");
//            for (int i = 0; i < arrays.length(); i++) {
//                JSONObject optionObject = arrays.getJSONObject(i);
//                String optionCode = optionObject.getString("id");
//                String optionContext = optionObject.getString("content");
//                optionMap.put(optionCode,optionContext);
//            }
////            JSONArray arrays2=groupVoteObject.getJSONArray("joinUsers");
////            for (int i = 0; i < arrays2.length(); i++) {
////                JSONObject optionObject = arrays.getJSONObject(i);
////                String optionCode = optionObject.getString("id");
////                String optionContext = optionObject.getString("content");
////                optionMap.put(optionCode,optionContext);
////            }
//            GroupVote groupVote = new GroupVote(mode, vote_id, vote_title, add_time, end_time, userId, optionMap);
//            code.setMsg(groupVote);
//        } catch (JSONException e) {
//
//            return code;
//        }
//        return code;
//    }
//
//    public static String parseGrammarResult(String json) {
//        StringBuffer ret = new StringBuffer();
//        try {
//            JSONTokener tokener = new JSONTokener(json);
//            JSONObject joResult = new JSONObject(tokener);
//
//            JSONArray words = joResult.getJSONArray("ws");
//            for (int i = 0; i < words.length(); i++) {
//                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
//                for (int j = 0; j < items.length(); j++) {
//                    JSONObject obj = items.getJSONObject(j);
//                    if (obj.getString("w").contains("nomatch")) {
//                        ret.append("没有匹配结果.");
//                        return ret.toString();
//                    }
//                    ret.append("【结果】" + obj.getString("w"));
//                    ret.append("【置信度】" + obj.getInt("sc"));
//                    ret.append("\n");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            ret.append("没有匹配结果.");
//        }
//        return ret.toString();
//    }
//
//    public static String parseLocalGrammarResult(String json) {
//        StringBuffer ret = new StringBuffer();
//        try {
//            JSONTokener tokener = new JSONTokener(json);
//            JSONObject joResult = new JSONObject(tokener);
//
//            JSONArray words = joResult.getJSONArray("ws");
//            for (int i = 0; i < words.length(); i++) {
//                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
//                for (int j = 0; j < items.length(); j++) {
//                    JSONObject obj = items.getJSONObject(j);
//                    if (obj.getString("w").contains("nomatch")) {
//                        ret.append("没有匹配结果.");
//                        return ret.toString();
//                    }
//                    ret.append("【结果】" + obj.getString("w"));
//                    ret.append("\n");
//                }
//            }
//            ret.append("【置信度】" + joResult.optInt("sc"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            ret.append("没有匹配结果.");
//        }
//        return ret.toString();
//    }
}
