package com.example.nutrition.dinnerinfo.cart.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.baidu.mapapi.utils.OpenClientUtil;

public class CarDBHelper extends SQLiteOpenHelper{
	private static String DBNAME = "shopCar";
	private static int version = 1;
	public CarDBHelper(Context context) {
		super(context, DBNAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table shoppingCar (id integer primary key autoincrement,name varchar,price integer,count integer,dishesid integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
