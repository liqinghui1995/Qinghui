package com.example.nutrition.useractivity;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.fragment.MineFragment;
import com.example.nutrition.fragment.UserBean;
import com.example.nutrition.utils.FastJsonUtil;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class Share extends Activity {
	private PopupWindow popup;
	private List<UserBean> ulist;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_share);
		//xutilsע��
		ViewUtils.inject(this);
		//��ȡ�û���Ϣ
		SharedPreferences sp = getSharedPreferences("mynewsset", MODE_PRIVATE);
		String json_chuan = sp.getString("reslut", "");
		if(!"".equals(json_chuan)&&!"��½/ע��".equals(json_chuan)){
			ulist = FastJsonUtil.getList(json_chuan, UserBean.class);
		}
		//����popwindow
		popupwindow();
	}
	
	//���÷�����
	@OnClick(R.id.set_share_imggift)
	public void gift(View v){
		//��������ʽ��ʾpopwindow
		popup.showAsDropDown(v);
		//��popwindow��ʾָ��λ��
		popup.showAtLocation(findViewById(R.id.set_share_imggift),
					Gravity.AXIS_PULL_BEFORE, 0, 0);
	}
	
	//popwindow����
	private void popupwindow() {
		//��ȡ��Ļ���
		WindowManager wm = this.getWindowManager();
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
	    
	    //����popwindow
		View root = this.getLayoutInflater().inflate(R.layout.share_popwindow, null);
		popup = new PopupWindow(root, width, height/3);
		// ����Ҫ����PopuWindow�ı���������Ҫ��PopuWindow��ʾ֮ǰ�������ı�������Ȼû��Ч����
		popup.setBackgroundDrawable(new BitmapDrawable());
		popup.setOutsideTouchable(true);
		// �ⲿ�����ʧ
		//��ȡpopupwindow�رհ�ť����ʵ�ֹرռ���
		root.findViewById(R.id.set_share_pop_img_close).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				popup.dismiss();
			}
		});
	}
	
	//���÷��ع���
	@OnClick(R.id.set_share_imgback)
	public void back(View v){
		finish();
	}

}
