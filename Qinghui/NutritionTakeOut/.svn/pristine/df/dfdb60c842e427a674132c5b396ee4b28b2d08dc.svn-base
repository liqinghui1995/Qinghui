package com.example.nutritionTakeout;

import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.location.Poi;
import com.example.nutrition.R;
import com.example.nutrition.fragment.HomePageFragment;
import com.example.nutrition.fragment.MineFragment;
import com.example.nutrition.fragment.OrderFragment;
import com.example.nutrition.user.vo.HotfoodVo;
import com.example.nutrition.utils.FastJsonUtil;
import com.example.nutrition.utils.NetworkUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends FragmentActivity {
	@ViewInject(R.id.homeimg)
	private ImageView homeimg;
	@ViewInject(R.id.orderimg)
	private ImageView orderImg;
	@ViewInject(R.id.mineimg)
	private ImageView mineImg;
	@ViewInject(R.id.hometv)
	private TextView hometv;
	@ViewInject(R.id.ordertv)
	private TextView ordertv;
	@ViewInject(R.id.minetv)
	private TextView minetv;
	@ViewInject(R.id.mine)
	private LinearLayout mine;
	@ViewInject(R.id.order)
	private LinearLayout order;
	@ViewInject(R.id.home)
	private LinearLayout home;
	@ViewInject(R.id.titletv)
	private TextView titletv;
	private String locationStr = "正在进行定位";
	private int num;
	String district = null;



	private Button btn_net;
	private NetBroadcastReceiver mNetBroadcastReceiver = new NetBroadcastReceiver();
	private IntentFilter mIntentFilter = new IntentFilter();




	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();
	FragmentManager fm = getSupportFragmentManager();
	HomePageFragment homePageFragment = new HomePageFragment(MainActivity.this);
	MineFragment mineFragment = new MineFragment();
	OrderFragment orderFragment = new OrderFragment();
	HomePageFragment homefr = null;
	private Context context;
	private SharedPreferences share;
	private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fist_page_activity_main);
		btn_net = (Button)findViewById(R.id.net_btn);



		net();

		share = getSharedPreferences("location", MODE_PRIVATE);
		editor = share.edit();
		//极光推送初始化
		//        JPushInterface.setDebugMode(true);
		//        JPushInterface.init(this);
		//xutils注册
		ViewUtils.inject(this);
		context = this;
		mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
		mLocationClient.registerLocationListener( myListener );    //注册监听函数
		mLocationClient.start();
		initView();
		initLocation();
		getIntent().getStringExtra("reslut_url");
		getIntent().getStringExtra("reslut_zhuce_url");



		Intent intent=getIntent();
		int numb=intent.getIntExtra("namess",0);
		Toast.makeText(MainActivity.this, numb+"---------》》》》》",10).show();
		if (numb==1) {
			orderImg.setImageResource(R.drawable.ic_tab_order_p);
			ordertv.setTextColor(Color.RED);
			homeimg.setImageResource(R.drawable.ic_tab_home_n);
			hometv.setTextColor(Color.BLACK);
			mineImg.setImageResource(R.drawable.ic_tab_mine_n);
			minetv.setTextColor(Color.BLACK);
			FragmentTransaction transaction = fm.beginTransaction();
			transaction.show(orderFragment);
			transaction.hide(homePageFragment);
			transaction.hide(mineFragment);
			//          	if(homefr!=null){
				//          		transaction.hide(homefr);
				//          	}
			transaction.commit();
		}else{
			Toast.makeText(MainActivity.this, "aaaaaaa+++++",1).show();
		}

	}


	/**
	 * 网络连接设置
	 */
	private void net() {

		btn_net.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(NetTools.isConnect(MainActivity.this)){
					Toast.makeText(MainActivity.this, "网络连接了", 1).show();
					if(NetTools.wifiConnect(MainActivity.this)){
						Toast.makeText(MainActivity.this,"wifi连接了",10).show();
					}
					if(NetTools.gprsConnect(MainActivity.this)){
						Toast.makeText(MainActivity.this, "手机网络连接了", 10).show();
					}

				}else{
					Toast.makeText(MainActivity.this, "网络不可用", 1).show();
					settingNet(MainActivity.this);
				}

			}

			private void settingNet(Context context){

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("网络设置");
				builder.setMessage("你是否需要设置网络？");
				builder.setPositiveButton("同意", new Dialog.OnClickListener() {
					Intent intent ;
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//SDK>10以上使用一种方法
						if(android.os.Build.VERSION.SDK_INT>10){
							intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						}else{
							intent = new Intent();
							ComponentName componentName = new ComponentName("com.android.setttings","com.android.settings.WirelessSetting");
							intent.setComponent(componentName);
						}
						startActivityForResult(intent, 0);

					}
				});
				builder.setNegativeButton("拒绝", new Dialog.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}});
				builder.show();

			}
		});
		//注册网络变化的广播
		mIntentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(mNetBroadcastReceiver, mIntentFilter);


















	}
	@OnClick(R.id.titletv)
	public void titletv(View v){
//		Toast.makeText(context, "aaaaa", Toast.LENGTH_SHORT).show();
	}
	/**
	 * 初始化控件
	 */
	public void initView() {
		titletv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(context, "a", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(MainActivity.this,SearchActivity.class));
			}
		});
		//    	titletv.setText(locationStr);
		homeimg.setImageResource(R.drawable.ic_tab_home_p);
		hometv.setTextColor(Color.RED);
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.add(R.id.frame, homePageFragment);
		transaction.add(R.id.frame, mineFragment);
		transaction.add(R.id.frame, orderFragment);
		transaction.hide(mineFragment);
		transaction.hide(orderFragment);
		transaction.commit();

	}
	private void initLocation(){
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
		int span=1000;
		option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
		option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);//可选，默认false,设置是否使用gps
		option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
		option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
		option.setIgnoreKillProcess(false);//可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
		option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
		option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
		mLocationClient.setLocOption(option);
	}
	public void initDate(final String dis) {
		if(dis!=null&&!dis.equals("")){
			new Thread(){
				public void run() {
					String json = NetworkUtil.getStringFromUrl("http://cblue.tunnel.mobi/WebShop/homehotfood?address="+dis);
//					Log.i("TAG", json);
					HotfoodVo hotfoodVo = FastJsonUtil.json2Object(json, HotfoodVo.class);
					handler.sendMessage(handler.obtainMessage(0x123, hotfoodVo));
				};
			}.start();
		}
	}
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what == 0x123){
				HotfoodVo hotfoodVo = (HotfoodVo) msg.obj;
				if(hotfoodVo.getFoodList().size()==0){
					Toast.makeText(context, "没有附近美食", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(context, "有附近美食", Toast.LENGTH_SHORT).show();
					homefr = new HomePageFragment(context);
					homefr.setHotfood(hotfoodVo);
					FragmentTransaction transaction = fm.beginTransaction();
					transaction.add(R.id.frame, homefr);
					//			     	transaction.add(R.id.frame, mineFragment);
					//			     	transaction.add(R.id.frame, orderFragment);
					transaction.hide(homePageFragment);
					transaction.hide(mineFragment);
					transaction.hide(orderFragment);
					transaction.commit();
				}

			}
		};
	};
	/**
	 * 切换到我的Fragment中
	 * @param v
	 */
	@OnClick(R.id.mine)
	public void mineOnclick(View v){
		titletv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//    			startActivity(new Intent(MainActivity.this,SearchActivity.class));
			}
		});
		String result = getIntent().getStringExtra("reslut_url");
