package com.example.nutrition.useractivity;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.adapter.FragmentAdpter;
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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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

public class LoginMainActivity extends FragmentActivity implements OnClickListener{

	private Button login_bt , login_register_bt;
	private ViewPager m_vp;
	private List<Fragment> fragmentList;
	private FragmentAdpter adpter_my;
	private FragmentLogin mFragmentLogin;
	private FragmentRegister mFragmentRegister;
	private ImageView silde_my , login_img_return;
	private int offset_my = 0;// ¶¯»­Í¼Æ¬Æ«ÒÆÁ¿
	private int currIndex_my = 0;// µ±Ç°Ò³¿¨±àºÅ
	private int bmpWidth;// ¶¯»­Í¼Æ¬¿í¶È
	private Context context_my;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		context_my = this;
		login_bt = (Button) findViewById(R.id.login_bt);
		login_register_bt = (Button) findViewById(R.id.login_register_bt);
		silde_my = (ImageView) findViewById(R.id.silde_my);
		login_img_return = (ImageView) findViewById(R.id.login_img_return);
		login_img_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(context_my, "Äúµã»÷¶î·µ»Ø°´Å¥", 1).show();
				Intent intent_my = new Intent(context_my, MainActivity.class);
				startActivity(intent_my);
			}
		});
		login_bt.setOnClickListener(this);
		login_register_bt.setOnClickListener(this);
		login_bt.setBackgroundColor(getResources().getColor(R.color.moccasin));
		login_register_bt.setBackgroundColor(getResources().getColor(R.color.honeydew));
		m_vp = (ViewPager) findViewById(R.id.viewpager_user);
		mFragmentLogin = new FragmentLogin();
		mFragmentRegister = new FragmentRegister();
		fragmentList = new ArrayList<Fragment>();
		
		initFragment();
		initImageView();

		m_vp.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
	}

	/**
	 * ³õÊ¼»¯¶¯»­
	 */
	private void initImageView() {
		bmpWidth = BitmapFactory.decodeResource(getResources(), R.drawable.item).getWidth();// »ñÈ¡Í¼Æ¬¿í¶È
		DisplayMetrics dm_my = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm_my);
		int screenWidth = dm_my.widthPixels;// »ñÈ¡·Ö±æÂÊ¿í¶È
		offset_my = (screenWidth / 2 - bmpWidth) / 2;// ¼ÆËãÆ«ÒÆÁ¿
		Matrix matrix_my = new Matrix();
		matrix_my.postTranslate(offset_my, 0);
//		silde_my.setImageMatrix(matrix_my);// ÉèÖÃ¶¯»­³õÊ¼Î»ÖÃ

	}

	private void initFragment() {
		// TODO Auto-generated method stub
		
		mFragmentLogin = new FragmentLogin();
		mFragmentRegister = new FragmentRegister();
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(mFragmentLogin);
		fragmentList.add(mFragmentRegister);

		adpter_my=new FragmentAdpter(getSupportFragmentManager(),fragmentList);
		if(adpter_my!=null){
			m_vp.setAdapter(adpter_my);
		}

		m_vp.setOnPageChangeListener(new OnPageChangeListener() {

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
		case R.id.login_bt:
			m_vp.setCurrentItem(0);
			login_register_bt.setBackgroundColor(getResources().getColor(R.color.honeydew));
			login_bt.setBackgroundColor(getResources().getColor(R.color.moccasin));
			break;

		case R.id.login_register_bt:
			m_vp.setCurrentItem(1);
			login_register_bt.setBackgroundColor(getResources().getColor(R.color.moccasin));
			login_bt.setBackgroundColor(getResources().getColor(R.color.honeydew));
			break;

		}
	}


	/**
	 * Ò³¿¨ÇÐ»»¼àÌý
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset_my * 2 + bmpWidth;// Ò³¿¨1 -> Ò³¿¨2 Æ«ÒÆÁ¿
		int two = one * 2;// Ò³¿¨1 -> Ò³¿¨3 Æ«ÒÆÁ¿

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex_my == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
					login_bt.setBackgroundColor(getResources().getColor(R.color.moccasin));
					login_register_bt.setBackgroundColor(getResources().getColor(R.color.honeydew));
				} 
				break;
			case 1:
				if (currIndex_my == 0) {
					animation = new TranslateAnimation(offset_my, one, 0, 0);
					login_bt.setBackgroundColor(getResources().getColor(R.color.honeydew));
					login_register_bt.setBackgroundColor(getResources().getColor(R.color.moccasin));
				}
				break;
			}
			currIndex_my = arg0;
			animation.setFillAfter(true);// True:Í¼Æ¬Í£ÔÚ¶¯»­½áÊøÎ»ÖÃ
			animation.setDuration(300);
			silde_my.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}

		@Override
		public void onPageScrollStateChanged(int arg0) {}
	}
	
	public class MyViewPagerAdapter extends FragmentPagerAdapter{

		public MyViewPagerAdapter(FragmentManager fm) {
			// TODO Auto-generated constructor stub
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragmentList.get(arg0);
		}

		@Override
		public int getCount() {
			return fragmentList.size();
		}
		
	}
	
}
