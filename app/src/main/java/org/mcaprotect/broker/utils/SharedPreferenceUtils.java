package org.mcaprotect.broker.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {
    private static final String PREF_NAME = "McaProtectPrefs";

    //Persistent memory for login
    public static final String USER_MAIL_ID = "USER_MAIL_ID";
    public static final String USER_PASSWORD = "USER_PASSWORD";

    public static final String REMEMBER_PASSWORD = "REMEMBER_PASSWORD";


    public static String getStringPreference(Context activity, String key) {
        if (activity == null)
            return "";

        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        return sp.getString(key, "");
    }

    public static void setStringPreference(Context activity, String key, String value) {
        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean getBooleanPreference(Context activity, String key) {
        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        return sp.getBoolean(key, false);
    }

    public static void setBooleanPreference(Context activity, String key, boolean value) {
        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static int getIntegerPreference(Context activity, String key) {
        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        return sp.getInt(key, 0);
    }

    public static void setIntegerPreference(Context activity, String key, int value) {
        SharedPreferences sp = activity.getSharedPreferences(SharedPreferenceUtils.PREF_NAME, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }
}
