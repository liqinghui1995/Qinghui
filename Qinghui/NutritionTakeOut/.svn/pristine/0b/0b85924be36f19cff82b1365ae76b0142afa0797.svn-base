package com.example.nutrition.dinnerinfo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.constant.Constant;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAdapter extends BaseAdapter {
//private	int sum=0;
	Context mContext;
	int count ;
	private TextView tvSum;
	List<Shop> listShop;
	private DbUtils dbutil;
	private CarDBUtils carDBUtils;
	private int sumprice;
	private int poi;
	//构造方法
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listShop.size();
	}

	public CartAdapter(Context mContext, TextView tvSum, List<Shop> listShop,CarDBUtils carDBUtils,int sumPrice) {
		super();
		this.mContext = mContext;
		this.tvSum = tvSum;
		this.listShop = listShop;
		this.carDBUtils = carDBUtils;
		this.sumprice = sumPrice;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder viewHolder;
		if(view==null){
			view = LayoutInflater.from(mContext).inflate(R.layout.shopping_listview_info, null);
			viewHolder = new ViewHolder();
			viewHolder.imgMinus = (ImageView)view.findViewById(R.id.imgMinus);
			viewHolder.imgPlus = (ImageView)view.findViewById(R.id.imgPlus);
			viewHolder.tvName = (TextView)view.findViewById(R.id.shopping_tvname);
			viewHolder.tvPrice = (TextView)view.findViewById(R.id.price_tv);
			viewHolder.tvCount = (TextView)view.findViewById(R.id.counnt_tv);
			view.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) view.getTag();
		}
		final Shop shop = listShop.get(position);
		count = shop.getNumber();
		viewHolder.tvName.setText(listShop.get(position).getName());
		viewHolder.tvPrice.setText("￥"+ listShop.get(position).getPrice() +"x");
		viewHolder.tvCount.setText(listShop.get(position).getNumber()+"");
//		Constant.sum = (int) (listShop.get(position).getPrice()*count);
		viewHolder.imgPlus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(poi==position){
					count+=1;
				}else{
					count = shop.getNumber();
					count++;
				}
				poi = position;
				carDBUtils.udate(shop.getId(), count);
				viewHolder.tvCount.setText(count+"");
				sumprice += listShop.get(position).getPrice();
				tvSum.setText("小计：￥"+sumprice);
			}
		});
		viewHolder.imgMinus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(count>0){
					count--;
	     		}
				viewHolder.tvCount.setText(count+"");
				Constant.sum =(int) (listShop.get(position).getPrice()*count);
				tvSum.setText("小计：￥"+Constant.sum);
			}
		});
		
		return view;
	}
	
	static class ViewHolder{
		ImageView imgPlus;
		ImageView imgMinus;
		TextView tvName;
		TextView tvPrice;
		TextView tvCount;
	}
	

}
