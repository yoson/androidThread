package com.example.thread;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private static final String TAG = "Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		finalizeTest ft = new finalizeTest();
		try {
			ft.finalize();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Handler handlermain = new Handler(getMainLooper()){

					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						switch (msg.what) {
						case 1:
							Log.i(TAG, "where am i?"+Thread.currentThread().getName());
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
				Message msg = Message.obtain(handlermain);
				msg.what = 1;
				msg.obj = "new thread";
				handlermain.sendMessage(msg);
				
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		
		
		
		
		
		
		
		MyHandlerThread mhThread = new MyHandlerThread("myhandlerthread");
		mhThread.start();
		Handler handler1 = mhThread.getmHandler();
		handler1.post(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.i(TAG, "where am i?"+Thread.currentThread().getName());
			}
			
		});
		Message msg = Message.obtain(handler1);
		msg.what = 1;
		msg.obj = "what ==1";
		//mess.sendToTarget();
		handler1.sendMessage(msg);
		
		
		
		MyThread mt = new MyThread("mythread");
		mt.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Handler handler = mt.getHandler();
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.i(TAG, "where am i?"+Thread.currentThread().getName());
			}
		});
		Log.i(TAG, "where am i?"+Thread.currentThread().getName());
		Message mess = Message.obtain(handler);
		mess.what = 1;
		mess.arg1 = 1;
		mess.obj = "what ==1";
		//mess.sendToTarget();
		handler.sendMessage(mess);
		mess = Message.obtain(handler);
		mess.what = 2;
		mess.arg1 = 3;
		mess.obj = "what ==2";
		handler.sendMessageAtFrontOfQueue(mess);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
