package com.memad.languageexample.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.memad.languageexample.BaseActivity;
import com.memad.languageexample.utils.LocaleHelper;
import com.memad.languageexample.R;

public class LanguagesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        setTitle(getString(R.string.title1));

        findViewById(R.id.toArabicButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.changeLanguage(LanguagesActivity.this, "ar");
                recreateTask(getApplicationContext());
            }
        });
        findViewById(R.id.toEnglishButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.changeLanguage(LanguagesActivity.this, "en");
                recreateTask(getApplicationContext());
            }
        });
    }
    public static void recreateTask(final Context context) {
        final PackageManager pm = context.getPackageManager();
        final Intent intent = pm.getLaunchIntentForPackage(context.getPackageName());
        final ComponentName componentName = intent.getComponent();
        final Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }
}
