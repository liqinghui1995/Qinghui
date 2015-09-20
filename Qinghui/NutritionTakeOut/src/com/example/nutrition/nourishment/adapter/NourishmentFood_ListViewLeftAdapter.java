package com.example.nutrition.nourishment.adapter;


import java.util.List;

import com.example.nutrition.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NourishmentFood_ListViewLeftAdapter extends BaseAdapter{
	private Context context;
	private List<String> list;

	public NourishmentFood_ListViewLeftAdapter(Context context,
			List<String> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	static class ViewHolder{
		TextView tv;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;

		if(convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.nourishment_listview_left_item, null);
			holder.tv = (TextView)convertView.findViewById(R.id.nourishment_info_listview_left_tv);
			convertView.setTag(holder);
			
		}else
		{
			holder = (ViewHolder)convertView.getTag(); 
		} 
		holder.tv.setText(list.get(position));

		return convertView;
	}

}
