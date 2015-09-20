package com.example.nutrition.dinnerinfo.fragment;

import com.example.nutrition.R;
import com.example.nutrition.order.activity.OrderActivity;
import com.lidroid.xutils.BitmapUtils;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MenuFragment extends Fragment{

	//餐厅的名称，类别，起送价，邮费，送餐时间,营业时间，餐厅地址，餐厅简介
	private TextView diningname , dining_sort , price , postage , send_time , open_time , dining_address , dining_details , coupon;
	private ImageView headinco , star;//餐厅log

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//加载餐厅详情布局页面
		View view = inflater.inflate(R.layout.fragment_dinner_menu, null);
		//获取控件的ID
		diningname = (TextView)view.findViewById(R.id.diningname);
		headinco = (ImageView) view.findViewById(R.id.headinco);
		star = (ImageView) view.findViewById(R.id.star);
		dining_sort = (TextView) view.findViewById(R.id.dining_sort);
		price = (TextView) view.findViewById(R.id.price);
		postage = (TextView) view.findViewById(R.id.postage);
		send_time = (TextView) view.findViewById(R.id.send_time);
		open_time = (TextView) view.findViewById(R.id.open_time);
		coupon = (TextView) view.findViewById(R.id.coupon);
		dining_address = (TextView) view.findViewById(R.id.dining_address);
		dining_details = (TextView) view.findViewById(R.id.dining_details);
		//接受传过来的数据
		Intent intent = getActivity().getIntent();
		diningname.setText(intent.getStringExtra("DiningRoomName"));
		dining_sort.setText(intent.getStringExtra("DiningRoomClasses"));
		price.setText(intent.getStringExtra("DiningRoomStartPrice"));
		postage.setText(intent.getStringExtra("DiningRoomFreight"));
		send_time.setText(intent.getStringExtra("DiningRoomSendTime"));
		open_time.setText(intent.getStringExtra("DiningRoomShopHours"));
		dining_address.setText(intent.getStringExtra("RoomAddress"));
		coupon.setText(intent.getStringExtra("diningRoomActivityFavorable"));
		dining_details.setText(intent.getStringExtra("getDiningRoomIntroduce"));
		
		BitmapUtils utils = new BitmapUtils(getActivity());
		utils.display(headinco, "http://cblue.tunnel.mobi/WebShop/diningimages/"+intent.getStringExtra("DiningRoomImage"));
		utils.display(star, "http://cblue.tunnel.mobi/WebShop/diningimages/" + intent.getStringExtra("diningRoomLevel"));
		return view;
	}

}
