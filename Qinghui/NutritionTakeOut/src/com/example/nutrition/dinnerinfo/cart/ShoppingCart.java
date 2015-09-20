package com.example.nutrition.dinnerinfo.cart;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.adapter.CartAdapter;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBHelper;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.example.nutrition.order.Order;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

public class ShoppingCart extends Activity {
	int count = 1;
	Context mContext;
	private ListView lv;
	private ImageView imgBack,imgDelete;
	private TextView tvSum;
	private List<Shop> listShop;
	private DbUtils dbUtils;
	private String name,price,number;
	private CartAdapter adapter;
	private Button balance;
	private SQLiteDatabase db;
	private CarDBUtils carDbUtils;
	private int sumPrice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ����ǩ��
		setContentView(R.layout.shopping_car_info);
		//��ʼ�� �ؼ�
		init();
		mContext = this;
		CarDBHelper helper = new CarDBHelper(mContext);
		db = helper.getWritableDatabase();
		carDbUtils = new CarDBUtils(db);
		listShop =  carDbUtils.query();
//		Log.w("tag", listShop.toString());
		for(int i=0;i<listShop.size();i++){
			sumPrice+=listShop.get(i).getPrice()*listShop.get(i).getNumber();
			name = listShop.get(i).getName();
			price = String.valueOf(listShop.get(i).getPrice());
			number = String.valueOf(listShop.get(i).getNumber());
		}
		tvSum.setText("С�ƣ���"+sumPrice);
		adapter = new CartAdapter(getApplicationContext(),tvSum, listShop,carDbUtils,sumPrice);
		lv.setAdapter(adapter);
		imgBack.setOnClickListener(l);//����
		imgDelete.setOnClickListener(l);//ɾ����ť
		balance.setOnClickListener(l);//����
	}

	//��ʼ��
	public void init(){
		lv = (ListView)findViewById(R.id.shopping_lv);
		imgBack = (ImageView)findViewById(R.id.imgBack);
		imgDelete = (ImageView)findViewById(R.id.imgdelete);
		tvSum = (TextView)findViewById(R.id.tvSum);
		balance=(Button) findViewById(R.id.balance);

	}

	//����¼�
	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch(v.getId()){

			case R.id.imgBack://���˰�ť
				finish();
				break;
			case R.id.balance://���㰴ť
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), Order.class);
				//				Log.i("tag", name);
				intent.putExtra("name", name);
				intent.putExtra("price", price);
				intent.putExtra("number", number);
				startActivity(intent);

				break;	
			case R.id.imgdelete://ɾ����ť
				//���� �Ի���
				AlertDialog.Builder builder = new Builder(mContext);
				builder.setCancelable(false);//��� �Ի���֮�� ���ر� д��
				builder.setTitle("Ӫ������");
				builder.setMessage("ɾ�����ﳵ������в�Ʒ��");
				builder.setPositiveButton("ȷ��", new Dialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// ȷ��
						carDbUtils.delete();
						finish();
					}
				});
				builder.setNegativeButton("ȡ��", new Dialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				builder.create().show();//չʾ Dialog ��
				break;
			}
		}


	};
}