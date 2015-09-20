package com.example.nutrition.useractivity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.adapter.MyAddressAdapter;
import com.example.nutrition.base.BaseActivity;
import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.user.vo.UserAddressVo;
import com.example.nutrition.utils.FastJsonUtil;
import com.example.nutrition.utils.NetworkUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class Add_adress_Activity extends BaseActivity{
	private ListView listView;
	private UserBean userBean;
	private String url = "http://cblue.tunnel.mobi/WebShop/usersservlet?method=queryaddress&firstindex=0&maxresult=10";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adress_manager);
		//用XUtils注释组件
		ViewUtils.inject(this);
		initView();
		initDate();
	}
	
	@Override
	public void initView() {
		listView = (ListView) findViewById(R.id.adress_list);
		Intent intent = getIntent();
		userBean = (UserBean) intent.getSerializableExtra("userBean");
	}

	@Override
	public void setListener() {
	}

	@Override
	public void initDate() {
		new Thread(){
			public void run() {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("userid", String.valueOf(userBean.getUser_id())));
				String json = NetworkUtil.doPost(url, params);
				Log.i("Addressjson", json);
				if(!json.equals("没有此用户信息")){
				List<UserAddressVo> list = FastJsonUtil.getList(json, UserAddressVo.class);
				
				handler.sendMessage(handler.obtainMessage(1, list));
				}else{
					handler.sendMessage(handler.obtainMessage(0));
				}
			};
		}.start();
	}
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what ==1){
				List<UserAddressVo> addressList = (List<UserAddressVo>) msg.obj;
				MyAddressAdapter adapter = new MyAddressAdapter(addressList, Add_adress_Activity.this);
				listView.setAdapter(adapter);
			}else if(msg.what==0){
				Toast.makeText(Add_adress_Activity.this, "快去添加地址吧", 1).show();
			}
		};
	};

	@OnClick(R.id.adress_add)
	public void changepass(View v){
		Intent intent = new Intent(Add_adress_Activity.this,Update_adressActivity.class);
		startActivityForResult(intent, 1001);
		startActivity(intent);
	}
	@OnClick(R.id.adress_returnbt)
	public void return_my(View v){
		finish();
	}
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		if(arg0==1001&&arg1==1002){
			initDate();
		}
	}
}
