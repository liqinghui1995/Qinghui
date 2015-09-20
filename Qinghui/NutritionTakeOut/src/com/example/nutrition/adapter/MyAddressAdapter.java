package com.example.nutrition.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nutrition.R;
import com.example.nutrition.user.vo.UserAddressVo;

public class MyAddressAdapter extends BaseAdapter{
	private List<UserAddressVo> list;
	private Context context;
	
	public MyAddressAdapter(List<UserAddressVo> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return  list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			convertView = View.inflate(context, R.layout.add_address_item, null);
			viewHolder = new ViewHolder();
			viewHolder.address = (TextView) convertView.findViewById(R.id.address);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.address.setText(list.get(position).getAddress());
		return convertView;
	}
	static class ViewHolder{
		TextView address;
	}
}
