package com.example.nutrition.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nutrition.R;
import com.example.nutrition.adapter.HomePageAdapter.ViewHolder;
import com.example.nutrition.city.vo.CityVo;

public class MyCityAdapter extends BaseAdapter{
	private List<CityVo> list;
	private Context context;
	public MyCityAdapter(List<CityVo> list, Context context) {
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
			viewHolder.cityname = (TextView) convertView.findViewById(R.id.cityname);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.cityname.setText(""+list.get(position).getCity());
		return convertView;
	}
	
	static class ViewHolder{
		TextView cityname;
	}
	
}
