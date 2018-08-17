package com.ljp.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart,btnEnd,btnBind,btnUnbing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        btnEnd = findViewById(R.id.btn_end);
        btnBind = findViewById(R.id.btn_bind);
        btnUnbing = findViewById(R.id.btn_unbind);

        btnStart.setOnClickListener(this);
        btnEnd.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnbing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_start:
                intent = new Intent(this,MyService.class);
                startService(intent);
                break;
            case R.id.btn_end:
                intent = new Intent(this,MyService.class);
                stopService(intent);
                break;
            case R.id.btn_bind:
                intent = new Intent(this,MyService.class);
                bindService(intent,mConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(mConnection);
                break;
        }
    }

    private final ServiceConnection mConnection = new ServiceConnection()
    {

        @Override
        public void onServiceDisconnected(ComponentName arg0)
        {
//            Log.e(TAG, "----onServiceDisconnected----");
        }

        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1)
        {
//            Log.e(TAG, "----onServiceConnected----");
        }
    };
}
