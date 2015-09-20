package com.example.nutrition.fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.nutrition.R;
import com.example.nutrition.useractivity.Add_adress_Activity;
import com.example.nutrition.useractivity.ChangeNameActivity;
import com.example.nutrition.useractivity.ChangePasswordActivity;
import com.example.nutrition.useractivity.Feedback;
import com.example.nutrition.useractivity.LoginMainActivity;
import com.example.nutrition.useractivity.Mypentacles;
import com.example.nutrition.useractivity.Setting;
import com.example.nutrition.useractivity.Share;

import com.example.nutrition.utils.FastJsonUtil;


/**
 * 我的
 * 
 * @author Administrator
 * 
 */
public class MineFragment extends Fragment {
	private String json_chuan;
	private SharedPreferences sp;
	private TextView tv;
	private List<UserBean> list;
	private ImageView titleimg;
	private PopupWindow popupWindow;
	private Uri photoUri;
	private final int PIC_FROM_CAMERA = 1;
	private final int PIC_FROM＿LOCALPHOTO = 0;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_main, null);

		sp = getActivity().getSharedPreferences("mynewsset",
				getActivity().MODE_PRIVATE);

		json_chuan = sp.getString("reslut", "登陆/注册");

		Log.i("jsonchuan", json_chuan);
		initView(v);
		popupwindow();
		return v;

	}

	public void initView(View v) {
		// TODO Auto-generated method stub
		// 用户信息显示
		tv = (TextView) v.findViewById(R.id.user_textView);
		if (json_chuan.equals("登陆/注册")) {
			tv.setText(json_chuan);
		} else if(json_chuan.equals("")){
			tv.setText("登陆/注册");
		}else {
			list = FastJsonUtil.getList(json_chuan, UserBean.class);
			tv.setText(list.get(0).getUser_nickname());
		}
		// 登陆注册
		tv.setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), LoginMainActivity.class));
			}
		});
		// 修改昵称
		v.findViewById(R.id.changename_img).setOnClickListener(new

		OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("登陆/注册")) {
					Toast.makeText(getActivity(), "请先登录！！！", 1).show();
				} else {
					Intent inten = new Intent(getActivity(), ChangeNameActivity.class);
					startActivity(inten);
				}

			}
		});
		// 我的氪星币
		v.findViewById(R.id.setting_mypentacles).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Mypentacles.class));
			}
		});
		// 意见反馈
		v.findViewById(R.id.setting_feedback).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Feedback.class));
			}
		});
		// 推荐赢奖品
		v.findViewById(R.id.setting_share).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Share.class));
			}
		});
		// 修改密码
		v.findViewById(R.id.changepassword_immg).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("登陆/注册")) {
					Toast.makeText(getActivity(), "请先登录！！！", 1).show();
				} else {
					startActivity(new Intent(getActivity
							(), ChangePasswordActivity.class));
				}
			}
		});
		// 增加地址
		v.findViewById(R.id.my_add_adress_immg).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("登陆/注册")) {
					Toast.makeText(getActivity(), "请先登录！！！", 1).show();
				} else {
					Intent intent = new Intent(getActivity(), Add_adress_Activity.class);
					intent.putExtra("userBean", list.get(0));
					startActivity(intent);
				}
			}
		});
		// 设置
		v.findViewById(R.id.settting_setting).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Setting.class));
			}
		});
		titleimg = (ImageView) v.findViewById(R.id.headpic_imageView);
		titleimg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//以下拉方式显示popwindow
				popupWindow.showAsDropDown(v);
						//将popwindow显示指定位置
				popupWindow.showAtLocation(titleimg,
									Gravity.AXIS_PULL_BEFORE, 0, 40);
			}
		});
	}
	private void popupwindow() {
		//获取屏幕宽高
		WindowManager wm = getActivity().getWindowManager();
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
	    //设置popwindow
		View root = getActivity().getLayoutInflater().inflate(R.layout.title_img_popwindow, null);
		TextView camer = (TextView) root.findViewById(R.id.camera);
		TextView photoalbum = (TextView) root.findViewById(R.id.photoalbum);
		camer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "拍照", Toast.LENGTH_SHORT).show();
				doHandlerPhoto(PIC_FROM_CAMERA);// 用户点击了从照相机获取
			}
		});
		photoalbum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "系统相册", Toast.LENGTH_SHORT).show();
				doHandlerPhoto(PIC_FROM＿LOCALPHOTO);// 从相册中去获取
			}
		});
		popupWindow = new PopupWindow(root, 600, 400);
		// 首先要设置PopuWindow的背景，而且要在PopuWindow显示之前设置他的背景，不然没有效果。
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		// 外部点击消失
		//获取popupwindow关闭按钮，并实现关闭监听
	}
	
	/**
	 * 根据不同方式选择图片设置ImageView
	 * @param type 0-本地相册选择，非0为拍照
	 */
	private void doHandlerPhoto(int type)
	{
		try
		{
			//保存裁剪后的图片文件
			File pictureFileDir = new File(Environment.getExternalStorageDirectory(), "/upload");
			if (!pictureFileDir.exists()) {
				pictureFileDir.mkdirs();
			}
			File picFile = new File(pictureFileDir, "upload.jpeg");
			if (!picFile.exists()) {
				picFile.createNewFile();
			}
			photoUri = Uri.fromFile(picFile);
			
			if (type==PIC_FROM＿LOCALPHOTO)
			{
				Intent intent = getCropImageIntent();
				startActivityForResult(intent, PIC_FROM＿LOCALPHOTO);
			}else
			{
				Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
				startActivityForResult(cameraIntent, PIC_FROM_CAMERA);
			}

		} catch (Exception e)
		{
			Log.i("HandlerPicError", "处理图片出现错误");
		}
	}

	/**
	 * 调用图片剪辑程序
	 */
	public Intent getCropImageIntent() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		intent.setType("image/*");
		setIntentParams(intent);
		return intent;
	}

	/**
	 * 启动裁剪
	 */
	private void cropImageUriByTakePhoto() {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(photoUri, "image/*");
		setIntentParams(intent);
		startActivityForResult(intent, PIC_FROM＿LOCALPHOTO);
	}

	/**
	 * 设置公用参数
	 */
	private void setIntentParams(Intent intent)
	{
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 600);
		intent.putExtra("outputY", 600);
		intent.putExtra("noFaceDetection", true); // no face detection
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (requestCode)
		{
		case PIC_FROM_CAMERA: // 拍照
			try 
			{
				cropImageUriByTakePhoto();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			break;
		case PIC_FROM＿LOCALPHOTO:
			try
			{
				if (photoUri != null) 
				{
					Bitmap bitmap = decodeUriAsBitmap(photoUri);
					titleimg.setImageBitmap(bitmap);
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			break;
		}
	}

	private Bitmap decodeUriAsBitmap(Uri uri)
	{
		Bitmap bitmap = null;
		try 
		{
			bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		return bitmap;
	}
	
}
