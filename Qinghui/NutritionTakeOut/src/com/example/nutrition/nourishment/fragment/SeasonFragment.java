package com.example.nutrition.nourishment.fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView;

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
import com.example.nutrition.user.vo.NetHttpUtils;
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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class SeasonFragment extends Fragment {
	List<NourishmentFood> list;
	private ListView listView; //����listview
	private PinnedHeaderListView headerListView;
	private NourishmentFood_PhlvAdapter phlvAdapter;
	private List<String> section;
	private List<List<com.example.nutrition.nourishment.bean.NourishmentFood>> item;
	private boolean isScroll = true;
	private List<String> food;
	String url;
	View view ;
	private ListView left_listView;
	private ImageLoader imageLoader;
	Context context;
	private ArrayList<NourishmentFood> lists;
	LinearLayout nourishment_season_linearLayout;
	private TextView nourishment_text;
	private ImageView shopCart;// ���ﳵ
	private ViewGroup anim_mask_layout;// ������
	private ImageView ball;// СԲ��
	private int buyNum = 0;// ��������
	private BadgeView buyNumView;// ���ﳵ�ϵ�������ǩ
	String name = null;
	String price = null;
	SQLiteDatabase db;
	CarDBUtils dbCarUtils;
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		CarDBHelper helper = new CarDBHelper(getActivity());
		db = helper.getWritableDatabase();
		dbCarUtils = new CarDBUtils(db);
		view = inflater.inflate(R.layout.fragment_season, null);
		food = new ArrayList<String>();
		list = new ArrayList<NourishmentFood>();
		shopCart = (ImageView) view.findViewById(R.id.season_shopping_car_car);	
		buyNumView = new BadgeView(getActivity(), shopCart);
		buyNumView.setTextColor(Color.WHITE);
		buyNumView.setBackgroundColor(Color.RED);
		buyNumView.setTextSize(12);
		nourishment_season_linearLayout =(LinearLayout) view.findViewById(R.id.nourishment_searson_lin);
		nourishment_text = (TextView) view.findViewById(R.id.nourishment_season_text);
		listView=(ListView) view.findViewById(R.id.season_left_listview);
		try {
			getData();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		init();
		//��ʼ��ImageLoader
		initImageLoader();
		//ʵ����ImageLoader
		imageLoader = ImageLoader.getInstance();
		//��ʼ������
		initData();
		//����ListView���ٻ���ʱֹͣImageLoader����
		/*��һ�������������ǵ�ͼƬ���ض���ImageLoader
								�ڶ����ǿ����Ƿ��ڻ�����������ͣ����ͼƬ�������Ҫ��ͣ��true������
								���������������͵Ļ��������ʱ��ͼƬ�Ƿ����*/
		//		listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));  
		return view;
	}

	/*
	 * ���ó�ʼ��ImageLoader
	 */
	private void initImageLoader() {
		//����Ĭ�ϵ�ImageLoader���ò���  
		//      ImageLoaderConfiguration configuration = ImageLoaderConfiguration  
		//                .createDefault(mContext);
		//      //Initialize ImageLoader with configuration.  
		//      ImageLoader.getInstance().init(configuration); 

		File cacheDir =StorageUtils.getOwnCacheDirectory(getActivity(), "imageloader/Cache");
		@SuppressWarnings("deprecation")
		ImageLoaderConfiguration config = new ImageLoaderConfiguration
		.Builder(getActivity()) 
		.memoryCacheExtraOptions(480, 800) // maxwidth, max height���������ÿ�������ļ�����󳤿� 
		.threadPoolSize(3)//�̳߳��ڼ��ص����� 
		.threadPriority(Thread.NORM_PRIORITY -2) 
		.denyCacheImageMultipleSizesInMemory() 
		.memoryCache(new UsingFreqLimitedMemoryCache(2* 1024 * 1024)) // You can pass your own memory cache implementation/�����ͨ���Լ����ڴ滺��ʵ�� 
		.memoryCacheSize(2 * 1024 * 1024)   
		.discCacheSize(50 * 1024 * 1024)
		.discCacheFileNameGenerator(new Md5FileNameGenerator())//�������ʱ���URI������MD5 ���� 
		.tasksProcessingOrder(QueueProcessingType.LIFO) 
		.discCacheFileCount(20) //������ļ����� 
		.discCache(new UnlimitedDiscCache(cacheDir))//�Զ��建��·�� 
		.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) 
		.imageDownloader(new BaseImageDownloader(getActivity(),5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)��ʱʱ�� 
		.writeDebugLogs() // Remove for releaseapp 
		.build();//��ʼ���� 
		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		imageLoader.clearMemoryCache();
		imageLoader.clearDiskCache();
	}

	private void init() {
		new Thread(){
			public void run() {
				try {
					//					uri = new URL("http://cblue.tunnel.mobi/WebShop/nourishment?flag=5");
					url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=6";
					String data = NetworkUtil.getStringFromUrl(url);
					handler.sendMessage(handler.obtainMessage(1,data));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
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
			}
		});
		headerListView = (PinnedHeaderListView) view.findViewById(R.id.season_pinnedListView);
		NourishmentFood_ListViewLeftAdapter adapter=new NourishmentFood_ListViewLeftAdapter(getActivity(),food);
		listView.setAdapter(adapter);
		section = new ArrayList<String>();
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
				int[] startLocation = new int[2];// һ���������飬�����洢��ť������Ļ��X��Y����
				view.getLocationInWindow(startLocation);// ���ǻ�ȡ����ť������Ļ��X��Y���꣨��Ҳ�Ƕ�����ʼ�����꣩
				ball = new ImageView(getActivity());// buyImg�Ƕ�����ͼƬ���ҵ���һ��С��R.drawable.sign��
				ball.setImageResource(R.drawable.sign);// ����buyImg��ͼƬ
				setAnim(ball, startLocation);// ��ʼִ�ж���
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
		item = new ArrayList<List<com.example.nutrition.nourishment.bean.NourishmentFood>>();

		food.add("����Ӫ��ʳ��");
		food.add("��ʳ");
		food.add("����");
		for (int i = 0; i <food.size(); i++) {
			section.add(food.get(i));

			item.add(list);
		}
	}

	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what == 1){
				list = new ArrayList<com.example.nutrition.nourishment.bean.NourishmentFood>();
				String json = (String) msg.obj;
				Gson gson = new Gson();
				Log.e("666", "���� "+json.toString());
				NourishmentPar p =  gson.fromJson(json, NourishmentPar.class);
				Log.w("tag", p.getResultlist().toString());
				list = p.getResultlist();
				test();
			}
		}; 
	};

	private void getData() throws MalformedURLException {
		SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("MM");     
		String    date    =    sDateFormat.format(new    java.util.Date());  
		Log.i("666", "�·�"+date.toString());
		if(date.equals("03")||date.equals("04")||date.equals("05")){
			Log.i("666", "'����");
			nourishment_text.setText("�����Ӫ��");
			nourishment_season_linearLayout.setBackgroundColor(Color.rgb(164, 207, 79));
			url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=0";
		}
		if(date.equals("06")||date.equals("07")||date.equals("08")){
			Log.i("666", "����");
			nourishment_text.setText("�����Ӫ��");
			nourishment_season_linearLayout.setBackgroundColor(Color.rgb(164, 245, 5));
			url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=1";        }
		if(date.equals("09")||date.equals("10")||date.equals("11")){
			Log.i("666", "����");
			nourishment_text.setText("�����Ӫ��");
			nourishment_season_linearLayout.setBackgroundColor(Color.rgb(227, 227, 80));
			url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=2";        }
		if(date.equals("12")||date.equals("01")||date.equals("02")){
			Log.i("666", "����");
			nourishment_season_linearLayout.setBackgroundColor(Color.rgb(193, 213, 232));
			nourishment_text.setText("�����Ӫ��");
			url = "http://cblue.tunnel.mobi/WebShop/nourishment?flag=3";        }
	}

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
		anim_mask_layout.addView(v);// �Ѷ���С�����ӵ�������
		final View view = addViewToAnimLayout(anim_mask_layout, v,
				startLocation);
		int[] endLocation = new int[2];// �洢��������λ�õ�X��Y����

		shopCart.getLocationInWindow(endLocation);// shopCart���Ǹ����ﳵ

		// ����λ��
		int endX = 0 - startLocation[0] + 40;// ����λ�Ƶ�X����
		int endY = endLocation[1] - startLocation[1];// ����λ�Ƶ�y����

		TranslateAnimation translateAnimationX = new TranslateAnimation(0,
				endX, 0, 0);
		translateAnimationX.setInterpolator(new LinearInterpolator());
		translateAnimationX.setRepeatCount(0);// �����ظ�ִ�еĴ���
		translateAnimationX.setFillAfter(true);

		TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
				0, endY);
		translateAnimationY.setInterpolator(new AccelerateInterpolator());
		translateAnimationY.setRepeatCount(0);// �����ظ�ִ�еĴ���
		translateAnimationX.setFillAfter(true);

		AnimationSet set = new AnimationSet(false);
		set.setFillAfter(false);
		set.addAnimation(translateAnimationY);
		set.addAnimation(translateAnimationX);
		set.setDuration(800);// ������ִ��ʱ��
		view.startAnimation(set);
		// ���������¼�
		set.setAnimationListener(new AnimationListener() {
			// �����Ŀ�ʼ
			@Override
			public void onAnimationStart(Animation animation) {
				v.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			// �����Ľ���
			@Override
			public void onAnimationEnd(Animation animation) {
				v.setVisibility(View.GONE);
				buyNum++;// �ù���������1
				buyNumView.setText(buyNum + "");//
				buyNumView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
				buyNumView.show();
			}
		});

	}

}