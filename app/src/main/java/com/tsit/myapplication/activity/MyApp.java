package com.tsit.myapplication.activity;

import android.app.Application;

public class MyApp extends Application {
    private static MyApp Instance;
    @Override
    public void onCreate() {
        super.onCreate();
        Instance=this;
    }

    public static MyApp getInstance() {
        return Instance;
    }
}
