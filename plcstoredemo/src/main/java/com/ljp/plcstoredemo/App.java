package com.ljp.plcstoredemo;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * Created by lijipei on 2016/11/14.
 */

public class App extends Application {

    public static Context context = null;

    public static Handler handler = null;

    public static Thread mainThread = null;

    public static int mainThreadId = 0;

    public static App instance;

    private static final String DB_NAME = "cabinets.db";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myTid();

        instance = this;

    }

    public static App getInstance(){
        return instance;
    }


}
