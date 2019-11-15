package com.example.moviedatabase_project.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Useridpreferences {

        private SharedPreferences preferences;
        private SharedPreferences.Editor editor;


        public Useridpreferences(Context context)
        {
            preferences = context.getSharedPreferences("UserLongID",Context.MODE_PRIVATE);
            editor = preferences.edit();
        }


        public void setLogin(long l_id)
        {
            editor.putLong("loginID",l_id);
            editor.commit();
        }
        public long getLoginID()
        {
            return preferences.getLong("loginID",0);
        }
    }

