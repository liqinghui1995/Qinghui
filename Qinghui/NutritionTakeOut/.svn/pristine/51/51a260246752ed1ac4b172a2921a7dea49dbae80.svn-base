package com.example.nutrition.nourishment.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.base.BaseActivity;
import com.example.nutrition.nourishment.fragment.CollocationFragment;
import com.example.nutrition.nourishment.fragment.RegisenFragment;
import com.example.nutrition.nourishment.fragment.SeasonFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class NourishmentActivity extends BaseActivity {
	@ViewInject(R.id.nutritionFood_linearlayout)
	private LinearLayout layout;
	
	FragmentManager fm = getSupportFragmentManager();
	CollocationFragment collocationFragment = new CollocationFragment();
	SeasonFragment seasonFragment = new SeasonFragment();
	RegisenFragment regisenFragment = new RegisenFragment();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_nourishment);
		ViewUtils.inject(this);
		initView();
	}

	public void initView() {
     	FragmentTransaction transaction = fm.beginTransaction();
     	transaction.add(R.id.nutritionFood_linearlayout, collocationFragment);
     	transaction.add(R.id.nutritionFood_linearlayout, seasonFragment);
     	transaction.add(R.id.nutritionFood_linearlayout, regisenFragment);
     	transaction.show(collocationFragment);
     	transaction.hide(seasonFragment);
     	transaction.hide(regisenFragment);
     	transaction.commit();
	}

	@OnClick(R.id.collocation_recommend)
	public void collocation(View view){
		Toast.makeText(getApplicationContext(), "aaa", Toast.LENGTH_SHORT).show();
		FragmentTransaction transaction = fm.beginTransaction();
    	transaction.show(collocationFragment);
    	transaction.hide(seasonFragment);
    	transaction.hide(regisenFragment);
    	transaction.commit();
	}
	@OnClick(R.id.season_recommend)
	public void collocation1(View view){
		Toast.makeText(getApplicationContext(), "bbb", Toast.LENGTH_SHORT).show();
		FragmentTransaction transaction = fm.beginTransaction();
    	transaction.show(seasonFragment);
    	transaction.hide(collocationFragment);
    	transaction.hide(regisenFragment);
    	transaction.commit();
	}
	@OnClick(R.id.keepHealth_recommend)
	public void Regimen(View view){
		Toast.makeText(getApplicationContext(), "mmm", Toast.LENGTH_SHORT).show();
		FragmentTransaction transaction = fm.beginTransaction();
    	transaction.show(regisenFragment);
    	transaction.hide(collocationFragment);
    	transaction.hide(seasonFragment);
    	transaction.commit();
	}
	@OnClick(R.id.season_recommend)
	public void Season(View view){
		FragmentTransaction transaction = fm.beginTransaction();
    	transaction.show(regisenFragment);
    	transaction.hide(collocationFragment);
    	transaction.hide(regisenFragment);
    	transaction.commit();
	}
	@OnClick(R.id.nutritionFood_img)
	public void img(View view){
		finish();
	}
}
