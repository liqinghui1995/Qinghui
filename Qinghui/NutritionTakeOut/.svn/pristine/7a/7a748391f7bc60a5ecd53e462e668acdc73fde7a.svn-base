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
import com.example.nutrition.utils.NetworkUtil;
import com.example.nutrition.utils.URLutils;
import com.example.nutritionTakeout.MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentLogin extends Fragment {

	private View mMainView;
	private EditText et_register_username;
	private EditText et_register_userpassword;
	private Button btn_regist;
	private SharedPreferences sp;

	private String url_login_name = "http://18.85.18.45:8080/WebShop/usersservlet?method=login&username=";
	private String url_login_password = "&password=";
	private String uuu_login = "";
	private String reslut_url = "";
	private final int OK_NUMBER = 1;
	private final int NO_NUMBER = 0;

	private Handler handler_login = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case OK_NUMBER:
				try {
					if (reslut_url.equals("用户名不存在")) {
						Toast.makeText(getActivity(), "用户名不存在",Toast.LENGTH_SHORT).show();
					} else if (reslut_url.equals("密码错误")) {
						Toast.makeText(getActivity(), "密码错误",Toast.LENGTH_SHORT).show();
					} else if(reslut_url.equals("")){
						Toast.makeText(getActivity(), "全TM错了",Toast.LENGTH_SHORT).show();
					}else {
						Toast.makeText(getActivity(), "登录成功",Toast.LENGTH_SHORT).show();
//						Log.e("okokokokokokok", "可用1111111111111111111111");
						Intent inten = new 
								Intent(getActivity(),MainActivity.class);
						sp = getActivity().getSharedPreferences("mynewsset", getActivity().MODE_PRIVATE);
						Editor editor = sp.edit();
						editor.putString("reslut", reslut_url);
						
						editor.commit();
						
						// Session session = Session.getSession();
						// session.put("reslut_url", reslut_url);
						// getActivity().finish();
						startActivity(inten);
					}
				} catch (Exception e) {
					Toast.makeText(getActivity(), "网络服务异常", Toast.LENGTH_SHORT).show();
				}
				Log.e("ok", "网络可用");
				break;
			case NO_NUMBER:
				Log.e("no", "网络不可用");
				Toast.makeText(getActivity(), "手机没网", Toast.LENGTH_SHORT).show();
				break;
			}
			// super.handleMessage(msg);
		};
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		LayoutInflater inflater = getActivity().getLayoutInflater();
		mMainView = inflater.inflate(R.layout.loginfragment,(ViewGroup) getActivity().findViewById(R.id.viewpager_user),false);
		
		et_register_username = (EditText) mMainView.findViewById(R.id.et_register_username);
		et_register_userpassword = (EditText) mMainView.findViewById(R.id.et_register_userpassword);
		btn_regist = (Button) mMainView.findViewById(R.id.btn_register_login);
		btn_regist.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				register_login();
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("tag", "fragment1====>>onCreateView()");
		ViewGroup p = (ViewGroup) mMainView.getParent();
		// 移出已存在的View
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		return mMainView;
	}

	public void register_login() {
		// Toast.makeText(getActivity(), "login", 1).show();
		final String register_username = et_register_username.getText().toString();
		final String register_userpassword = et_register_userpassword.getText().toString();
		if (register_username.equals("") || register_username == null) {
			Toast.makeText(getActivity(), "用户名不能为空", Toast.LENGTH_SHORT).show();
		} else if (register_userpassword.equals("") || register_userpassword == null) {
			Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getActivity(), "正在登录......", Toast.LENGTH_SHORT).show();

			uuu_login = url_login_name + register_username + url_login_password + register_userpassword;
			/**
			 * 访问网络
			 */
			// 登入操作NetworkUtil.isNetworkAvailable(getActivity())
			if (NetworkUtil.isNetworkAvailable(getActivity())) {
				try {
//					params.add(new BasicNameValuePair("password",
//					register_userpassword));
//					String reslut = NetworkUtil.doPost(URLutils.loginurl,params);
					new Thread() {
						@Override
						public void run() {
							HttpClient hc_login = new DefaultHttpClient();
							List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
							params.add(new BasicNameValuePair("username",register_username));
							params.add(new BasicNameValuePair("password",register_userpassword));
							HttpPost post = new HttpPost(URLutils.loginurl);
							try {
								post.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
								HttpResponse response = hc_login.execute(post);
								Log.i("STR", "1111111111");

								if (response.getStatusLine().getStatusCode() == 200) {
									Log.i("STR", "22222222");
									Log.i("STR", "222"+reslut_url);
									reslut_url = EntityUtils.toString(response.getEntity(), "GBK");
									Log.i("STR", "222"+reslut_url);
									handler_login.sendEmptyMessage(OK_NUMBER);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
				} catch (Exception e) {
					// TODO: handle exception
					Message msg = handler_login.obtainMessage(OK_NUMBER,url_login_name);
					handler_login.sendMessage(msg);
				}
			} else {
				handler_login.sendEmptyMessage(NO_NUMBER);
			}
		}
	}

}
