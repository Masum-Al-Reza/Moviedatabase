package com.example.moviedatabase_project.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Userauthpreferences {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    public  Userauthpreferences(Context context){
        preferences=context.getSharedPreferences("file_for_user",Context.MODE_PRIVATE);
        editor=preferences.edit();

    }
    public void setloginstatus(boolean status){
        editor.putBoolean("login_status",status);
        editor.commit();


    }
    public  boolean getlognstatus(){
        return preferences.getBoolean("login_status",false);

    }
}
