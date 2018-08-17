package com.test;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

public class IntentServiceDemo extends IntentService {

	public IntentServiceDemo() {
		//必须实现父类的构造方法
		super("IntentServiceDemo");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		return super.onBind(intent);
	}


	@Override
	public void onCreate() {
		System.out.println("onCreate");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		System.out.println("onStart");
		super.onStart(intent, startId);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}


	@Override
	public void setIntentRedelivery(boolean enabled) {
		super.setIntentRedelivery(enabled);
		System.out.println("setIntentRedelivery");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		//Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
		String action = intent.getExtras().getString("param");
		if (action.equals("oper1")) {
			System.out.println("Operation1");
		}else if (action.equals("oper2")) {
			System.out.println("Operation2");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}

}
