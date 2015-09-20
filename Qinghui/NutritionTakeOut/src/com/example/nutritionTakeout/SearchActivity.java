package com.example.nutritionTakeout;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.nutrition.R;
import com.example.nutrition.adapter.MyCityAdapter;
import com.example.nutrition.adapter.MyDistrictAdapter;
import com.example.nutrition.base.BaseActivity;
import com.example.nutrition.city.vo.CityVo;
import com.example.nutrition.city.vo.DistrictVo;
import com.example.nutrition.utils.FastJsonUtil;
import com.example.nutrition.utils.NetworkUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class SearchActivity extends BaseActivity {
	@ViewInject(R.id.search_title)
	private TextView searchTitle;
	@ViewInject(R.id.position)
	private EditText searchlocation;
	@ViewInject(R.id.automatic)
	private TextView automatic;
	@ViewInject(R.id.search_listView)
	private ListView listView;
	private Intent intent;
	private List<DistrictVo> districtList;
	String cityid = "1";
	View popview;
	PopupWindow popupWindow;
	private String location;
	private ListView cityListView;
	private List<CityVo> cityList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search_location);
        ViewUtils.inject(this);
        initView();
        popupwindow();
	}
	@Override
	public void initView() {
		intent = getIntent();
		location = intent.getStringExtra("location");
		searchlocation.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String district = searchlocation.getText().toString();
				Log.i("TAG", district);
				if(district!=null&&!district.equals("")){
					initDistrictDate(cityid, district);
				}
			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				intent.putExtra("location", districtList.get(position).getDistrict());
				setResult(1002,intent);
				finish();
			}
		});
		new Thread(){
			public void run() {
				String json = NetworkUtil.getStringFromUrl("http://cblue.tunnel.mobi/WebShop/searchcity?method=city");
//				try {
//					String str = new String(json.getBytes("ISO-8859-1"),"GBK");
					List<CityVo> cityList =  FastJsonUtil.getList(json, CityVo.class);
					Log.i("TAG", cityList.toString());
					handler.sendMessage(handler.obtainMessage(1, cityList));
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			};
		}.start();
		
	}
	
	private void popupwindow() {
		//��ȡ��Ļ���
		WindowManager wm = this.getWindowManager();
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
	    //����popwindow
		View root = this.getLayoutInflater().inflate(R.layout.city_popwindow, null);
		cityListView = (ListView) root.findViewById(R.id.citylistView);
		cityListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				popupWindow.dismiss();
				cityid = String.valueOf(cityList.get(position).getId());
				searchTitle.setText(cityList.get(position).getCity());
			}
		});
		popupWindow = new PopupWindow(root, width, height-50);
		// ����Ҫ����PopuWindow�ı���������Ҫ��PopuWindow��ʾ֮ǰ�������ı�������Ȼû��Ч����
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		// �ⲿ�����ʧ
		//��ȡpopupwindow�رհ�ť����ʵ�ֹرռ���
	}
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what == 1){
				cityList = (List<CityVo>) msg.obj;
				MyCityAdapter adapter = new MyCityAdapter(cityList, SearchActivity.this);
				cityListView.setAdapter(adapter);
			}else if(msg.what == 2){
				districtList = (List<DistrictVo>) msg.obj;
				if(districtList.size()==0){
					DistrictVo district = new DistrictVo();
					district.setDistrict("û�и�����Ϣ");
					districtList.add(district);
				}
				MyDistrictAdapter adapter = new MyDistrictAdapter(districtList, SearchActivity.this);
				listView.setAdapter(adapter);
			}
		};
	};
	@OnClick(R.id.automatic)
	public void automatic(View v){
		intent.putExtra("location", location);
		setResult(1002,intent);
		finish();
	}
	 
	@OnClick(R.id.search_title)
	public void search_title(View v){
		//��������ʽ��ʾpopwindow
		popupWindow.showAsDropDown(v);
				//��popwindow��ʾָ��λ��
		popupWindow.showAtLocation(findViewById(R.id.search_layout),
							Gravity.AXIS_PULL_BEFORE, 0, 40);
	}
	public void initDistrictDate(final String id,final String district) {
		new Thread(){
			public void run() {
				String json = NetworkUtil.getStringFromUrl("http://cblue.tunnel.mobi/WebShop/searchcity?method=district&id="+id+"&district="+district);
				List<DistrictVo> districtList = FastJsonUtil.getList(json, DistrictVo.class);
				Log.i("TAG", ""+json);
				handler.sendMessage(handler.obtainMessage(2, districtList));
			};
		}.start();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
}
