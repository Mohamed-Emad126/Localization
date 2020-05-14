package com.memad.languageexample.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class LanguageUtils {
    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    public static void setLanguage(Context context, String language) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    public static String getLanguage(Context context) {
        return getSharedPreferences(context).getString(SELECTED_LANGUAGE, "sys");
    }
}
