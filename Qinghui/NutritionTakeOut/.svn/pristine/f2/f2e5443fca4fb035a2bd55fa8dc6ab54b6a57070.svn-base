package com.example.nutrition.dinnerinfo.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.activity.DiningRoomActivity;
import com.example.nutrition.dinnerinfo.adapter.FragmentAdpter;
import com.example.nutrition.dinnerinfo.fragment.InfoFragment;
import com.example.nutrition.dinnerinfo.fragment.MenuFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DinnerInfoActivity extends FragmentActivity implements OnClickListener{

	private ImageView back , slide , shopping_car, collect, find ;
	private TextView dining_name;
	private Button dining_menu , dining_info;
	private ViewPager viewPager;
	private List<Fragment> list;
	private FragmentAdpter adpter;
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度
	private Context context;
	private boolean loadOnce;//保存餐厅是否收藏的状态
	private int id;//餐厅ID

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标签栏
		setContentView(R.layout.activity_dinnerinfo);
		context = this;

		back = (ImageView) findViewById(R.id.back);
		slide = (ImageView) findViewById(R.id.silde);
		dining_name = (TextView) findViewById(R.id.diningname);
		dining_menu = (Button) findViewById(R.id.dining_menu);
		dining_info = (Button) findViewById(R.id.dining_info);
		dining_menu.setOnClickListener(this);
		dining_info.setOnClickListener(this);
		back.setOnClickListener(this);
		dining_menu.setBackgroundColor(getResources().getColor(R.color.moccasin));
		dining_info.setBackgroundColor(getResources().getColor(R.color.honeydew));
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DiningRoomActivity.class);
				startActivity(intent);
			}
		});
		initFragment();
		initImageView();
		collectImage();

		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 初始化动画
	 */
	private void initImageView() {
		slide = (ImageView) findViewById(R.id.silde);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.item)
				.getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = (screenW / 2 - bmpW) / 2;// 计算偏移量
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		slide.setImageMatrix(matrix);// 设置动画初始位置

	}
	/**
	 * 收藏餐厅
	 */
	private void collectImage() {
		collect = (ImageView) findViewById(R.id.collect);
		collect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(loadOnce == false){
					Toast.makeText(context, "餐厅已收藏", Toast.LENGTH_SHORT).show();
					//SharedPreferences保存餐厅的id 
					SharedPreferences preferences=getSharedPreferences("DinnerID",Context.MODE_PRIVATE);
					Editor editor=preferences.edit();
					//得到餐厅的ID
					String dinnerID="餐厅的ID+++++++++++++++++++++++++++++++++++++++++++=";
					editor.putString("id", dinnerID);
					editor.commit();
					//					从SharedPreferences获取数据:
					preferences=getSharedPreferences("DinnerID", Context.MODE_PRIVATE);
					dinnerID=preferences.getString("id", "0");
//					Log.i("Log", dinnerID);
					loadOnce = true;
				}else{
					Toast.makeText(context, "已取消收藏", Toast.LENGTH_SHORT).show();
					loadOnce = false;
				}
			}
		});
	}
	private void initFragment() {
		// TODO Auto-generated method stub
		list=new ArrayList<Fragment>();
		InfoFragment first=new InfoFragment();
		MenuFragment search=new MenuFragment();
		list.add(first);
		list.add(search);

		adpter=new FragmentAdpter(getSupportFragmentManager(),list);
		if(adpter!=null){
			viewPager.setAdapter(adpter);
		}

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {}

			@Override
			public void onPageScrollStateChanged(int arg0) {}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dining_menu:
			viewPager.setCurrentItem(0);
			dining_info.setBackgroundColor(getResources().getColor(R.color.honeydew));
			dining_menu.setBackgroundColor(getResources().getColor(R.color.moccasin));
			break;

		case R.id.dining_info:
			viewPager.setCurrentItem(1);
			dining_info.setBackgroundColor(getResources().getColor(R.color.moccasin));
			dining_menu.setBackgroundColor(getResources().getColor(R.color.honeydew));
			break;

		case R.id.shopping_car:
			Toast.makeText(context, "您点击了购物车图标", 1).show();
			break;
		case R.id.back:
			finish();
			break;
		}
	}


	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
		int two = one * 2;// 页卡1 -> 页卡3 偏移量

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
					dining_menu.setBackgroundColor(getResources().getColor(R.color.moccasin));
					dining_info.setBackgroundColor(getResources().getColor(R.color.honeydew));
				} 
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, one, 0, 0);
					dining_menu.setBackgroundColor(getResources().getColor(R.color.honeydew));
					dining_info.setBackgroundColor(getResources().getColor(R.color.moccasin));
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);// True:图片停在动画结束位置
			animation.setDuration(300);
			slide.startAnimation(animation);
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}
		@Override
		public void onPageScrollStateChanged(int arg0) {}
	}
}



