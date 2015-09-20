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
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.content.Context;
import android.content.Intent;
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

public class FragmentRegister extends Fragment{

	private View mMainView;
	private EditText et_zhuce_username;
	private EditText et_zhuce_userpassword;
	private Button btn_zhuce;
	private String strUrl = "http://18.85.18.45:8080/WebShop/usersservlet?method=register";
	private String url_zhuce_username = "&username=";
	private String url_zhuce_password = "&password=";
	private String url_regist = "";
	private String reslut_zhuce_url = "";
	private final int OK_NUMBER = 1;
	private final int NO_NUMBER = 0;
	
	private Handler handler_zhuce=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case OK_NUMBER:
				try {
					if(reslut_zhuce_url.equals("用户名已经存在")){
						Toast.makeText(getActivity(), url_zhuce_username+"该手机号已被注册", Toast.LENGTH_SHORT).show();
					}else{	
//					}else if(reslut_zhuce_url.equals("")){
						Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
						Log.i("STR", "打印"+reslut_zhuce_url);
						Intent inten = new Intent();
						inten.putExtra("reslut_zhuce_url", reslut_zhuce_url);
//						Session session = Session.getSession();
//				        session.put("reslut_zhuce_url", reslut_zhuce_url);
//				        getActivity().finish();
						inten.setClass(getActivity(), MainActivity.class);
						startActivity(inten);
//					}else{
//						Toast.makeText(getActivity(), "注册失败", Toast.LENGTH_SHORT).show();
						}
			} catch (Exception e) {
				Toast.makeText(getActivity(), "网络服务异常", Toast.LENGTH_SHORT).show();
			}
//			Log.e("okokokokokokok", "可用");
			break;
		case NO_NUMBER:
//			Log.e("nononononono", "不可用");
			Toast.makeText(getActivity(), "手机没网", Toast.LENGTH_SHORT).show();
			break;
		}	
		super.handleMessage(msg);
	};

};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		mMainView = inflater.inflate(R.layout.registfragment, (ViewGroup) getActivity().findViewById(R.id.viewpager_user),false);
		
		et_zhuce_username = (EditText) mMainView.findViewById(R.id.et_zhuce_username);
		et_zhuce_userpassword = (EditText) mMainView.findViewById(R.id.et_zhuce_userpassword);
		btn_zhuce = (Button) mMainView.findViewById(R.id.btn_zhuce);
		
		btn_zhuce.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				zhuce();
			}
		});
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("tag", "fragment2====>>onCreateView()");
		ViewGroup p = (ViewGroup) mMainView.getParent();
		//移出已存在的View
		if(p != null){
			p.removeAllViewsInLayout();
		}
		return mMainView;
	}
	
	public void zhuce(){
		final String zhuce_username = et_zhuce_username.getText().toString();
		final String zhuce_userpassword = et_zhuce_userpassword.getText().toString();
		if(zhuce_username == "" || zhuce_userpassword == "" ){
			Toast.makeText(getActivity(), "用户名不能为空", Toast.LENGTH_SHORT).show();
		}else if(zhuce_userpassword.length() <6 || zhuce_userpassword.length() >10) {
			Toast.makeText(getActivity(), "密码格式不符", Toast.LENGTH_SHORT).show();
		}else {
			
			url_regist = url_zhuce_username + zhuce_username + url_zhuce_password+zhuce_userpassword;
			/**
			 * 访问网络
			 */
			if (NetworkUtil.isNetworkAvailable(getActivity())) {
				try {
//					params.add(new BasicNameValuePair("password",
//					register_userpassword));
//					String reslut = NetworkUtil.doPost(URLutils.loginurl,params);
					new Thread() {
						@Override
						public void run() {
							HttpClient hc_zhuce = new DefaultHttpClient();
//							HttpGet hg = new HttpGet(urlStr);
							List<BasicNameValuePair> params_zhuce = new LinkedList<BasicNameValuePair>();
							params_zhuce.add(new BasicNameValuePair("username",zhuce_username));
							params_zhuce.add(new BasicNameValuePair("password",zhuce_userpassword));
							HttpPost post_zhuce = new HttpPost(URLutils.registerURL + url_regist);
							try {
								post_zhuce.setEntity(new UrlEncodedFormEntity(params_zhuce,HTTP.UTF_8));
								HttpResponse response_zhuce = hc_zhuce.execute(post_zhuce);
//								Log.i("STR", "1111111111");
//								HttpResponse hr = hc.execute(hg);
								if (response_zhuce.getStatusLine().getStatusCode() == 200) {
//									Log.i("STR", "22222222");
//									Log.i("STR", "222"+reslut_zhuce_url);
									reslut_zhuce_url = EntityUtils.toString(response_zhuce.getEntity(), "GBK");
//									Log.i("STR", "222"+reslut_zhuce_url);
									handler_zhuce.sendEmptyMessage(OK_NUMBER);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
				} catch (Exception e) {
					// TODO: handle exception
					Message msg = handler_zhuce.obtainMessage(OK_NUMBER);
					handler_zhuce.sendMessage(msg);
				}
			} else {
				handler_zhuce.sendEmptyMessage(NO_NUMBER);
			}
			
			
//			HttpUtils hu = new HttpUtils();
//			RequestParams params = new RequestParams();
//			params.addBodyParameter("username", zhuce_username);
//			params.addBodyParameter("password", zhuce_userpassword);
//			reslut_url = EntityUtils.toString(response.getEntity(), "GBK");
//			hu.send(HttpMethod.POST, strUrl, params, new RequestCallBack<String>() {
//
//				@Override
//				public void onFailure(HttpException arg0, String arg1) {
//					// TODO Auto-generated method stub
//					Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
//				}
//
//				@Override
//				public void onSuccess(ResponseInfo<String> arg0) {
//					// TODO Auto-generated method stub
//					Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
//				}
//			});
		}
	}
	
}
