package com.ljp.alarmdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/9/7
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    private Context context;
    private final String TAG = "闹钟com.ljp.alarmdemo.AlarmBroadcastReceiver";

    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        if (intent.getAction().equals("AlarmBroadcastReceiver")){
            Log.e(TAG,"闹钟来啦");
        }
    }



}
