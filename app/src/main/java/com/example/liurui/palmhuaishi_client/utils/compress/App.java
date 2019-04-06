package com.example.liurui.palmhuaishi_client.utils.compress;

import android.app.Application;
import android.content.Context;

/**
 * Created by liurui on 2019.3.27.
 */

public class App extends Application {

    private static App app;

    public static App getInstance() {
        return app;
    }
    /**
     * 获取Application Context
     */
    public static Context getAppContext() {
        return app != null ? app.getApplicationContext() : null;
    }

    public static String currentUserNick = "";
}
