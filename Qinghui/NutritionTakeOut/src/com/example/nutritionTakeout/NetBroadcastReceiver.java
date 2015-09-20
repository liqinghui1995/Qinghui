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
				Toast.makeText(context, "����������", 1).show();
				if(NetTools.wifiConnect(context)){
					Toast.makeText(context,"wifi������",10).show();
				}
				if(NetTools.gprsConnect(context)){
					Toast.makeText(context, "�ֻ�����������", 10).show();
				}
			}else{
				Toast.makeText(context, "���粻����", 1).show();
				
			}
		}

	}

}
