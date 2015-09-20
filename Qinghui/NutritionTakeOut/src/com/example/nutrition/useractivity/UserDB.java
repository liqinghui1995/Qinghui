package com.example.nutrition.useractivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper{

	public static int VERSION = 1;

	public UserDB(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public UserDB(Context context, String name, int version) {
		this(context, name, null, version);
	}

	public UserDB(Context context, String name) {
		this(context, name, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("onCreate()方法别调用了");
		String sql = "create table user(id int, change_name_edittext varchar(20),change_phone_edittext varchar(20),change_address_edittext varchar(20))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
