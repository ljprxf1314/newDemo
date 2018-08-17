package com.ljp.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljp.customview.activity.CanvasActivity;
import com.ljp.customview.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView(){
        btn1 = findViewById(R.id.btn1);
    }

    private void initListener(){
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startActivity(CanvasActivity.class);
                break;
        }
    }
}
