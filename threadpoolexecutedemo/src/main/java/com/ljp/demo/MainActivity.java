package com.ljp.demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private ThreadPoolExecutor threadPoolExecutor;

    private ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);

    MyRunable runable;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10,
                TimeUnit.SECONDS, queue, new ThreadFactory() {

            private AtomicInteger mInteger = new AtomicInteger(1);
            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r,"thread #" +mInteger.getAndIncrement());
                return thread;
            }
        });

        //终止一个线程
        runable = new MyRunable();
        thread = new Thread(runable);
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(View v){
        for (int i=0;i<15;i++){
            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("ArrayBlockingQueue","index:"+ finalI +"--queue size:"+queue.size());
                }
            });
        }
    }

    public void click1(View v){//停止线程
        runable.flag = false;
        thread.interrupt();
    }


    public class MyRunable implements Runnable {

        public volatile boolean flag = true;

        @Override
        public void run() {
            while(flag && !Thread.interrupted()){
                try {
                    Log.e("MyRunable","running");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

}
