package com.example.myapplication.utlis;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SpUtil {

    static SharedPreferences prefs;

    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getData(String key) {
        return prefs.getString(key, "");
    }

    public static long getLong(String key) {
        return prefs.getLong(key,0);
    }

    public static void setData(String key, String data) {
        prefs.edit().putString(key, data).apply();
    }

    public static void setLong(String key, long data) {
        prefs.edit().putLong(key, data).apply();
    }

    /**
     * 获取登录状态
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {
        return prefs.getBoolean(key, false);
    }

    /**
     * 设置登录状态
     * @param key
     * @param data
     */
    public static void setBoolean(String key, boolean data) {
        prefs.edit().putBoolean(key, data).apply();
    }

}
