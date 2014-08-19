/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014年8月15日 下午7:29:54  
 * 
 */
package com.example.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014年8月15日 下午7:29:54  
 * 
 */
public class MyHandlerThread extends HandlerThread {

	/**
	 * @param name
	 */
	private static final String TAG = "HanlderThread";
	private Handler mHandler;
	
	public MyHandlerThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Handler getmHandler() {
		return mHandler;
	}


	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		Looper looper = getLooper();
		mHandler = new Handler(looper){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case 1:
					Log.i(TAG, msg.obj.toString());
					break;
				case 2:
					Log.i(TAG, msg.obj.toString());
					break;
				default:
					super.handleMessage(msg);
					break;
				}
				
			}
			
		};
	}
	

}
