package com.adeebnqo.android_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.adeebnqo.bleep.Bleeper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            Bleeper.getBlepper().beep().move().showVisualIndicator(this);
        }
    }

}
