package com.example.nutrition.useractivity;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.fragment.MineFragment;
import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.utils.FastJsonUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class Share extends Activity {
	private PopupWindow popup;
	private List<UserBean> ulist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_share);
		//xutils注册
		ViewUtils.inject(this);
		//获取用户信息
		SharedPreferences sp = getSharedPreferences("mynewsset", MODE_PRIVATE);
		String json_chuan = sp.getString("reslut", "");
		if(!"".equals(json_chuan)&&!"登陆/注册".equals(json_chuan)){
			ulist = FastJsonUtil.getList(json_chuan, UserBean.class);
		}
		//创建popwindow
		popupwindow();
	}
	
	//设置分享功能
	@OnClick(R.id.set_share_imggift)
	public void gift(View v){
		//以下拉方式显示popwindow
		popup.showAsDropDown(v);
		//将popwindow显示指定位置
		popup.showAtLocation(findViewById(R.id.set_share_imggift),
					Gravity.AXIS_PULL_BEFORE, 0, 0);
	}
	
	//popwindow设置
	private void popupwindow() {
		//获取屏幕宽高
		WindowManager wm = this.getWindowManager();
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
	    
	    //设置popwindow
		View root = this.getLayoutInflater().inflate(R.layout.share_popwindow, null);
		popup = new PopupWindow(root, width, height/3);
		// 首先要设置PopuWindow的背景，而且要在PopuWindow显示之前设置他的背景，不然没有效果。
		popup.setBackgroundDrawable(new BitmapDrawable());
		popup.setOutsideTouchable(true);
		// 外部点击消失
		//获取popupwindow关闭按钮，并实现关闭监听
		root.findViewById(R.id.set_share_pop_img_close).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				popup.dismiss();
			}
		});
	}
	
	//设置返回功能
	@OnClick(R.id.set_share_imgback)
	public void back(View v){
		finish();
	}

}
