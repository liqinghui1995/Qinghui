package com.example.nutrition.dinnerinfo.cart.helper;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nutrition.dinnerinfo.vo.Shop;

public class CarDBUtils {
	private SQLiteDatabase db;
	
	public CarDBUtils(SQLiteDatabase db) {
		super();
		this.db = db;
	}
	/**
	 * 保存
	 */
	public void save(Shop shop){
		db.execSQL("insert into shoppingCar(name,price,count,dishesid) values('"+shop.getName()+"',"+shop.getPrice()+","+shop.getNumber()+","+shop.getDishesid()+")");
	}
	/**
	 * 删除全部
	 */
	public void delete(){
		db.execSQL("delete from shoppingCar ");
	}
	/**
	 * 删除条
	 * @param id
	 */
	public void deleteid(int id){
		db.execSQL("delete from shoppingCar where id = "+id);
	}
	/**
	 * 判断这一条数据是否存在
	 * @param id
	 * @return
	 */
	public boolean queryid(int dishesid){
		Cursor cursor = db.rawQuery("select * from shoppingCar where dishesid = "+dishesid,null);
		boolean flag = false;
		if(cursor.moveToNext()){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	/**
	 * 查询全部
	 * @return
	 */
	public List<Shop> query(){
		List<Shop> list = new ArrayList<Shop>();
		Cursor cursor = db.rawQuery("select * from shoppingCar",null);
		while(cursor.moveToNext()){
			Shop shop = new Shop();
			shop.setId(cursor.getInt(cursor.getColumnIndex("id")));
			shop.setName(cursor.getString(cursor.getColumnIndex("name")));
			shop.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
			shop.setNumber(cursor.getInt(cursor.getColumnIndex("count")));
			list.add(shop);
		}
		return list;
	}
	
	/**
	 * 修改价格和数量
	 */
	public void udate(int id,int count){
		db.execSQL("update shoppingCar set count = "+count+" where id = "+id);
	}
	/**
	 * 修改数量
	 * @param id
	 * @param price
	 * @param count
	 */
	public void udateCount(int dishesid,int count){
		db.execSQL("update shoppingCar set count = "+count+" where dishesid = "+dishesid);
	}
	
	
}
