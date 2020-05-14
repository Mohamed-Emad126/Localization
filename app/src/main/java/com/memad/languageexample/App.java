package com.memad.languageexample;

import android.app.Application;
import android.content.Context;

import com.memad.languageexample.utils.LocaleHelper;

import static com.memad.languageexample.utils.LanguageUtils.getLanguage;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.changeLanguage(
                base, getLanguage(base)));
    }
}
