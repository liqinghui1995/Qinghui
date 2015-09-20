package com.example.nutrition.useractivity;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.nutrition.R;
import com.example.nutrition.fragment.MineFragment;
import com.example.nutrition.user.UserBean;
import com.example.nutrition.utils.FastJsonUtil;
import com.example.nutrition.utils.URLutils;
import com.example.nutritionTakeout.MainActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeNameActivity extends Activity{
	List<UserBean> list;
	private EditText save_editext;
	private String  url="http://cblue.tunnel.mobi/WebShop/usersservlet?method=changenickname";

	private SharedPreferences sp;
	private String json_chuan;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_name);
		context = this;
		save_editext=(EditText) findViewById(R.id.change_name_edittext);
		//用XUtils注释组件
		ViewUtils.inject(this);
		sp = getSharedPreferences("mynewsset",MODE_PRIVATE);
		json_chuan = sp.getString("reslut", "登陆/注册");
		list = FastJsonUtil.getList(json_chuan, UserBean.class);
	}
	@OnClick(R.id.sava_change_name_img)
	public void save(View v){
		//Toast.makeText(context, "hello!!!", 1).show();
		new Thread() {
			@Override
			public void run() {
				String eidtText_nickName=save_editext.getText().toString();
				HttpClient hc = new DefaultHttpClient();
//				HttpGet hg = new HttpGet(urlStr);
				List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
				params.add(new BasicNameValuePair("userid",list.get(0).getUser_id()+""));
				
				params.add(new BasicNameValuePair("username",list.get(0).getUser_name()));
				params.add(new BasicNameValuePair("password",list.get(0).getUser_password()));
				params.add(new BasicNameValuePair("address",list.get(0).getUser_address()));
				params.add(new BasicNameValuePair("coin",list.get(0).getUser_coin()+""));
				params.add(new BasicNameValuePair("nickname",eidtText_nickName));
				params.add(new BasicNameValuePair("record",list.get(0).getUser_record()+""));

				HttpPost post = new HttpPost(url);
				
				try {
					post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
					HttpResponse response = hc.execute(post);
					Log.i("waimai", "正在请求");
					Log.i("waimai", "onclick:"+params.toString());
					if (response.getStatusLine().getStatusCode() == 200) {
						Log.i("waimai", "请求成功");
						String result = EntityUtils.toString(response.getEntity(), "GBK");
						refershUserinfo();
					}else{
						handler.sendEmptyMessage(1);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	@OnClick(R.id.change_name_returnbt)
	public void return_my(View v){
		finish();
	}
	
	//刷新用户信息
	public void refershUserinfo(){
		new Thread() {
			@Override
			public void run() {
				HttpClient hc_login = new DefaultHttpClient();
				List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
				params.add(new BasicNameValuePair("username",list.get(0).getUser_name()));
				params.add(new BasicNameValuePair("password",list.get(0).getUser_password()));
				HttpPost post = new HttpPost(URLutils.loginurl);
				try {
					post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
					HttpResponse response = hc_login.execute(post);
//					Log.i("STR", "1111111111");

					if (response.getStatusLine().getStatusCode() == 200) {
//						Log.i("STR", "22222222");
						json_chuan = EntityUtils.toString(response.getEntity(), "GBK");
//						Log.i("waimai", json_chuan);
						handler.sendEmptyMessage(0);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			if(msg.what==0){
				sp = getSharedPreferences("mynewsset", MODE_PRIVATE);
				Editor editor = sp.edit();
				editor.putString("reslut", json_chuan);
				editor.commit();
				Intent intent = new Intent(ChangeNameActivity.this,MainActivity.class);
				startActivity(intent);
			}else if(msg.what==1){
				Toast.makeText(context, "更改失败", 1).show();
			}
		}
		
	};
}
