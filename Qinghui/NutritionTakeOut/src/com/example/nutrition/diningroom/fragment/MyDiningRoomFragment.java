package com.example.nutrition.diningroom.fragment;

import com.example.nutrition.R;
import com.example.nutrition.fragment.HomePageFragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDiningRoomFragment extends FragmentActivity {
	private TextView collect_dining,order_dining;
	private ImageView goback;
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.my_diningroom);
		initView();
		initfrag();
		setListener();
	}

	//默认frag 初始化为收藏餐厅
	private void initfrag() {
		CollectDiningRoomFragment collect=new CollectDiningRoomFragment();
		FragmentManager fm=getSupportFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		ft.add(R.id.frg_ment,collect);
		ft.commit();
		
	}


	public void initView(){
		//返回图片
		goback=(ImageView) findViewById(R.id.back_img);
		collect_dining=(TextView) findViewById(R.id.collect_dining);
		order_dining=(TextView) findViewById(R.id.order_dining);
	}
	public void setListener(){
		goback.setOnClickListener(l);
		collect_dining.setOnClickListener(l);
		order_dining.setOnClickListener(l);
		
	}
	
		OnClickListener l=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.back_img:
					finish();
					break;
				case R.id.collect_dining:
					CollectDiningRoomFragment collect=new CollectDiningRoomFragment();
					FragmentManager fm=getSupportFragmentManager();
					FragmentTransaction ft=fm.beginTransaction();
					ft.replace(R.id.frg_ment,collect);
					collect_dining.setTextColor(Color.RED);
					order_dining.setTextColor(Color.BLACK);
					ft.commit();
					break;
				case R.id.order_dining:
					OrderPassDiningRoomFragment order=new OrderPassDiningRoomFragment();
					FragmentManager fm2=getSupportFragmentManager();
					FragmentTransaction ft2=fm2.beginTransaction();
					ft2.replace(R.id.frg_ment,order);
					collect_dining.setTextColor(Color.BLACK);
					order_dining.setTextColor(Color.RED);
					ft2.commit();
					break;
				default:
					break;
				}
				
			}
		};
}
