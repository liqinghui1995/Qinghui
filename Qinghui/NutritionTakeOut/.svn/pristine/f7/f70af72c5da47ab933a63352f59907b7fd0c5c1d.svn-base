package com.example.nutritionTakeout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class NetBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(ConnectivityManager.CONNECTIVITY_ACTION.equals(action)){
			if(NetTools.isConnect(context)){
				Toast.makeText(context, "网络连接了", 1).show();
				if(NetTools.wifiConnect(context)){
					Toast.makeText(context,"wifi连接了",10).show();
				}
				if(NetTools.gprsConnect(context)){
					Toast.makeText(context, "手机网络连接了", 10).show();
				}
			}else{
				Toast.makeText(context, "网络不可用", 1).show();
				
			}
		}

	}

}
