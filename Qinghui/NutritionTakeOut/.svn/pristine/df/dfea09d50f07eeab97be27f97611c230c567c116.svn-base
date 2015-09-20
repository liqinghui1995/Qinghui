package com.example.nutrition.dinnerinfo.adapter;

import com.example.nutrition.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewLeftAdapter extends BaseAdapter{
	private Context context;
    private String[] a={"荤素搭配,要啥有啥！","传统经典美味。","上手才有感觉！","改善口味，木瓜哦~>o<!","有菜有肉,还怕不够？"}; 
	public ListViewLeftAdapter(Context context) {
		super();
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
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
			convertView = LayoutInflater.from(context).inflate(R.layout.dinner_info_listview_left_item, null);
			holder.tv = (TextView)convertView.findViewById(R.id.dinner_info_listview_left_tv);
			convertView.setTag(holder);
		}else
		{
			holder = (ViewHolder)convertView.getTag(); 
		} 
		holder.tv.setText(a[position]);


		return convertView;



	}

}
