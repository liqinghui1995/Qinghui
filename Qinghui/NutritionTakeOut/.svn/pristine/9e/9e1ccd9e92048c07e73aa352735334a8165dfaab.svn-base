package com.example.nutritionTakeout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/**
 * 判断网络是否连接
 * 判断网络的连接类型
 * @author Administrator
 *
 */
public class NetTools {
	
	
	/**
	 * 查看网络是否连接
	 * @param context
	 * @return
	 */
	public static boolean isConnect(Context context){
		 boolean flag = false;
		 ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		 NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
		 if(networkInfo!=null){
			 return networkInfo.isAvailable();
		 }
		 return flag;
	}
	
	/**
	 * 是否是wifi连接
	 * @param context
	 * @return
	 */
	public static boolean wifiConnect(Context context){
		boolean flag = false;
		 ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		 State state = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
		 if(NetworkInfo.State.CONNECTED.equals(state)){
			 flag = true;
		 }
		return flag;
	}
	
	/**
	 * 是否是手机网路连接
	 * @param context
	 * @return
	 */
	public static boolean gprsConnect(Context context){
		boolean flag = false;
		 ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		 State state = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
		 if(NetworkInfo.State.CONNECTED.equals(state)){
			 flag = true;
		 }
		return flag;
	}

}
