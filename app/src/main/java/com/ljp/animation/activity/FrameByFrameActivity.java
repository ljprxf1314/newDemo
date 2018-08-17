package com.ljp.animation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ljp.animation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2017/11/8
 *     desc   : 逐帧动画activity
 *     version: 1.0
 * </pre>
 */

public class FrameByFrameActivity extends AppCompatActivity {

    private ImageView mIvAnimation;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);
        ButterKnife.bind(this);

        mIvAnimation = (ImageView) findViewById(R.id.iv_animation);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FrameByFrameActivity.this,"动画开始了",Toast.LENGTH_SHORT).show();
                AnimationDrawable anim = (AnimationDrawable) mIvAnimation.getBackground();
                anim.start();
            }
        });
    }

}
