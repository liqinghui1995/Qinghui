package com.example.nutrition.diningroom.fragment;

import com.baidu.pano.platform.http.v;
import com.example.nutrition.R;
import com.example.nutrition.diningroom.activity.DiningRoomActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class OrderPassDiningRoomFragment extends Fragment{
	
	private TextView iwant;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.order_pass_diningroom, null);
		Log.i("tag", view.toString());
		
		iwant=(TextView) view.findViewById(R.id.iwant);
		iwant.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getActivity(), DiningRoomActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}

}
