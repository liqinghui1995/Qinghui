package com.example.nutrition.useractivity;

import java.util.List;

import cn.jpush.android.api.JPushInterface;

import com.example.nutrition.R;

import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.utils.FastJsonUtil;

import com.example.nutritionTakeout.MainActivity;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class Setting extends Activity {
	private Context mContext;
	private SharedPreferences sp;
	private SharedPreferences sp1;
	private boolean sw;
	private List<UserBean> ulist;
	
	@ViewInject(R.id.set_set_newsselect)
	private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setting);
		mContext = this;
		//xutils注册
		ViewUtils.inject(this);
		//初始化视图
		initView();
		//获取用户信息
		sp1 = getSharedPreferences("mynewsset", MODE_PRIVATE);
		String json_chuan = sp1.getString("reslut", "");
		if(!"".equals(json_chuan)&&!"登陆/注册".equals(json_chuan)){
			ulist = FastJsonUtil.getList(json_chuan, UserBean.class);
		}
	}
	
	//设置初始化视图
	private void initView() {
		sp = getSharedPreferences("mypushset", MODE_PRIVATE);
		sw = sp.getBoolean("openorclose", true);
		if(sw){
			//图片更改为关闭图片
			img.setImageResource(R.drawable.switch_btn_on);
			img.invalidate();
		}else{
			//图片更改为开启图片
			img.setImageResource(R.drawable.switch_btn_off);
			img.invalidate();
		}
	}

	//退出功能
	@OnClick(R.id.set_set_exit)
	public void exit(View v){
		if(ulist!=null){
			sp1 = getSharedPreferences("mynewsset", MODE_PRIVATE);
			Editor editor = sp1.edit();
			editor.putString("reslut","登陆/注册");
			editor.commit();
			Intent intent = new Intent(Setting.this,MainActivity.class);
			startActivity(intent);
		}
	}
	
	//设置打分功能
	@OnClick(R.id.set_set_score)
	public void score(View v){
		
	}
	
	//设置app版本更新
	@OnClick(R.id.set_set_version)
	public void version(View v){
		Toast.makeText(mContext, "当前已是最新版本", 1).show();
	}
	
	//设置推送消息查询功能
	@OnClick(R.id.set_set_news)
	public void news(View v){
		Toast.makeText(mContext, "推送消息查询！！！", 1).show();
	}
	
	//设置电话资讯功能
	@OnClick(R.id.set_set_phone)
	public void phone(View v){
		//用intent启动拨打电话  
		Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"13120311915"));  
		startActivity(intent);
	}
	
	//设置推送消息开关
	@OnClick(R.id.set_set_newsselect)
	public void newsset(View v){
		sw = sp.getBoolean("openorclose", true);
		if(sw){
			//关闭推送功能
			JPushInterface.stopPush(getApplicationContext());
			//图片更改为关闭图片
			img.setImageResource(R.drawable.switch_btn_off);
			img.invalidate();
			//img.setBackgroundResource(R.drawable.switch_btn_on);
			Toast.makeText(mContext, "推送关闭", 1).show();
			//将推送开关信息保存
			Editor editor = sp.edit();
			editor.putBoolean("openorclose", false);
			editor.commit();
		}else{
			//开启推送功能
			JPushInterface.resumePush(getApplicationContext());
			//图片更改为开启图片
			img.setImageResource(R.drawable.switch_btn_on);
			img.invalidate();
			//img.setBackgroundResource(R.drawable.switch_btn_off);
			Toast.makeText(mContext, "推送开启", 1).show();
			//将推送开关信息保存
			Editor editor = sp.edit();
			editor.putBoolean("openorclose", true);
			editor.commit();
		}
	}

	//设置返回功能
	@OnClick(R.id.set_set_imgback)
	public void back(View v){
		finish();
	}

}
