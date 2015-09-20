package com.example.nutrition.diningroom.activity;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.example.nutrition.R;
import com.example.nutrition.diningroom.activity.view.XListView;
import com.example.nutrition.diningroom.activity.view.XListView.IXListViewListener;
import com.example.nutrition.diningroom.adapter.DiningRoomAdapter;
import com.example.nutrition.diningroom.vo.AllDiningRoom;
import com.example.nutrition.diningroom.vo.DiningRoom;
import com.example.nutrition.dinnerinfo.activity.DinnerInfoActivity;
import com.example.nutrition.order.activity.OrderActivity;
import com.example.nutrition.utils.FastJsonUtil;
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

public class DiningRoomActivity extends Activity implements IXListViewListener{
	private TextView order, hot, activity;
	private Context context;
	private XListView listView;
	private DiningRoomAdapter adapter;
	private List<DiningRoom> list;
	PopupWindow pWindow;
	private ImageLoader imageLoader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		context = this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ����ǩ��
		setContentView(R.layout.activity_diningroom);

		//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		listView = (XListView) findViewById(R.id.DiningRoomListView);
		//��ʼ��ImageLoader
		initImageLoader();
		//ʵ����ImageLoader
		imageLoader = ImageLoader.getInstance();
		//���������������͵Ļ��������ʱ��ͼƬ�Ƿ����
		listView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));  
		//��������
		listView.setPullLoadEnable(true);
		//����ˢ��
		listView.setPullRefreshEnable(true);  
		listView.setXListViewListener(this);
		order = (TextView) findViewById(R.id.diningroom_order);
		hot = (TextView) findViewById(R.id.diningroom_hot);
		activity = (TextView) findViewById(R.id.diningroom_activity);
		textclick();

		new Thread(){
			@Override
			public void run() {
				try {
					HttpClient hClient = new DefaultHttpClient();
					HttpGet hg = new HttpGet("http://cblue.tunnel.mobi/WebShop/dingroom");
					HttpResponse hResponse = hClient.execute(hg);
					if(hResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
						HttpEntity he = hResponse.getEntity();
						String str = EntityUtils.toString(he);
						Message mes = myhandler.obtainMessage(1,str);
						myhandler.sendMessage(mes);
					}
				} catch (ClientProtocolException e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		initView();
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

		File cacheDir =StorageUtils.getOwnCacheDirectory(context, "imageloader/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration
				.Builder(context) 
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
		.imageDownloader(new BaseImageDownloader(context,5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)��ʱʱ�� 
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
	private void textclick() {
		/**
		 * Popupwindow�����Ҫ����հ״��Զ���ʧ����Ҫ������������

1��customPopWindow.setFocusable(true);�ú���Ҳ�����ڹ��캯�������ã��磺mPopupWindow = new PopupWindow(popunwindwow,LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT,true);���һ������true��Ϊ�趨Focusable���ԡ�

2��customPopWindow.setBackgroundDrawable(new BitmapDrawable());

�˴���Ҫע�⣺�������������������showAtLocation��������֮ǰ�����������á� 
		 */
		order.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (pWindow != null && pWindow.isShowing()) {
					pWindow.dismiss();
					return;
				} else {
					initmPopupWindowView();
					pWindow.showAsDropDown(v, 0, 5);
				}
			}

			private void initmPopupWindowView() {
				// // ��ȡ�Զ��岼���ļ�pop.xml����ͼ
				View customView = getLayoutInflater().inflate(
						R.layout.activity_diningroom_popwindow_order, null,
						false);
				// ����PopupWindowʵ��,200,150�ֱ��ǿ�Ⱥ͸߶�
				pWindow = new PopupWindow(customView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,true);
				pWindow.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.nourishment_u12));
				// ���ö���Ч�� [R.style.AnimationFade ���Լ����ȶ���õ�]
				// pWindow.setAnimationStyle(R.style.AnimationFade);
				// �Զ���view��Ӵ����¼�
				customView.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (pWindow != null && pWindow.isShowing()) {
							pWindow.dismiss();
							pWindow = null;
						}
						return false;
					}
				});
				/** ���������ʵ���Զ�����ͼ�Ĺ��� */
				TextView order1 = (TextView) customView
						.findViewById(R.id.order);
				TextView order2 = (TextView) customView
						.findViewById(R.id.order2);
				TextView order3 = (TextView) customView
						.findViewById(R.id.order3);
				TextView order4 = (TextView) customView
						.findViewById(R.id.order4);
				order1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "Ĭ������", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order2.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "���ͼ����", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order3.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "�������", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order4.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "�������", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
			};
		});
		// ���Ų�ϵ
		hot.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (pWindow != null && pWindow.isShowing()) {
					pWindow.dismiss();
					return;
				} else {
					initmPopupWindowView();
					pWindow.showAsDropDown(v, 0, 5);
				}
			}

			private void initmPopupWindowView() {
				// // ��ȡ�Զ��岼���ļ�pop.xml����ͼ

				View customView = getLayoutInflater()
						.inflate(R.layout.activity_diningroom_popwindow_hot,
								null, false);
				// ����PopupWindowʵ��,200,150�ֱ��ǿ�Ⱥ͸߶�
				pWindow = new PopupWindow(customView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,true);
				pWindow.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.nourishment_u12));
				// ���ö���Ч�� [R.style.AnimationFade ���Լ����ȶ���õ�]
				// pWindow.setAnimationStyle(R.style.AnimationFade);
				// �Զ���view��Ӵ����¼�
				customView.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (pWindow != null && pWindow.isShowing()) {
							pWindow.dismiss();
							pWindow = null;
						}
						return false;
					}
				});
				/** ���������ʵ���Զ�����ͼ�Ĺ��� */
				TextView order1 = (TextView) customView.findViewById(R.id.all);
				TextView order2 = (TextView) customView.findViewById(R.id.all2);
				TextView order3 = (TextView) customView.findViewById(R.id.all3);
				TextView order4 = (TextView) customView.findViewById(R.id.all4);
				order1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "���в�ϵ", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order2.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order3.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order4.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
			};
		});
		// �����
		activity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (pWindow != null && pWindow.isShowing()) {
					pWindow.dismiss();
					return;
				} else {
					initmPopupWindowView();
					pWindow.showAsDropDown(v, 0, 5);
				}
			}

			private void initmPopupWindowView() {
				// // ��ȡ�Զ��岼���ļ�pop.xml����ͼ
				View customView = getLayoutInflater().inflate(
						R.layout.activity_diningroom_popwindow_activity, null,
						false);
				// ����PopupWindowʵ��,200,150�ֱ��ǿ�Ⱥ͸߶�
				pWindow = new PopupWindow(customView,
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,true);
				pWindow.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.nourishment_u12));
				// ���ö���Ч�� [R.style.AnimationFade ���Լ����ȶ���õ�]
				// pWindow.setAnimationStyle(R.style.AnimationFade);
				// �Զ���view��Ӵ����¼�
				customView.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						if (pWindow != null && pWindow.isShowing()) {
							pWindow.dismiss();
							pWindow = null;
						}
						return false;
					}
				});
				/** ���������ʵ���Զ�����ͼ�Ĺ��� */
				TextView order1 = (TextView) customView.findViewById(R.id.pay);
				TextView order2 = (TextView) customView.findViewById(R.id.pay2);
				TextView order3 = (TextView) customView.findViewById(R.id.pay3);
				TextView order4 = (TextView) customView.findViewById(R.id.pay4);
				order1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����֧��", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order2.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����֧��", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order3.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����֧��", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
				order4.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Toast.makeText(context, "����֧��", 1).show();
						// ��ת
						Intent intent = new Intent(context,
								DiningRoomActivity.class);
						startActivity(intent);
						pWindow.dismiss();
						finish();
					}
				});
			};
		});
	}

	@SuppressLint("HandlerLeak")
	Handler myhandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			if(msg.what==1){

				try {
					String json = (String) msg.obj;
					String string3 = new String(json.getBytes("iso-8859-1"),"GBK");
					AllDiningRoom all = FastJsonUtil.json2Object(string3, AllDiningRoom.class);
					System.out.println(all.toString());
					list =	all.getResultlist();

					DiningRoomAdapter  adapter = new DiningRoomAdapter(context,all.getResultlist(),imageLoader);
					listView.setAdapter(adapter);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	};
	private void initView() {
		// TODO Auto-generated method stub
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(context, DinnerInfoActivity.class);
				intent.putExtra("DiningRoomName", list.get(position).getDiningRoomName());
				intent.putExtra("RoomAddress",list.get(position).getDiningRoomAddress()); 
				intent.putExtra("DiningRoomImage",list.get(position).getDiningRoomImage()); 
				intent.putExtra("DiningRoomClasses",list.get(position).getDiningRoomClasses());
				intent.putExtra("DiningRoomStartPrice",list.get(position).getDiningRoomStartPrice());
				intent.putExtra("DiningRoomFreight",list.get(position).getDiningRoomFreight());
				intent.putExtra("DiningRoomSendTime",list.get(position).getDiningRoomSendTime());
				intent.putExtra("getDiningRoomIntroduce",list.get(position).getDiningRoomIntroduce());
				intent.putExtra("DiningRoomShopHours",list.get(position).getDiningRoomShopHours());
				intent.putExtra("diningRoomLevel", list.get(position).getDiningRoomLevel());
				intent.putExtra("diningRoomActivityFavorable", list.get(position).getDiningRoomActivityFavorable());
				startActivity(intent);
			}
		});
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				adapter = new DiningRoomAdapter(context, list,imageLoader);
				listView.setAdapter(adapter);
				//֪ͨlistview ˢ��������ϣ�
				listView.refreshDrawableState();
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		//		Handler handler = new Handler();
		//		handler.postDelayed(new Runnable() {
		//			@Override
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				adapter.notifyDataSetChanged();
		//				onLoad();
		//			}
		//		}, 2000);
	}
	/**
	 * �������ִ�еĲ���
	 */
	private void onLoad() {
		//ֹͣˢ�£�����header view
		listView.stopRefresh();
		//ֹͣ���ظ��࣬����footer view
		listView.stopLoadMore();
		listView.setRefreshTime("�ո�");
	}
}
