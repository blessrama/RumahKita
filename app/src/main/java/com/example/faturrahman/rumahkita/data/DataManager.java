package com.example.faturrahman.rumahkita.data;

import android.util.Log;

import com.example.faturrahman.rumahkita.data.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private static final String USER_ID_KEY = "USER_ID_KEY";
    private static final String USER_NAME_KEY = "USER_NAME_KEY";
    private static final String USER_ADDRESS_KEY = "USER_ADDRESS_KEY";
    private static final String USER_PHONE_KEY = "USER_PHONE_KEY";
    private static final String USER_DESCRIPTION_KEY = "USER_DESCRIPTION_KEY";
    private static final String USER_EMAIL_KEY = "USER_EMAIL_KEY";
    private static final String USER_AVATAR_KEY = "USER_AVATAR_KEY";


    private final PreferencesHelper preferencesHelper;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper) { this.preferencesHelper = preferencesHelper; }

    //getter setter userID
    public void setUserId(String s) {
        preferencesHelper.get().edit().putString(USER_ID_KEY, s).apply();
    }

    public String getUserId(){ return preferencesHelper.get().getString(USER_ID_KEY, "");}


    //getter setter userName
    public void setUserName(String s) {
        preferencesHelper.get().edit().putString(USER_NAME_KEY, s).apply();
    }

    public String getUserName(){ return preferencesHelper.get().getString(USER_NAME_KEY, "");}

    //getter setter user Address
    public void setUserAddress(String s) {
        preferencesHelper.get().edit().putString(USER_ADDRESS_KEY, s).apply();
    }

    public String getUserAddress(){ return preferencesHelper.get().getString(USER_ADDRESS_KEY, "");}

    //getter setter user phone number
    public void setUserPhone(int s) {
        preferencesHelper.get().edit().putInt(USER_PHONE_KEY, s).apply();
    }

    public int getUserPhone(){ return preferencesHelper.get().getInt(USER_PHONE_KEY, 0);}

    //getter setter user Description
    public void setUserDescription(String s) {
        preferencesHelper.get().edit().putString(USER_DESCRIPTION_KEY, s).apply();
    }

    public String getUserDescription(){ return preferencesHelper.get().getString(USER_DESCRIPTION_KEY, "");}

    //getter setter user Email
    public void setUserEmail(String s) {
        preferencesHelper.get().edit().putString(USER_EMAIL_KEY, s).apply();
    }

    public String getUserEmail(){ return preferencesHelper.get().getString(USER_EMAIL_KEY, "");}

    //getter setter user Avatar URL
    public void setUserAvatar(String s) {
        preferencesHelper.get().edit().putString(USER_AVATAR_KEY, s).apply();
    }

    public String getUserAvatar(){ return preferencesHelper.get().getString(USER_AVATAR_KEY, "");}

    //getter setter user Avatar Order List
    public void setUserOrderList(List<String> stringList) {
        String s = toJSon(stringList);
        preferencesHelper.get().edit().putString(USER_AVATAR_KEY, s).apply();
    }

    public List<String> getUserOrderList(){
        String s = preferencesHelper.get().getString(USER_AVATAR_KEY, "");
        if(!s.equals("")){
            return toList(s);
        }
        else return null;
    }

    public void setUser(User user){
        try{
            setUserId(user.getId());
            setUserName(user.getName());
            setUserEmail(user.getEmail());
            if(user.getAddress() != null) setUserAddress(user.getAddress());
            if(user.getAvatarUrl() != null) setUserAvatar(user.getAvatarUrl());
            if(user.getDescription() != null) setUserDescription(user.getDescription());
            if(user.getPhone() != 0) setUserPhone(user.getPhone());
            if(user.getOrderId() != null) setUserOrderList(user.getOrderId());
        } catch (Exception e){
            Log.e("DataManager", e.getMessage());
        }

    }

    public void setUser(String userId, String userName, String email){
        setUserId(userId);
        setUserName(userName);
        setUserEmail(email);
    }

    private String toJSon(List<String> string) {
        Gson gson = new Gson();
        return gson.toJson(string);
    }

    private List<String> toList(String s){
        Gson gson = new Gson();
        return gson.fromJson(s, new TypeToken<List<String>>(){}.getType());
    }

}
