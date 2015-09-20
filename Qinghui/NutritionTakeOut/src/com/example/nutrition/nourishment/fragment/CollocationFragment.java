package com.example.nutrition.nourishment.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.cart.ShoppingCart;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBHelper;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.fragment.BadgeView;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.example.nutrition.nourishment.adapter.NourishmentFood_ListViewLeftAdapter;
import com.example.nutrition.nourishment.adapter.NourishmentFood_PhlvAdapter;
import com.example.nutrition.nourishment.bean.NourishmentFood;
import com.example.nutrition.nourishment.bean.NourishmentPar;
import com.example.nutrition.utils.NetworkUtil;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class CollocationFragment extends Fragment {
	List<NourishmentFood> list;
	private ListView listView; //左侧的listview
	private PinnedHeaderListView headerListView;
	private NourishmentFood_PhlvAdapter phlvAdapter;
	private List<String> section;
	private List<List<NourishmentFood>> item;
	private boolean isScroll = true;
	private List<String> food;
	View view;
	private ImageView shopCart;// 购物车
	private ViewGroup anim_mask_layout;// 动画层
	private ImageView ball;// 小圆点
	private int buyNum = 0;// 购买数量
	private BadgeView buyNumView;// 购物车上的数量标签
	private ImageView imageView;
	private ImageLoader imageLoader;
	String name = null;
	String price = null;
	CarDBUtils dbCarUtils;
	SQLiteDatabase db;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_collocation, null);
		CarDBHelper helper = new CarDBHelper(getActivity());
		db = helper.getWritableDatabase();
		dbCarUtils = new CarDBUtils(db);
		list = new ArrayList<NourishmentFood>();
		food = new ArrayList<String>();
		CarDBHelper dbHelper = new CarDBHelper(getActivity());
		shopCart = (ImageView) view.findViewById(R.id.nourishment_shopping_car_car);
		init();
		buyNumView = new BadgeView(getActivity(), shopCart);
		buyNumView.setTextColor(Color.WHITE);
		buyNumView.setBackgroundColor(Color.RED);
		buyNumView.setTextSize(12);
		//初始化ImageLoader
		initImageLoader();
		//实例化ImageLoader
		imageLoader = ImageLoader.getInstance();
		//初始化数据
		initData();
		//设置ListView快速滑动时停止ImageLoader加载
		/*第一个参数就是我们的图片加载对象ImageLoader
				第二个是控制是否在滑动过程中暂停加载图片，如果需要暂停传true就行了
				第三个参数控制猛的滑动界面的时候图片是否加载*/
		//		listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));  
		return view;
	}
	/*
	 * 设置初始化ImageLoader
	 */
	private void initImageLoader() {
		//创建默认的ImageLoader配置参数  
		//      ImageLoaderConfiguration configuration = ImageLoaderConfiguration  
		//                .createDefault(mContext);
		//      //Initialize ImageLoader with configuration.  
		//      ImageLoader.getInstance().init(configuration); 

		File cacheDir =StorageUtils.getOwnCacheDirectory(getActivity(), "imageloader/Cache");
		@SuppressWarnings("deprecation")
		ImageLoaderConfiguration config = new ImageLoaderConfiguration
		.Builder(getActivity()) 
		.memoryCacheExtraOptions(480, 800) // maxwidth, max height，即保存的每个缓存文件的最大长宽 
		.threadPoolSize(3)//线程池内加载的数量 
		.threadPriority(Thread.NORM_PRIORITY -2) 
		.denyCacheImageMultipleSizesInMemory() 
		.memoryCache(new UsingFreqLimitedMemoryCache(2* 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现 
		.memoryCacheSize(2 * 1024 * 1024)   
		.discCacheSize(50 * 1024 * 1024)
		.discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密 
		.tasksProcessingOrder(QueueProcessingType.LIFO) 
		.discCacheFileCount(20) //缓存的文件数量 
		.discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径 
		.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) 
		.imageDownloader(new BaseImageDownloader(getActivity(),5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间 
		.writeDebugLogs() // Remove for releaseapp 
		.build();//开始构建 
		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		imageLoader.clearMemoryCache();
		imageLoader.clearDiskCache();
	}

	private void test() {
		shopCart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ShoppingCart.class);
				intent.putExtra("name", name);
				intent.putExtra("price", price);
				Shop saveShop = new Shop();
				saveShop.setName(name);
				saveShop.setPrice((int)Double.parseDouble(price));
				saveShop.setNumber(1);


				dbCarUtils.save(saveShop);

				startActivity(intent);
				Toast.makeText(getActivity(), name+price+"___________IIIIIIIII",1).show();
			}
		});
		headerListView = (PinnedHeaderListView) view.findViewById(R.id.nourishment_pinnedListView);
		listView=(ListView) view.findViewById(R.id.nourishment_left_listview);
		NourishmentFood_ListViewLeftAdapter adapter=new NourishmentFood_ListViewLeftAdapter(getActivity(),food);
		listView.setAdapter(adapter);

		initData();
		phlvAdapter=new NourishmentFood_PhlvAdapter(getActivity(), section, item , imageLoader);
		headerListView.setAdapter(phlvAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				isScroll = false;
				for (int i = 0; i < listView.getChildCount(); i++) {
					if (i == position) {
						listView.getChildAt(i).setBackgroundColor(
								Color.rgb(255, 255, 255));
					} else {
						listView.getChildAt(i).setBackgroundColor(
								Color.TRANSPARENT);
					}
				}

				int rightSection = 0;
				for (int i = 0; i < position; i++) {
					rightSection += phlvAdapter.getCountForSection(i) + 1;
				}

				headerListView.setSelection(rightSection);
			}
		});
		headerListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				name = list.get(position-1).getFood_name();
				price = String.valueOf(list.get(position-1).getFood_price());
				int[] startLocation = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
				view.getLocationInWindow(startLocation);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
				ball = new ImageView(getActivity());// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
				ball.setImageResource(R.drawable.sign);// 设置buyImg的图片
				setAnim(ball, startLocation);// 开始执行动画
			}
		});
		headerListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (isScroll) {
					for (int i = 0; i < listView.getChildCount(); i++) {

						if (i == phlvAdapter
								.getSectionForPosition(firstVisibleItem)) {
							listView.getChildAt(i).setBackgroundColor(
									Color.rgb(255, 255, 255));
						} else {
							listView.getChildAt(i).setBackgroundColor(
									Color.TRANSPARENT);

						}
					}

				} else {
					isScroll = true;
				}
			}
		});
	}
	private void initData() {
		section = new ArrayList<String>();
		item = new ArrayList<List<NourishmentFood>>();
		food.add("搭配营养食物");
		food.add("主食");
		food.add("饮料");
		for (int i = 0; i <food.size(); i++) {
			section.add(food.get(i));
			item.add(list);
		}
	}	

	private void init() {
		new Thread(){
			public void run() {
				try {
					String url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=6";
					String data = NetworkUtil.getStringFromUrl(url);
					handler.sendMessage(handler.obtainMessage(1,data));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	}
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what == 1){
				list = new ArrayList<NourishmentFood>();
				String json = (String) msg.obj;
				Log.e("666", "json "+json.toString());
				Gson gson = new Gson();
				Log.e("666", "log is "+json.toString());
				NourishmentPar p =  gson.fromJson(json, NourishmentPar.class);
				Log.w("tag", p.getResultlist().toString());
				list = p.getResultlist();
				test();
			}
		};  
	};





	private ViewGroup createAnimLayout() {
		ViewGroup rootView = (ViewGroup) getActivity().getWindow()
				.getDecorView();
		LinearLayout animLayout = new LinearLayout(getActivity());
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		animLayout.setLayoutParams(lp);
		animLayout.setId(Integer.MAX_VALUE);
		animLayout.setBackgroundResource(android.R.color.transparent);
		rootView.addView(animLayout);
		return animLayout;
	}

	private View addViewToAnimLayout(final ViewGroup parent, final View view,
			int[] location) {
		int x = location[0];
		int y = location[1];
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.leftMargin = x;
		lp.topMargin = y;
		view.setLayoutParams(lp);
		return view;
	}

	private void setAnim(final View v, int[] startLocation) {
		//View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.activity_nourishment, null);



		anim_mask_layout = null;
		anim_mask_layout = createAnimLayout();
		anim_mask_layout.addView(v);// 把动画小球添加到动画层
		final View view = addViewToAnimLayout(anim_mask_layout, v,
				startLocation);
		int[] endLocation = new int[2];// 存储动画结束位置的X、Y坐标

		shopCart.getLocationInWindow(endLocation);// shopCart是那个购物车

		// 计算位移
		int endX = 0 - startLocation[0] + 40;// 动画位移的X坐标
		int endY = endLocation[1] - startLocation[1];// 动画位移的y坐标

		TranslateAnimation translateAnimationX = new TranslateAnimation(0,
				endX, 0, 0);
		translateAnimationX.setInterpolator(new LinearInterpolator());
		translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
		translateAnimationX.setFillAfter(true);

		TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
				0, endY);
		translateAnimationY.setInterpolator(new AccelerateInterpolator());
		translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
		translateAnimationX.setFillAfter(true);

		AnimationSet set = new AnimationSet(false);
		set.setFillAfter(false);
		set.addAnimation(translateAnimationY);
		set.addAnimation(translateAnimationX);
		set.setDuration(800);// 动画的执行时间
		view.startAnimation(set);
		// 动画监听事件
		set.setAnimationListener(new AnimationListener() {
			// 动画的开始
			@Override
			public void onAnimationStart(Animation animation) {
				v.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			// 动画的结束
			@Override
			public void onAnimationEnd(Animation animation) {
				v.setVisibility(View.GONE);
				buyNum++;// 让购买数量加1
				buyNumView.setText(buyNum + "");//
				buyNumView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
				buyNumView.show();
			}
		});

	}



}