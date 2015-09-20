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

public class ChangePasswordActivity extends Activity{
	
	List<UserBean> list;
	private EditText save_editext_fist,save_editext_second;
	private String  urls="http://cblue.tunnel.mobi/WebShop/usersservlet?method=changenickname";
	private SharedPreferences sp;
	private String json_chuan;
	private final int OK_NUMBER = 1;
	private final int NO_NUMBER = 0;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_password);
		context = this;
		save_editext_fist=(EditText) findViewById(R.id.old_edittext);
		save_editext_second=(EditText) findViewById(R.id.new_edittext);
		//用XUtils注释组件
		ViewUtils.inject(this);
		sp = getSharedPreferences("mynewsset",MODE_PRIVATE);
		
		json_chuan = sp.getString("reslut", "");
		list = FastJsonUtil.getList(json_chuan, UserBean.class);
	}
	
	@OnClick(R.id.sava_name_img)
	public void save(View v){
		//Toast.makeText(context, "hello!!!", 1).show();
		new Thread() {
			@Override
			public void run() {
				String eidtText_password_first=save_editext_fist.getText().toString();
				String eidtText_password_second=save_editext_second.getText().toString();
				if(eidtText_password_first.equals(eidtText_password_second)){
				HttpClient hc = new DefaultHttpClient();

				List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
				params.add(new BasicNameValuePair("userid",list.get(0).getUser_id()+""));
				params.add(new BasicNameValuePair("username",list.get(0).getUser_name()));
				params.add(new BasicNameValuePair("password",eidtText_password_second));
				params.add(new BasicNameValuePair("address",list.get(0).getUser_address()));
				params.add(new BasicNameValuePair("coin",list.get(0).getUser_coin()+""));
				params.add(new BasicNameValuePair("nickname",list.get(0).getUser_nickname()));
				params.add(new BasicNameValuePair("record",list.get(0).getUser_record()+""));
				
				HttpPost post = new HttpPost(urls);
				
				try {
					
					post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
					HttpResponse response = hc.execute(post);
//					Log.i("waimai", "正在请求");
//					Log.i("waimai", "onclick:"+params.toString());
					if (response.getStatusLine().getStatusCode() == 200) {
						
						String result = EntityUtils.toString(response.getEntity(), "GBK");
						handler_login.sendEmptyMessage(OK_NUMBER);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				handler_login.sendEmptyMessage(NO_NUMBER);
			}
			}
				
				
			
		}.start();
		finish();
	}
	private Handler handler_login = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case NO_NUMBER:
			Toast.makeText(ChangePasswordActivity.this, "两次输入密码不一致", 1).show();
			break;
			case OK_NUMBER:
				Toast.makeText(ChangePasswordActivity.this, "保存成功", 1).show();
				break;
			}
			// super.handleMessage(msg);
		};
	};
	
	@OnClick(R.id.change_password_retrunbt)
	public void return_my(View v){
		finish();
	}
}
