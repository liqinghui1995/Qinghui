package com.example.nutrition.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nutrition.R;
import com.example.nutrition.adapter.GiftsAdapter.viewHolder;
import com.example.nutrition.city.vo.DistrictVo;

public class MyDistrictAdapter extends BaseAdapter{
	private List<DistrictVo> list;
	private Context context;
	
	public MyDistrictAdapter(List<DistrictVo> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return list.size();
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
			viewHolder = new ViewHolder();
			convertView = View.inflate(context, R.layout.city_listview_adapter, null);
			viewHolder.districtName = (TextView) convertView.findViewById(R.id.cityname);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.districtName.setText(list.get(position).getDistrict());
		return convertView;
	}
	static class ViewHolder{
		TextView districtName;
	}
}
