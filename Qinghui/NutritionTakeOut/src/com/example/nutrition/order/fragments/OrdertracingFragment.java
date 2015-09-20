package com.example.nutrition.order.fragments;

import com.example.nutrition.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrdertracingFragment extends Fragment{

	private TextView dining_phone;
	private Button rebate;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_order_trace, null);
		dining_phone = (TextView) view.findViewById(R.id.dining_phone);
		rebate = (Button) view.findViewById(R.id.rebate);
		rebate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				Toast.makeText(getActivity(), "你点击了退款按钮", 1).show();
				AlertDialog.Builder log = new Builder(getActivity());
				log.setTitle("提示")
				.setMessage("抱歉，订单已经超出退款申请时间，您可以拨打超人免费热线进行退款申请。4001-517-577")
				.setNegativeButton("取消", null)
				.setPositiveButton("拨打", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						String s=dining_phone.getText().toString();
						Intent myIntentDial=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+s));
						startActivity(myIntentDial); 
					}

				})
				.show();
			}
		});
		dining_phone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String s=dining_phone.getText().toString();
				Intent myIntentDial=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+s));
				startActivity(myIntentDial); 

			}
		});

		return view;
	}
}
