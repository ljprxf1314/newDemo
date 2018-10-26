package com.ljp.alarmdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/9/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class UpdateAppVersionReceiver extends BroadcastReceiver {

    private final String TAG = "闹钟com.ljp.alarmdemo.UpdateAppVersionReceiver";

    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "root Runtime->reboot666");
        if (intent.getAction().equals("UpdateAppVersionReceiver")){
            Log.e(TAG, "收到消息root Runtime->reboot666");
        }
    }
}
