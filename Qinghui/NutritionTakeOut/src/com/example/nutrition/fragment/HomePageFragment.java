package com.example.nutrition.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.adapter.HomePageAdapter;
import com.example.nutrition.diningroom.activity.DiningRoomActivity;
import com.example.nutrition.diningroom.fragment.MyDiningRoomFragment;
import com.example.nutrition.nourishment.activity.NourishmentActivity;
import com.example.nutrition.nourishment.bean.NourishmentFood;
import com.example.nutrition.shark.MyShark;
import com.example.nutrition.user.vo.HomePagerVo;
import com.example.nutrition.user.vo.HotfoodVo;
import com.example.nutrition.utils.FastJsonUtil;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
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
/**
 * ��ҳFragment
 * 
 * @author Administrator
 *
 */
public class HomePageFragment extends Fragment {
	private ListView HomePageListView;
	private Context context;
	private ImageView orderfood;
	private ImageView nutrition;
	private ImageView shake;
	private ImageView diningroom;
	private ViewPager viewPager;
	private List<View> imageList;
	private LayoutInflater inflater;
	private Handler handler;
	private Runnable pagerRunable;
	List<NourishmentFood> list;
	private HotfoodVo hotfood;
	private ImageLoader imageLoader;
	public HotfoodVo getHotfood() {
		return hotfood;
	}
	public void setHotfood(HotfoodVo hotfood) {
		this.hotfood = hotfood;
	}
	public HomePageFragment(Context context) {
		this.context = context;
	}
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(getHotfood()!=null){
			list = hotfood.getFoodList();
			HomePageAdapter adapter = new HomePageAdapter(list, context , imageLoader);
			HomePageListView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
		}else{
			list = new ArrayList<NourishmentFood>();
			NourishmentFood nourishmentFood = new NourishmentFood();
			nourishmentFood.setFood_name("û�и�����ʳ");
			nourishmentFood.setFood_price(0.0);
			list.add(nourishmentFood);
		}
		View v = inflater.inflate(R.layout.first_page_fragment, null);
		View headview = inflater.inflate(R.layout.first_page_headview, null);
		orderfood = (ImageView) headview.findViewById(R.id.orderfood);
		nutrition = (ImageView) headview.findViewById(R.id.nutrition);
		shake = (ImageView) headview.findViewById(R.id.shake);
		diningroom = (ImageView) headview.findViewById(R.id.diningroom);
		viewPager = (ViewPager) headview.findViewById(R.id.homeviewPager);
		initData();
		shake.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "ҡһҡ", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context,MyShark.class);
				startActivity(intent);
			}
		});
		diningroom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MyDiningRoomFragment.class);
				startActivity(intent);
			}
		});
		nutrition.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(context, "�ҵ�Ӫ����", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context, NourishmentActivity.class);
				startActivity(intent);
			}
		});
		/**
		 * ���� ����ҳ��
		 */
		orderfood.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(context, "��Ҫ����", Toast.LENGTH_SHORT).show();
				Intent intentDiningRoom = new Intent(getActivity(),DiningRoomActivity.class);
				startActivity(intentDiningRoom);
			}
		});
		HomePageListView = (ListView) v.findViewById(R.id.firstListView);
		HomePageListView.addHeaderView(headview);
		Log.i("TAG", list.toString());
		HomePageAdapter adapter = new HomePageAdapter(list, context , imageLoader);
		HomePageListView.setAdapter(adapter);
		HomePageListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});

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
		HomePageListView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));  
		return v;
	}
	private void initData() {
		inflater = LayoutInflater.from(context);
		imageList = new ArrayList<View>();
		try {
			HttpUtils httpUtils = new HttpUtils();
			httpUtils.send(HttpMethod.GET, "http://cblue.tunnel.mobi/WebShop/homeViewPagerServlet", new RequestCallBack<String>() {
				@Override
				public void onFailure(HttpException arg0, String arg1) {
					Toast.makeText(context, "ʧ��", Toast.LENGTH_SHORT).show();
				}
				@Override
				public void onSuccess(ResponseInfo<String> arg0) {
					Toast.makeText(context, "�ɹ�", Toast.LENGTH_SHORT).show();
					List<HomePagerVo> list = FastJsonUtil.getList(arg0.result, HomePagerVo.class);
					Log.i("TAG", list.toString());
					BitmapUtils bitmapUtil = new BitmapUtils(context);
					for(int i=0;i<list.size();i++){
						View item = inflater.inflate(R.layout.viewpager_item, null);
						ImageView img = (ImageView) item.findViewById(R.id.viewpagerimage);
						//						bitmapUtil.display(img, "http://cblue.tunnel.mobi/WebShop/"+list.get(i).getViewpagerurl());
						imageLoader.displayImage("http://cblue.tunnel.mobi/WebShop/"+list.get(i).getViewpagerurl(), img);
						imageList.add(item);
					}
					viewPager.setAdapter(new MyViewPagerAdapter());
					initRunable();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
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
	private void initRunable() {
		handler = new Handler();
		pagerRunable = new Runnable() {
			@Override
			public void run() {
				int nowIndex = viewPager.getCurrentItem();
				int count = viewPager.getAdapter().getCount();
				//�ж���һҳ�Ƿ������ҳ�����������ҳ�������ص�һҳ����������һҳ
				if(nowIndex+1 >= count){
					viewPager.setCurrentItem(0);
				}else {
					viewPager.setCurrentItem(nowIndex+1);
				}
				handler.postDelayed(pagerRunable, 3000);
			}
		};
		handler.postDelayed(pagerRunable, 3000);
	}
	private class MyViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return imageList.size();
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(imageList.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(imageList.get(position));
			return imageList.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}
}