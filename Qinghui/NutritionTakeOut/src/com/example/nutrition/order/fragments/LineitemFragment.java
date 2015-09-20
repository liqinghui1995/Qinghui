package com.example.nutrition.order.fragments;

import java.util.ArrayList;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.activity.DiningRoomActivity;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBHelper;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.lidroid.xutils.BitmapUtils;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LineitemFragment extends Fragment{

	private RelativeLayout details_back;
	private Button sameagain;
	private ImageView dininglog;
	private TextView diningname , meal_time;
	private SQLiteDatabase db;
	private CarDBUtils carDbUtils;
	private ArrayList<Shop> list = new ArrayList<Shop>();
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_order_details, null);
		details_back = (RelativeLayout) view.findViewById(R.id.details_back);
		sameagain = (Button) view.findViewById(R.id.sameagain);
		diningname = (TextView) view.findViewById(R.id.diningname);
		meal_time = (TextView) view.findViewById(R.id.meal_time);
		Intent intent = getActivity().getIntent();
		diningname.setText(intent.getStringExtra("DiningRoomName"));
		meal_time.setText(intent.getStringExtra("DiningRoomSendTime"));
		BitmapUtils utils = new BitmapUtils(getActivity());
		CarDBHelper helper = new CarDBHelper(getActivity());
		db = helper.getWritableDatabase();
		carDbUtils = new CarDBUtils(db);
		list =  (ArrayList<Shop>) carDbUtils.query();
		for (int i = 0; i < list.size(); i++) {
			diningname.setText(list.get(i).getName());
			
		}
		utils.display(dininglog, "http://cblue.tunnel.mobi/WebShop/diningimages/"+intent.getStringExtra("DiningRoomImage"));
		sameagain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), DiningRoomActivity.class);
				startActivity(intent);
			}
		});
		details_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), DiningRoomActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
}