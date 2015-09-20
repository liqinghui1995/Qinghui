package com.example.nutrition.useractivity;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.adapter.GiftsAdapter;
import com.example.nutrition.diningroom.vo.Gifts;
import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.utils.FastJsonUtil;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GiftCenter extends Activity {
	private final String strUrl = "http://cblue.tunnel.mobi/WebShop/usersservlet?method=gift";
	private List<Gifts> list;
	private Context mContext;
	private GiftsAdapter adapter;
	private List<UserBean> ulist;
	
	/*
	 * 获得UI组件
	 * author:dove
	 */
	@ViewInject(R.id.set_giftcenter_listview)
	private ListView listView;
	@ViewInject(R.id.set_giftcenter_mystarts)
	private TextView mystarts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_gift_center);
		mContext = this;
		//xutils注册
		ViewUtils.inject(this);
		//获取用户信息
		SharedPreferences sp = getSharedPreferences("mynewsset",MODE_PRIVATE);
		String json_chuan = sp.getString("reslut", "");
		if(!"".equals(json_chuan)&&!"登陆/注册".equals(json_chuan)){
			ulist = FastJsonUtil.getList(json_chuan, UserBean.class);
		}
		//初始化视图
		initView();
		//初始化数据
		initData();
	}
	
	/*
	 * 设置初始化数据
	 */
	private void initData() {
		list = new ArrayList<Gifts>();
		HttpUtils hu = new HttpUtils();
		hu.send(HttpMethod.GET, strUrl, new RequestCallBack<String>() {
			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "联网失败", 1).show();
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "联网成功", 1).show();
				//Log.i("STR", "111"+arg0.result);
				Gson gson = new Gson();
				Gifts[] gifts = gson.fromJson(arg0.result, Gifts[].class);
				for(int i=0;i<gifts.length;i++){
					list.add(gifts[i]);
				}
				//Log.i("STR", "222"+list.toString());
				adapter.notifyDataSetInvalidated();
			}
		});
		if(ulist!=null){
			adapter = new GiftsAdapter(mContext, list,ulist.get(0).getUser_id(),ulist.get(0).getUser_coin());
		}else{
			adapter = new GiftsAdapter(mContext, list,0,0);
		}
		listView.setAdapter(adapter);
	}

	/*
	 * 设置初始化视图
	 * author:dove
	 */
	private void initView() {
		if(ulist!=null){
			mystarts.setText("我的星氪币"+ulist.get(0).getUser_coin()+"个");
		}
	}

	//设置返回功能
	@OnClick(R.id.set_giftcenter_imgback)
	public void back(View v){
		finish();
	}

}
