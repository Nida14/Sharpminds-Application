package com.roboticsworld.sharpminds.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;


public class shared_pref {

    Context context;

    public shared_pref(Context context) {
        this.context = context;
    }

    public void savelogin_details(String email, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("password", password);
        editor.commit();
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }

    public Boolean isUserLoginOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "").isEmpty() || sharedPreferences.getString("password", "").isEmpty();
    }

    public void getLogOut()
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}