//		Log.i("STR", "Main:"+result);
		titletv.setText("个人中心");
		mineImg.setImageResource(R.drawable.ic_tab_mine_p);
		minetv.setTextColor(Color.RED);
		homeimg.setImageResource(R.drawable.ic_tab_home_n);
		hometv.setTextColor(Color.BLACK);
		orderImg.setImageResource(R.drawable.ic_tab_order_n);
		ordertv.setTextColor(Color.BLACK);
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.show(mineFragment);
		transaction.hide(homePageFragment);
		if(homefr!=null){
			transaction.hide(homefr);
		}
		transaction.hide(orderFragment);
		transaction.commit();
	}
	/**
	 * 切换到订单Fragment中
	 * @param v
	 */
	@OnClick(R.id.order)
	public void orderOnclick(View v){
		titletv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//    			startActivity(new Intent(MainActivity.this,SearchActivity.class));
			}
		});
		titletv.setText("我的订单");
		orderImg.setImageResource(R.drawable.ic_tab_order_p);
		ordertv.setTextColor(Color.RED);
		homeimg.setImageResource(R.drawable.ic_tab_home_n);
		hometv.setTextColor(Color.BLACK);
		mineImg.setImageResource(R.drawable.ic_tab_mine_n);
		minetv.setTextColor(Color.BLACK);
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.show(orderFragment);
		transaction.hide(homePageFragment);
		transaction.hide(mineFragment);
		if(homefr!=null){
			transaction.hide(homefr);
		}
		transaction.commit();
	}
	/**
	 * 首页Fragment中
	 * @param v
	 */
	@OnClick(R.id.home)
	public void homeOnclick(View v){
		titletv.setText(locationStr);
		titletv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				intent.putExtra("location", district);
				startActivityForResult(intent, 1001);
			}
		});
		homeimg.setImageResource(R.drawable.ic_tab_home_p);
		hometv.setTextColor(Color.RED);
		orderImg.setImageResource(R.drawable.ic_tab_order_n);
		ordertv.setTextColor(Color.BLACK);
		mineImg.setImageResource(R.drawable.ic_tab_mine_n);
		minetv.setTextColor(Color.BLACK);
		FragmentTransaction transaction = fm.beginTransaction();
		if(homefr!=null){
			transaction.show(homefr);
		}else{
			transaction.show(homePageFragment);
		}
		transaction.hide(orderFragment);
		transaction.hide(mineFragment);
		transaction.commit();
	}
	@Override
	protected void onActivityResult(int requst, int result, Intent Data) {
		super.onActivityResult(requst, result, Data);
		if(requst == 1001 && result == 1002){
			String location = Data.getStringExtra("location");
			titletv.setText(location);
			initDate(district);
		}
		//    	if(){}
	}
	private int netnum;
	private class MyLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			//Receive Location
			StringBuffer sb = new StringBuffer(256);
			if (location.getLocType() == BDLocation.TypeGpsLocation){// GPS定位结果
				locationStr = location.getDistrict()+location.getStreet();
				//                sb.append("gps定位成功");
				district = location.getDistrict();
				if(num ==0){
					titletv.setText(locationStr);
					editor.putBoolean("location", true);
					editor.commit();
					initDate(district);
					num++;
				}

				if(homePageFragment.isVisible()){

					titletv.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent intent = new Intent(MainActivity.this,SearchActivity.class);
							intent.putExtra("location", locationStr);
							startActivityForResult(intent, 1001);
							//        					startActivity(new Intent(MainActivity.this,SearchActivity.class));
						}
					});
				}
				//                titletv.setText(locationStr);
			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation){// 网络定位结果
				locationStr = location.getDistrict()+location.getStreet();
				sb.append("地址"+location.getDistrict()+location.getStreet());
				//                sb.append("网络定位成功");
				district = location.getDistrict();
				if(netnum ==0){
					titletv.setText(locationStr);
					editor.putBoolean("location", true);
					editor.commit();
					initDate(district);
					netnum++;
				}
				if(homePageFragment.isVisible()){

					titletv.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent intent = new Intent(MainActivity.this,SearchActivity.class);
							intent.putExtra("location", locationStr);
							startActivityForResult(intent, 1001);
						}
					});
				}
				//                titletv.setText(locationStr);
			} else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
				sb.append("\ndescribe : ");
				sb.append("离线定位成功，离线定位结果也是有效的");
			} else if (location.getLocType() == BDLocation.TypeServerError) {
				sb.append("\ndescribe : ");
				sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
			} else if (location.getLocType() == BDLocation.TypeNetWorkException) {
				sb.append("\ndescribe : ");
				sb.append("网络不同导致定位失败，请检查网络是否通畅");
			} else if (location.getLocType() == BDLocation.TypeCriteriaException) {
				sb.append("\ndescribe : ");
				sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
			}
			sb.append("\nlocationdescribe : ");
			sb.append(location.getLocationDescribe());// 位置语义化信息
			List<Poi> list = location.getPoiList();// POI数据
			if (list != null) {
				sb.append("\npoilist size = : ");
				sb.append(list.size());
				for (Poi p : list) {
					sb.append("\npoi= : ");
					sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
				}
			}
			//            Log.i("BaiduLocationApiDem", sb.toString());
		}
	}



	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(mNetBroadcastReceiver);
	}
	/*
	 * 极光推送
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		//     JPushInterface.onResume(this);
		super.onResume();
	}

	/*
	 * 极光推送
	 * @see android.support.v4.app.FragmentActivity#onResume()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		//     JPushInterface.onPause(this);
		super.onPause();
	}
}

