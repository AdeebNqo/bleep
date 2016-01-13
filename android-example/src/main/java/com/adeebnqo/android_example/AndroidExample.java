package com.adeebnqo.android_example;

import android.app.Application;

import com.adeebnqo.bleep.Bleeper;

public class AndroidExample extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Bleeper.init(this);
        }
    }
}
