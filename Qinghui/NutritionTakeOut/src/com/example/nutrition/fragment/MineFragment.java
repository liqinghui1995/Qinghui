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
 * �ҵ�
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
	private final int PIC_FROM��LOCALPHOTO = 0;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_main, null);

		sp = getActivity().getSharedPreferences("mynewsset",
				getActivity().MODE_PRIVATE);

		json_chuan = sp.getString("reslut", "��½/ע��");

		Log.i("jsonchuan", json_chuan);
		initView(v);
		popupwindow();
		return v;

	}

	public void initView(View v) {
		// TODO Auto-generated method stub
		// �û���Ϣ��ʾ
		tv = (TextView) v.findViewById(R.id.user_textView);
		if (json_chuan.equals("��½/ע��")) {
			tv.setText(json_chuan);
		} else if(json_chuan.equals("")){
			tv.setText("��½/ע��");
		}else {
			list = FastJsonUtil.getList(json_chuan, UserBean.class);
			tv.setText(list.get(0).getUser_nickname());
		}
		// ��½ע��
		tv.setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), LoginMainActivity.class));
			}
		});
		// �޸��ǳ�
		v.findViewById(R.id.changename_img).setOnClickListener(new

		OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("��½/ע��")) {
					Toast.makeText(getActivity(), "���ȵ�¼������", 1).show();
				} else {
					Intent inten = new Intent(getActivity(), ChangeNameActivity.class);
					startActivity(inten);
				}

			}
		});
		// �ҵ���Ǳ�
		v.findViewById(R.id.setting_mypentacles).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Mypentacles.class));
			}
		});
		// �������
		v.findViewById(R.id.setting_feedback).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Feedback.class));
			}
		});
		// �Ƽ�Ӯ��Ʒ
		v.findViewById(R.id.setting_share).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), Share.class));
			}
		});
		// �޸�����
		v.findViewById(R.id.changepassword_immg).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("��½/ע��")) {
					Toast.makeText(getActivity(), "���ȵ�¼������", 1).show();
				} else {
					startActivity(new Intent(getActivity
							(), ChangePasswordActivity.class));
				}
			}
		});
		// ���ӵ�ַ
		v.findViewById(R.id.my_add_adress_immg).setOnClickListener(new
		OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (json_chuan.equals("��½/ע��")) {
					Toast.makeText(getActivity(), "���ȵ�¼������", 1).show();
				} else {
					Intent intent = new Intent(getActivity(), Add_adress_Activity.class);
					intent.putExtra("userBean", list.get(0));
					startActivity(intent);
				}
			}
		});
		// ����
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
				//��������ʽ��ʾpopwindow
				popupWindow.showAsDropDown(v);
						//��popwindow��ʾָ��λ��
				popupWindow.showAtLocation(titleimg,
									Gravity.AXIS_PULL_BEFORE, 0, 40);
			}
		});
	}
	private void popupwindow() {
		//��ȡ��Ļ���
		WindowManager wm = getActivity().getWindowManager();
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
	    //����popwindow
		View root = getActivity().getLayoutInflater().inflate(R.layout.title_img_popwindow, null);
		TextView camer = (TextView) root.findViewById(R.id.camera);
		TextView photoalbum = (TextView) root.findViewById(R.id.photoalbum);
		camer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "����", Toast.LENGTH_SHORT).show();
				doHandlerPhoto(PIC_FROM_CAMERA);// �û�����˴��������ȡ
			}
		});
		photoalbum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "ϵͳ���", Toast.LENGTH_SHORT).show();
				doHandlerPhoto(PIC_FROM��LOCALPHOTO);// �������ȥ��ȡ
			}
		});
		popupWindow = new PopupWindow(root, 600, 400);
		// ����Ҫ����PopuWindow�ı���������Ҫ��PopuWindow��ʾ֮ǰ�������ı�������Ȼû��Ч����
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		// �ⲿ�����ʧ
		//��ȡpopupwindow�رհ�ť����ʵ�ֹرռ���
	}
	
	/**
	 * ���ݲ�ͬ��ʽѡ��ͼƬ����ImageView
	 * @param type 0-�������ѡ�񣬷�0Ϊ����
	 */
	private void doHandlerPhoto(int type)
	{
		try
		{
			//����ü����ͼƬ�ļ�
			File pictureFileDir = new File(Environment.getExternalStorageDirectory(), "/upload");
			if (!pictureFileDir.exists()) {
				pictureFileDir.mkdirs();
			}
			File picFile = new File(pictureFileDir, "upload.jpeg");
			if (!picFile.exists()) {
				picFile.createNewFile();
			}
			photoUri = Uri.fromFile(picFile);
			
			if (type==PIC_FROM��LOCALPHOTO)
			{
				Intent intent = getCropImageIntent();
				startActivityForResult(intent, PIC_FROM��LOCALPHOTO);
			}else
			{
				Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
				startActivityForResult(cameraIntent, PIC_FROM_CAMERA);
			}

		} catch (Exception e)
		{
			Log.i("HandlerPicError", "����ͼƬ���ִ���");
		}
	}

	/**
	 * ����ͼƬ��������
	 */
	public Intent getCropImageIntent() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		intent.setType("image/*");
		setIntentParams(intent);
		return intent;
	}

	/**
	 * �����ü�
	 */
	private void cropImageUriByTakePhoto() {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(photoUri, "image/*");
		setIntentParams(intent);
		startActivityForResult(intent, PIC_FROM��LOCALPHOTO);
	}

	/**
	 * ���ù��ò���
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
		case PIC_FROM_CAMERA: // ����
			try 
			{
				cropImageUriByTakePhoto();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			break;
		case PIC_FROM��LOCALPHOTO:
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
