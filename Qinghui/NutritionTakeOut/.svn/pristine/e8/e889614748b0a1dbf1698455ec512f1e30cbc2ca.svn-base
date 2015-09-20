package com.example.nutrition.order;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.cart.ShoppingCart;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBHelper;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.example.nutrition.order.adapter.CommitOrderAdpter;
import com.example.nutrition.order.vo.CommintOrder;
import com.example.nutritionTakeout.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends Activity{
	private Spinner spinner;
	private List<String> data_list;
	private ArrayList<CommintOrder> list = new ArrayList<CommintOrder>();;
	private ArrayAdapter<String> arr_adapter;
//	String name , price , number;
	private TextView address;
	private Button btn , back;
	private ListView commint_listview;
	private TextView biches,biches_num,biches_price,biches_money;


	private SQLiteDatabase db;
	private CarDBUtils carDbUtils;
	private List<Shop> listShop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirmation_order);
		spinner = (Spinner) findViewById(R.id.spinner);
		btn = (Button) findViewById(R.id.btn);
		back = (Button) findViewById(R.id.back);
		biches = (TextView) findViewById(R.id.biches);
		biches_num = (TextView) findViewById(R.id.biches_num);
		biches_price = (TextView) findViewById(R.id.biches_price);
		biches_money = (TextView) findViewById(R.id.biches_money);
		commint_listview = (ListView) findViewById(R.id.commint_listview);

		// ˝æ›
		data_list = new ArrayList<String>();
		data_list.add("¡¢º¥ÀÕ≤Õ");
		data_list.add("…‘∫ÛÀÕ≤Õ");


		CarDBHelper helper = new CarDBHelper(getApplicationContext());
		db = helper.getWritableDatabase();
		carDbUtils = new CarDBUtils(db);
		listShop =  carDbUtils.query();

//		Toast.makeText(getApplicationContext(), listShop.toString(),1).show();



		//  ≈‰∆˜
		arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
		//…Ë÷√—˘ Ω
		arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//º”‘ÿ  ≈‰∆˜
		spinner.setAdapter(arr_adapter);

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Order.this, ShoppingCart.class);
				startActivity(intent);
			}
		});
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("namess",1);
				intent.setClass(Order.this, MainActivity.class);
				startActivity(intent);
			}
		});

		commint_listview.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				if(convertView == null){
					holder=new ViewHolder();
					convertView =LayoutInflater.from(getApplicationContext()).inflate(R.layout.order_show,null);
					holder.name=(TextView) convertView.findViewById(R.id.biches);
					holder.price=(TextView) convertView.findViewById(R.id.biches_price);
					holder.number=(TextView) convertView.findViewById(R.id.biches_num);
					holder.money=(TextView) convertView.findViewById(R.id.biches_money);
					convertView.setTag(holder);
				}else{
					holder = (ViewHolder)convertView.getTag(); 	
				}
				holder.name.setText(listShop.get(position).getName());
				holder.price.setText(listShop.get(position).getPrice()+"");
				holder.number.setText(listShop.get(position).getNumber()+"");
				holder.money.setText(listShop.get(position).getNumber()*listShop.get(position).getPrice()+"");

				return convertView;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return listShop.size();
			}
		});  


	}
	
	static class ViewHolder{
		TextView name,price,number,money;
	}
}
