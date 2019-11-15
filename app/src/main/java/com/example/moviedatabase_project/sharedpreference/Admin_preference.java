package com.example.moviedatabase_project.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Admin_preference  {

        private SharedPreferences preferences;
        private SharedPreferences.Editor editor;
        public Admin_preference (Context context){
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


