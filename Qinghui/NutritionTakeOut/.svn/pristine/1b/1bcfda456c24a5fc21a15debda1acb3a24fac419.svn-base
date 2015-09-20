package com.example.nutrition.dinnerinfo.constant;

import java.util.ArrayList;

import com.example.nutrition.dinnerinfo.vo.Shop;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

public class Constant {

	public static int sum;//购物车的总计
	public static ArrayList<Shop> listShop;
	public static DbUtils dbUtils;

	public static void find(){
		try {
			listShop = (ArrayList<Shop>) dbUtils.findAll(Shop.class);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
