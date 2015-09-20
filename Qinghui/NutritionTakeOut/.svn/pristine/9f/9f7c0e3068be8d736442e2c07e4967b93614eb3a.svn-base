package com.example.nutrition.diningroom.adapter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.vo.DiningRoom;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DiningRoomAdapter extends BaseAdapter {
	private Context context;
	private List<DiningRoom>  list;
	private ImageLoader imageLoader;
	private ImageLoadingListener animateFirstListener;
	private DisplayImageOptions options;
	public DiningRoomAdapter(Context context, List<DiningRoom> list , ImageLoader imageLoader ) {
		super();
		this.context = context;
		this.list = list;
		this.imageLoader = imageLoader;

		/*
		 * 是否缓存与缓存设置
		 */
		options = new DisplayImageOptions.Builder()            //加载失败时的图片
		.cacheInMemory(true)                               //启用内存缓存
		.cacheOnDisk(true)                                 //启用外存缓存
		.considerExifParams(true)                         //启用EXIF和JPEG图像格式
		.displayer(new RoundedBitmapDisplayer(10))         //设置显示风格这里是圆角矩形
		.build();
		//imageloader监听动画
		animateFirstListener = new AnimateFirstDisplayListener();
	}

	@Override
	public int getCount() {

		return list.size();
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
		//		bitmapUtils.display(holder.diningroom_item_image, "http://cblue.tunnel.mobi/WebShop/diningimages/"+diningRoom.getDiningRoomImage());
		bitmapUtils.display(holder.diningroom_item_level, "http://cblue.tunnel.mobi/WebShop/diningimages/"+diningRoom.getDiningRoomLevel());
		imageLoader.displayImage("http://cblue.tunnel.mobi/WebShop/diningimages/"+diningRoom.getDiningRoomImage(), holder.diningroom_item_image, options, animateFirstListener);
		return convertView;

	}

	class ViewHolder {
		TextView diningroom_item_name,diningroom_item_sold,diningroom_item_startPrice,diningroom_item_currentDistance,diningroom_item_favorable;
		ImageView diningroom_item_image,diningroom_item_level;
	}
	/*
	 * 设置ImageLoader动画
	 */
	private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
		static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
