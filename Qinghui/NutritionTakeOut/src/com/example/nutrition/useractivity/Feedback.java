package com.example.nutrition.useractivity;

import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.utils.FastJsonUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends Activity {
	/*
	 * gifts�ӿ�
	 * http://localhost:8080/WebShop/usersservlet?method=tickling&userid=1&tickling=adsfksadfj&contact=13681476212
	 */
	private final String strUrl = "http://cblue.tunnel.mobi/WebShop/usersservlet?method=tickling";
	private String feedback;
	private String contact;
	private Context mContext;
	private List<UserBean> ulist;
	
	@ViewInject(R.id.set_feedback_rate)
	private TextView rate;
	@ViewInject(R.id.set_feedback_info)
	private EditText info;
	@ViewInject(R.id.set_feedback_phone)
	private EditText phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_feedback);
		mContext = this;
		//xutilsע��
		ViewUtils.inject(this);
		//��ȡ�û���Ϣ
		SharedPreferences sp = getSharedPreferences("mynewsset",MODE_PRIVATE);
		String json_chuan = sp.getString("reslut", "");
		if(!"".equals(json_chuan)&&!"��½/ע��".equals(json_chuan)){
			ulist = FastJsonUtil.getList(json_chuan, UserBean.class);
		}
		//��ʼ����ͼ
		initView();
	}
	
	//���÷�������
	@OnClick(R.id.set_feedback_send)
	public void send(View v){
		feedback = info.getText().toString();
		int lenght = feedback.length();
		if(lenght<=0){
			Toast.makeText(mContext, "���������ı������", 1).show();
		}else if(lenght>=300){
			Toast.makeText(mContext, "���ݶ���300��", 1).show();
		}else if(ulist==null){
			Toast.makeText(mContext, "���ȵ�¼������", 1).show();
		}else if(ulist!=null){
//			Log.i("STR","2222"+ulist.toString());
			HttpUtils hu = new HttpUtils();
			RequestParams params = new RequestParams();
			params.addBodyParameter("userid", ulist.get(0).getUser_id()+"");
			params.addBodyParameter("tickling", feedback);
			params.addBodyParameter("contact", contact);
			hu.send(HttpMethod.POST, strUrl, params, new RequestCallBack<String>() {

				@Override
				public void onFailure(HttpException arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(ResponseInfo<String> arg0) {
					// TODO Auto-generated method stub
					if(!arg0.result.equals("")){
						Toast.makeText(mContext, "����ύ�ɹ�", 1).show();
						finish();
					}
				}
			});
		}
		
	}
	
	//���÷��ع���
	@OnClick(R.id.set_feedback_imgback)
	public void back(View v){
		finish();
	}
	
	//���ó�ʼ����ͼ
    public void initView(){
    	/*
    	 * ������ϵ��ʽ�������
    	 */
    	phone.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					//info.requestFocus();
				}
			}
		});
    	/*
    	 * ��������򽹵����
    	 */
    	info.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					contact = phone.getText().toString().trim();
					String qqstr = "^[1-9][0-9]{4,}$";
					String phonestr = "[1][358]\\d{9}";
					String ems = "^\\w+[-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
					if(contact.matches(qqstr)|contact.matches(phonestr)){
						Toast.makeText(mContext, "��ϵ��ʽ��ȷ,������������", 1).show();
					}else{
						Toast.makeText(mContext, "��ϵ��ʽ����", 1).show();
						info.clearFocus();
					}
				}
			}
		});
		info.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String content = info.getText().toString();
				rate.setText(content.length() + "/"
						+ 300);
			}
		});
    }
}