/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014年8月18日 上午9:49:14  
 * 
 */
package com.example.thread;

import android.util.Log;

/**
 * @description
 * 
 * @author yilong.yyl
 *
 * @date 2014年8月18日 上午9:49:14  
 * 
 */
public class finalizeTest {
	
	private static final String TAG = "finalizeTest";
	public finalizeTest(){
		
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		Log.e(TAG, "exe finalize");
	}
	
}
