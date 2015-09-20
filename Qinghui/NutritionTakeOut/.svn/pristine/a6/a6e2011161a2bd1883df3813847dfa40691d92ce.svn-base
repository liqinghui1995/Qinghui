package com.example.nutrition.adapter;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.nourishment.bean.NourishmentFood;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageAdapter extends BaseAdapter{
	private List<NourishmentFood> list;
	private Context context;
	BitmapUtils bitmapUtils;
	private ImageLoader imageLoader;
	private ImageLoadingListener animateFirstListener;
	private DisplayImageOptions options;
	private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	
	public HomePageAdapter(List<NourishmentFood> list, Context context , ImageLoader imageLoader) {
		super();
		this.list = list;
		this.context = context;
		this.imageLoader = imageLoader;
		bitmapUtils = new BitmapUtils(context,path);
		
		/*
		 * 是否缓存与缓存设置
		 */
		options = new DisplayImageOptions.Builder()             //加载失败时的图片
        .cacheInMemory(true)                               //启用内存缓存
        .cacheOnDisk(true)                                 //启用外存缓存
        .considerExifParams(true)                         //启用EXIF和JPEG图像格式
        .displayer(new RoundedBitmapDisplayer(90))         //设置显示风格这里是圆角矩形
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
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = View.inflate(context, R.layout.home_page_listview_item, null);
			viewHolder.name = (TextView) convertView.findViewById(R.id.hotfoodname);
			viewHolder.price = (TextView) convertView.findViewById(R.id.hotfoodprice);
			viewHolder.img = (ImageView) convertView.findViewById(R.id.hotfoodimg);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.name.setText(list.get(position).getFood_name());
		viewHolder.price.setText(""+list.get(position).getFood_price());
		String querypath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+list.get(position).getFood_name()+".0";
		File file = new File(querypath);
		if(list.get(position).getImgurl()==null||list.get(position).getImgurl().equals("")){
			viewHolder.img.setImageResource(R.drawable.hot_food_default);
		}else{
			if(file.exists()){
				bitmapUtils.display(viewHolder.img, querypath);
			}else{
//				bitmapUtils.display(viewHolder.img, "http://cblue.tunnel.mobi/WebShop/nourishmentimages/"+list.get(position).getImgurl());
				imageLoader.displayImage("http://cblue.tunnel.mobi/WebShop/nourishmentimages/"+list.get(position).getImgurl(), viewHolder.img, options, (ImageLoadingListener) imageLoader);
				bitmapUtils.configDiskCacheFileNameGenerator(new FileNameGenerator() {
					@Override
					public String generate(String arg0) {
						return list.get(position).getFood_name();
					}
				});
			}
		}
		return convertView;
	}
	static class ViewHolder{
		TextView name;
		ImageView img;
		TextView price;
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
