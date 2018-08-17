package com.ljp.okhttpdemo;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/8/7
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class App extends Application {

    public static Application context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }
}
