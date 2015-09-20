package com.example.nutrition.order.adapter;

import java.util.ArrayList;

import com.example.nutrition.R;
import com.example.nutrition.order.vo.CommintOrder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommitOrderAdpter extends BaseAdapter{

	private ArrayList<CommintOrder> list;
	private Context context;
	
	public CommitOrderAdpter(ArrayList<CommintOrder> list, Context context) {
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
		
		Viewholder holder = null;
		if(convertView == null){
			holder = new Viewholder();
			convertView = LayoutInflater.from(context).inflate(R.layout.order_show, null);
			holder.biches = (TextView) convertView.findViewById(R.id.biches);
			holder.biches_num = (TextView) convertView.findViewById(R.id.biches_num);
			holder.biches_price = (TextView) convertView.findViewById(R.id.biches_price);
			holder.biches_money = (TextView) convertView.findViewById(R.id.biches_money);
			convertView.setTag(holder);
		}else{
			holder = (Viewholder) convertView.getTag();
		}
		
		holder.biches.setText(list.get(position).getBiches());
		holder.biches_num.setText(list.get(position).getBiches_num());
		holder.biches_money.setText(list.get(position).getBiches_money());
		holder.biches_price.setText(list.get(position).getBiches_price());
		return convertView;
	}

	class Viewholder{
		TextView biches , biches_num , biches_price , biches_money;
	}
}
