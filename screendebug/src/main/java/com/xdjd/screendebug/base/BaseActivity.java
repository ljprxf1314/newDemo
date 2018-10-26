package com.xdjd.screendebug.base;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import butterknife.ButterKnife;


/**
 * Created by lijipei on 2016/11/15.
 */

public abstract class BaseActivity extends FragmentActivity {

    /**
     * 键盘管理对象
     */
    protected InputMethodManager manager;
    protected NotificationManager notificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //去掉actionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        setSystemBarColor(R.color.transparent);
        initData();
    }

    protected abstract int getContentView();

    protected void initData() {
    }

    /**
     * 设置状态
     */
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 跳转一个界面不传递数据
     *
     * @param clazz
     */
    public void startActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }


    public void showToast(String info) {
        Toast toast = Toast.makeText(this, info, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 显示Log
     */
    public void log(String toast) {
        Log.e("TAG", toast);
    }

    /**
     * 隐藏软键盘
     */
    public void hideKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    protected void onDestroy() {
//        isShowDismissDialog();
        super.onDestroy();
    }

    public void showProgressDialog(Context context) {
//        CustomProgress.show(context, "加载中...", true, null);
    }

    /**
     * 自己填写信息的ProgressDialog
     */
    public void showProgressDialog(Context context, String message) {
        if (message == null || message.equals("")) {
            showProgressDialog(context);
        } else {
//            CustomProgress.show(this, message, true, null);
        }
    }

    /**
     * 停止progressDialog
     */
    public void disProgressDialog(Context context) {
//        CustomProgress.hideProgress(context);
    }

//    public void isShowDismissDialog(){
//        CustomProgress.isShowDismissDialog();
//    }

    /**
     * 销毁界面--由于网络回调有时候销毁不掉界面而写的方法
     */
    protected void finishActivity() {
        finish();
    }

    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
