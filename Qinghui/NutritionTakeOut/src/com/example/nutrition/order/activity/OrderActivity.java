package com.example.nutrition.order.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.base.BaseActivity;
import com.example.nutrition.dinnerinfo.adapter.FragmentAdpter;
import com.example.nutrition.dinnerinfo.fragment.InfoFragment;
import com.example.nutrition.dinnerinfo.fragment.MenuFragment;
import com.example.nutrition.fragment.OrderFragment;
import com.example.nutrition.order.fragments.LineitemFragment;
import com.example.nutrition.order.fragments.OrdertracingFragment;
import com.example.nutritionTakeout.MainActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends FragmentActivity implements OnClickListener{

	private Button order_tracing , orderdetail;
	private ViewPager order_viewPager;
	private List<Fragment> list;
	private FragmentAdpter adpter;
	private ImageView silde , phone , orderback;
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		context = this;
		order_tracing = (Button) findViewById(R.id.order_tracing);
		orderdetail = (Button) findViewById(R.id.orderdetail);
		silde = (ImageView) findViewById(R.id.silde);
		phone = (ImageView) findViewById(R.id.phone);
		orderback = (ImageView) findViewById(R.id.orderback);
		orderback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(context, "您点击额返回按钮", 1).show();
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);
			}
		});
		order_tracing.setOnClickListener(this);
		orderdetail.setOnClickListener(this);
		phone.setOnClickListener(this);
		order_tracing.setBackgroundColor(getResources().getColor(R.color.moccasin));
		orderdetail.setBackgroundColor(getResources().getColor(R.color.honeydew));
		order_viewPager = (ViewPager) findViewById(R.id.order_viewpager);
		initFragment();
		initImageView();

		order_viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 初始化动画
	 */
	private void initImageView() {
		silde = (ImageView) findViewById(R.id.silde);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.item)
				.getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = (screenW / 2 - bmpW) / 2;// 计算偏移量
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		silde.setImageMatrix(matrix);// 设置动画初始位置

	}

	private void initFragment() {
		// TODO Auto-generated method stub
		list=new ArrayList<Fragment>();
		OrdertracingFragment ordertracingFragment=new OrdertracingFragment();
		LineitemFragment lineitemFragment=new LineitemFragment();
		list.add(ordertracingFragment);
		list.add(lineitemFragment);

		adpter=new FragmentAdpter(getSupportFragmentManager(),list);
		if(adpter!=null){
			order_viewPager.setAdapter(adpter);
		}

		order_viewPager.setOnPageChangeListener(new OnPageChangeListener() {

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
		case R.id.order_tracing:
			order_viewPager.setCurrentItem(0);
			orderdetail.setBackgroundColor(getResources().getColor(R.color.honeydew));
			order_tracing.setBackgroundColor(getResources().getColor(R.color.moccasin));
			break;

		case R.id.orderdetail:
			order_viewPager.setCurrentItem(1);
			orderdetail.setBackgroundColor(getResources().getColor(R.color.moccasin));
			order_tracing.setBackgroundColor(getResources().getColor(R.color.honeydew));
			break;

		case R.id.shopping_car:
			Toast.makeText(context, "您点击了购物车图标", 1).show();
			break;

		case R.id.phone:
//			Toast.makeText(context, "您点击了电话", 1).show();
			AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
			builder.setTitle("请选择一个电话号码");
			final String[] phones = {"010-57180503" , "18911980040"};
			builder.setItems(phones, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(context, "选择的号码为：" +phones[which], 1).show();

					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phones[which]));
					startActivity(intent);
				}
			});
			builder.show();
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
					order_tracing.setBackgroundColor(getResources().getColor(R.color.moccasin));
					orderdetail.setBackgroundColor(getResources().getColor(R.color.honeydew));
				} 
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, one, 0, 0);
					order_tracing.setBackgroundColor(getResources().getColor(R.color.honeydew));
					orderdetail.setBackgroundColor(getResources().getColor(R.color.moccasin));
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);// True:图片停在动画结束位置
			animation.setDuration(300);
			silde.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}

		@Override
		public void onPageScrollStateChanged(int arg0) {}
	}
}
