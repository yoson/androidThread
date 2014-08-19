/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014��8��7�� ����9:38:30  
 * 
 */
package com.example.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014��8��15�� ����4:47:55  
 * 
 */
public class MyThread extends Thread {
	private static final String TAG = "MyThread";
	private Handler mHandler;
	
	
	public MyThread(String name){
		super(name);
		Log.i(TAG, "���캯��");
	}
	public Handler getHandler(){
		return mHandler;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		Log.i(TAG, "thread destroy");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Looper.prepare();
		mHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case 1:
					Log.i(TAG, msg.obj.toString());
					//Log.i(TAG, "what == 1");
					break;
				case 2:
					Log.i(TAG, msg.obj.toString());
					//Log.i(TAG, "what == 2");
					break;
				default:
					super.handleMessage(msg);
					break;
				}	
			}
			
		};
		Looper.loop();
	}
	
}
