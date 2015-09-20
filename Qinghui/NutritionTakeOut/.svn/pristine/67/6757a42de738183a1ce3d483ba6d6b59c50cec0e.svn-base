package com.example.nutrition.broadcasts;

import com.example.nutritionTakeout.MainActivity;

import cn.jpush.android.api.JPushInterface;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		String content = bundle.getString(JPushInterface.EXTRA_ALERT);
		Intent intent1 = new Intent(context,MainActivity.class);
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent1);
		Toast.makeText(context, content+":", 1).show();
	}

}
