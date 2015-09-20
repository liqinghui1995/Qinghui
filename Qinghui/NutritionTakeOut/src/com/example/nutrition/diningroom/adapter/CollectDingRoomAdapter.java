package com.example.nutrition.diningroom.adapter;

import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.adapter.DiningRoomAdapter.ViewHolder;
import com.example.nutrition.diningroom.vo.DiningRoom;
import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectDingRoomAdapter extends BaseAdapter{
	
	private Context context;
	private List<DiningRoom>  list;
	public CollectDingRoomAdapter(Context context, List<DiningRoom> list) {
		super();
		this.context = context;
		this.list = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = View.inflate(context,R.layout.activity_diningroom_item,null);
			holder.diningroom_item_name = (TextView) convertView.findViewById(R.id.diningroom_item_name);
			holder.diningroom_item_sold = (TextView) convertView.findViewById(R.id.diningroom_item_sold);
			holder.diningroom_item_startPrice = (TextView) convertView.findViewById(R.id.diningroom_item_startPrice);
			holder.diningroom_item_currentDistance = (TextView) convertView.findViewById(R.id.diningroom_item_currentDistance);
			holder.diningroom_item_favorable = (TextView) convertView.findViewById(R.id.diningroom_item_favorable);
			holder.diningroom_item_image = (ImageView) convertView.findViewById(R.id.diningroom_item_image);
			holder.diningroom_item_level = (ImageView) convertView.findViewById(R.id.diningroom_item_level);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
//		Log.i("TAG", "开始执行········");
		DiningRoom diningRoom = list.get(position);
//		Log.i("TAG", "即将开始·······");
//		Log.i("TAG", list.get(position).getDiningRoomName());
		holder.diningroom_item_name.setText(diningRoom.getDiningRoomName());
		holder.diningroom_item_sold.setText(diningRoom.getDiningRoomSold());
		holder.diningroom_item_startPrice.setText(diningRoom.getDiningRoomStartPrice());
		holder.diningroom_item_currentDistance.setText(diningRoom.getDiningRoomCurrentDistance());
		holder.diningroom_item_favorable.setText(diningRoom.getDiningRoomActivityFavorable());
		BitmapUtils bitmapUtils = new BitmapUtils(context);
		bitmapUtils.display(holder.diningroom_item_image, "http://cblue.tunnel.mobi/WebShop/diningimages/"+diningRoom.getDiningRoomImage());
		bitmapUtils.display(holder.diningroom_item_level, "http://cblue.tunnel.mobi/WebShop/diningimages/"+diningRoom.getDiningRoomLevel());
		return convertView;
	}
	
	class ViewHolder {
		TextView diningroom_item_name,diningroom_item_sold,diningroom_item_startPrice,diningroom_item_currentDistance,diningroom_item_favorable;
		ImageView diningroom_item_image,diningroom_item_level;
	}
	

}
