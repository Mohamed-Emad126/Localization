package com.memad.languageexample.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

import static com.memad.languageexample.utils.LanguageUtils.setLanguage;

public class LocaleHelper {

    public static Context changeLanguage(final Context context, final String toLang) {
        //at first save the desired language at shared preference
        setLanguage(context, toLang);

        final Locale toLocale = new Locale(toLang);
        Locale.setDefault(toLocale);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            return updateResourcesForO(context, toLocale);
        }
        else{
            return updateResources(context, toLocale);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private static Context updateResourcesForO(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        LocaleList localeList = new LocaleList(locale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context updateResources(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}