package com.memad.languageexample;

import android.content.Context;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatActivity;

import com.memad.languageexample.utils.LocaleHelper;

import static com.memad.languageexample.utils.LanguageUtils.getLanguage;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.changeLanguage(
                newBase, getLanguage(newBase)));
    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        super.applyOverrideConfiguration(getBaseContext().getResources().getConfiguration());
    }
}
