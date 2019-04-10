package com.example.liurui.palmhuaishi_client.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by liurui on 2019.4.10.
 */

public class MyApplication extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this.getApplicationContext();
    }

    public static Context getContext() {
        return appContext;
    }
}