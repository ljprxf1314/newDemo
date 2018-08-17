package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //可以启动多次，每启动一次，就会新建一个work thread，但IntentService的实例始终只有一个
        //Operation 1
        Intent startServiceIntent = new Intent("com.test.intentservice");
        Bundle bundle = new Bundle();
        bundle.putString("param", "oper1");
        startServiceIntent.putExtras(bundle);
        startService(startServiceIntent);
        
        //Operation 2
        Intent startServiceIntent2 = new Intent("com.test.intentservice");
        Bundle bundle2 = new Bundle();
        bundle2.putString("param", "oper2");
        startServiceIntent2.putExtras(bundle2);
        startService(startServiceIntent2);
    }
}