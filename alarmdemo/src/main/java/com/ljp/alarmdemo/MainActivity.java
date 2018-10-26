package com.ljp.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn_file;
    Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendar = Calendar.getInstance();

        btn1 = findViewById(R.id.btn1);
        btn_file = findViewById(R.id.btn_file);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, AlarmBroadcastReceiver.class);
                intent.setAction("AlarmBroadcastReceiver");
                PendingIntent pintent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2 * 60 * 1000, pintent);


                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, 0);//增加一天
                calendar.set(Calendar.HOUR_OF_DAY, 14);
                calendar.set(Calendar.MINUTE, 30);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                Date time = calendar.getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String format = df.format(time);
                Log.e("闹钟开始时间",format);
                long systemTime = calendar.getTimeInMillis();

                Intent intentVersion = new Intent(MainActivity.this, UpdateAppVersionReceiver.class);
                intentVersion.setAction("UpdateAppVersionReceiver");
                PendingIntent pintentVersion = PendingIntent.getBroadcast(MainActivity.this, 1, intentVersion, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager amVersion = (AlarmManager) getSystemService(ALARM_SERVICE);

                amVersion.setRepeating(AlarmManager.RTC_WAKEUP, systemTime, 24*60*60*1000, pintentVersion);


                //获取当前毫秒值
                /*long systemTime = System.currentTimeMillis();

                //是设置日历的时间，主要是让日历的年月日和当前同步
                mCalendar.setTimeInMillis(System.currentTimeMillis());
                // 这里时区需要设置一下，不然可能个别手机会有8个小时的时间差
                mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                //设置在几点提醒  设置的为0点
                mCalendar.set(Calendar.HOUR_OF_DAY, 16);
                //设置在几分提醒  设置的为0分
                mCalendar.set(Calendar.MINUTE, 20);
                //下面这两个看字面意思也知道
                mCalendar.set(Calendar.SECOND, 0);
                mCalendar.set(Calendar.MILLISECOND, 0);
                //上面设置的就是13点25分的时间点

                //获取上面设置的13点25分的毫秒值
                long selectTime = mCalendar.getTimeInMillis();

                Log.e("开始时间",StringUtils.getDate(selectTime+"","yyyy-MM-dd hh:MM:ss"));*/
            }
        });

        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    /**
     * 判断SDCard是否存在 [当没有外挂SD卡时，内置ROM也被识别为存在sd卡]
     *
     * @return
     */
    public static boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取SD卡根目录路径
     *
     * @return
     */
    public static String getSdCardPath() {
        boolean exist = isSdCardExist();
        String sdpath = "";
        if (exist) {
            sdpath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath();
        } else {
            sdpath = "不适用";
        }
        return sdpath;

    }

    /**
     * 获取默认的文件路径
     *
     * @return
     */
    public static String getDefaultFilePath() {
        String filepath = "";
        File file = new File(Environment.getExternalStorageDirectory(),
                "abc.txt");
        if (file.exists()) {
            filepath = file.getAbsolutePath();
        } else {
            filepath = "不适用";
        }
        return filepath;
    }
}
