package com.example.nutrition.order.adapter;

import java.util.ArrayList;

import cn.jpush.android.api.c;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.example.nutrition.order.activity.OrderActivity;
import com.example.nutrition.order.vo.Order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrderAdpter extends BaseAdapter {

	private ArrayList<Shop> list;
	private Context context;
	
	
	public OrderAdpter(ArrayList<Shop> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHoder holder = null;
		if(convertView == null){
			holder = new ViewHoder();
			convertView = LayoutInflater.from(context).inflate(R.layout.main_order, null);
			holder.accept = (TextView) convertView.findViewById(R.id.accept);
			holder.accept_time = (TextView) convertView.findViewById(R.id.accept_time);
			holder.money = (TextView) convertView.findViewById(R.id.money);
			holder.mun = (TextView) convertView.findViewById(R.id.mun);
			holder.order_lauout = (RelativeLayout) convertView.findViewById(R.id.order_lauout);
			holder.diningroom = (TextView) convertView.findViewById(R.id.diningroom);
			convertView.setTag(holder);
		}else{
			holder = (ViewHoder) convertView.getTag();
		}
		
		holder.money.setText(""+list.get(position).getPrice());
		holder.mun.setText(list.get(position).getNumber()+"");
		holder.diningroom.setText(list.get(position).getName()+"");
		/**
		 * 点击评论，跳转到订单详情页面
		 */
		holder.order_lauout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(context, "您点击了评论", 1).show();
				Intent intent = new Intent();
				intent.setClass(context, OrderActivity.class);
				context.startActivity(intent);
			}
		});
		
//		Intent intent = ((Activity) context).getIntent();
//		String price = intent.getStringExtra("price");
//		String num = intent.getStringExtra("num");
//		String diningroom = intent.getStringExtra("name");
//		holder.money.setText(price);
//		holder.mun.setText(num);
//		holder.diningroom.setText(diningroom);
		return convertView;
	}

	class ViewHoder{
		TextView accept , accept_time , money , mun , diningroom;
		RelativeLayout order_lauout;
		Button comment;
	}
}
