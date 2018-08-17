package com.ljp.okhttpdemo;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljp.okhttpdemo.utils.MD5Util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;

    private MyListener mMyListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }

    private void request(){
        //构建请求体
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        //请求参数主题
        RequestBody formBody = new FormBody.Builder()
                .add("logincode", "13683310026")
                .add("pwd", MD5Util.md5("123456"))
                .build();

        //构建请求
        Request request = new Request.Builder().url("https://ds.sqkx.net/mobile/work/loginControl/login.action")
                .post(formBody)
                .build();

        //发起请求,并回调
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.e("结果",response.body().string());
                final String msg = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(msg);
                    }
                });
            }
        });
    }
}
