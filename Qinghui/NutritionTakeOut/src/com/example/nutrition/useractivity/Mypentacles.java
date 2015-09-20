package com.example.nutrition.useractivity;

import com.example.nutrition.R;
import com.example.nutritionTakeout.MainActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Mypentacles extends Activity {
	private Context mContext;
	private String str;
	
	/*
	 * ��ȡUI���
	 * author:dove
	 */
	@ViewInject(R.id.set_img_ball)
	private ImageView ball;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mypentacles);
		mContext = this;
		//xutilsע��
		ViewUtils.inject(this);
		//��ʼ������
		initAnimal();
	}
	
	/*
	 * ���ó�ʼ������
	 */
	private void initAnimal() {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.one_ball);
		  ball.startAnimation(anim);
		  anim.setAnimationListener(new AnimationListener() {
		   @Override
		   public void onAnimationStart(Animation animation) {
		    // TODO Auto-generated method stub
		   
		   }
		   @Override
		   public void onAnimationRepeat(Animation animation) {
		    // TODO Auto-generated method stub
		   
		   }
		   @Override
		   public void onAnimationEnd(Animation animation) {
			   Animation anim1 = AnimationUtils.loadAnimation(mContext, R.anim.two_ball);
				  ball.startAnimation(anim1);
				  anim1.setAnimationListener(new AnimationListener() {
				   @Override
				   public void onAnimationStart(Animation animation) {
				    // TODO Auto-generated method stub
				   
				   }
				   @Override
				   public void onAnimationRepeat(Animation animation) {
				    // TODO Auto-generated method stub
				   
				   }
				   @Override
				   public void onAnimationEnd(Animation animation) {
					   Animation anim2 = AnimationUtils.loadAnimation(mContext, R.anim.three_ball);
					   ball.startAnimation(anim2);
				   }
				  });
		   }
		  });
	}

	//���÷��ع���
	@OnClick(R.id.set_gift_imgback)
	public void back(View v){
		finish();
	}
	
	//������Ʒվ���빦��
	@OnClick(R.id.set_gift_into)
	public void into(View v){
		Intent intent = new Intent(Mypentacles.this,GiftCenter.class);
		intent.putExtra("json", str);
		startActivity(intent);
	}
}
