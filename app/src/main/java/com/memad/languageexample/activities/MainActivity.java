package com.memad.languageexample.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.memad.languageexample.BaseActivity;
import com.memad.languageexample.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.title));

        findViewById(R.id.startSettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LanguagesActivity.class));
            }
        });
    }
}
