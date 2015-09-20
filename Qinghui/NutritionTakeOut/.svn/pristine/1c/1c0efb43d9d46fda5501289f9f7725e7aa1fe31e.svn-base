package com.example.nutrition.nourishment.adapter;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import za.co.immedia.pinnedheaderlistview.SectionedBaseAdapter;

import com.example.nutrition.R;
import com.example.nutrition.nourishment.bean.NourishmentFood;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class NourishmentFood_PhlvAdapter extends SectionedBaseAdapter{
	private Context context;
	private List<String> section;       //相当于expandableListView的 group
	private List<List<com.example.nutrition.nourishment.bean.NourishmentFood>> item;    //相当于expandableListView的 child
	BitmapUtils bitmapUtils;
	private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	private ImageLoader imageLoader;
	private ImageLoadingListener animateFirstListener;
	private DisplayImageOptions options;

	public NourishmentFood_PhlvAdapter(Context context, List<String> section,
			List<List<com.example.nutrition.nourishment.bean.NourishmentFood>> item,
			ImageLoader imageLoader) {
		super();
		this.context = context;
		this.section = section;
		this.item = item;
		this.imageLoader = imageLoader;
		bitmapUtils = new BitmapUtils(context,path);

		/*
		 * 是否缓存与缓存设置
		 */
		options = new DisplayImageOptions.Builder()           //加载失败时的图片
		.cacheInMemory(true)                               //启用内存缓存
		.cacheOnDisk(true)                                 //启用外存缓存
		.considerExifParams(true)                         //启用EXIF和JPEG图像格式
		.displayer(new RoundedBitmapDisplayer(10))         //设置显示风格这里是圆角矩形
		.build();
		//imageloader监听动画
		animateFirstListener = new AnimateFirstDisplayListener();
	}

	@Override
	public Object getItem(int section, int position) {
		return item.get(section).get(position);
	}

	@Override
	public long getItemId(int section, int position) {
		return position;
	}

	@Override
	public int getSectionCount() {
		return section.size();
	}

	@Override
	public int getCountForSection(int section) {
		return item.get(section).size();
	}

	@Override
	public View getItemView(int section, int position, View convertView,
			ViewGroup parent) {
		NourishmentFood itemData = item.get(section).get(position);
		View view;
		if(convertView == null){
			view = View.inflate(context, R.layout.nourishment_list_item, null);
		}else{
			view = convertView;
		}
		tv_item = (TextView) view.findViewById(R.id.nourishment_list_item_food_name);
		sale_num = (TextView) view.findViewById(R.id.nourishment_list_item_sales_volume);
		food_img = (ImageView)view.findViewById(R.id.nourishment_list_item_img);
		price = (TextView) view.findViewById(R.id.nourishment_list_item_price);
		incro = (TextView) view.findViewById(R.id.nourishment_list_item_incro);
		sale_num.setText("销售："+String.valueOf(itemData.getSales_volume())+"份");
		String querypath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+itemData.getFood_name()+".0";
		File file = new File(querypath);

		if(file.exists()){
//			bitmapUtils.display(food_img, querypath);
			imageLoader.displayImage(querypath, food_img);
		}else{
//			bitmapUtils.display(food_img, "http://cblue.tunnel.mobi/WebShop/nourishmentimages/"+itemData.getImgurl());
			imageLoader.displayImage("http://cblue.tunnel.mobi/WebShop/nourishmentimages/"+itemData.getImgurl(), food_img, options, animateFirstListener);
		}
		price.setText("￥"+String.valueOf(itemData.getFood_price())+"元");
		price.setTextColor(Color.RED);
		incro.setText("简介："+itemData.getFoodintro());
		tv_item.setText(itemData.getFood_name());
		return view;
	}
	private static TextView tv_item,sale_num,price,incro;
	private static ImageView food_img;
	@Override
	public View getSectionHeaderView(int section, View convertView,
			ViewGroup parent) {
		String sectionData = this.section.get(section);
		View view;
		if(convertView == null){
			view = View.inflate(context, R.layout.nourishment_header_item, null);
		}else{
			view = convertView;
		}
		tv_section = (TextView) view.findViewById(R.id.textItem);
		tv_section.setText(sectionData);
		tv_section.setBackgroundColor(Color.GRAY);
		return view;
	}
	private TextView tv_section;

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


