package com.cblue.modual.nourishmentfood.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cblue.modual.orderfood.bean.DiningRoom;

@Entity
public class NourishmentFood implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//菜品id
	@Id @GeneratedValue
	private int id;
	//菜品名称
	@Column(length=255)
	private String food_name;
	//菜品图片地址
	@Column(length=255)
	private String imgurl;
	//菜品价格
	@Column(length=20)
	private double food_price;
	//菜品销售量
	@Column(length=20)
	private int sales_volume;
	//标示
	@Column(length=20)
	private String flag;
	//菜品简介
	@Column(length=255)
	private String foodintro;
	//外表连接标示
	@Column(length=20)
	private int shop_id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public double getFood_price() {
		return food_price;
	}

	public void setFood_price(double food_price) {
		this.food_price = food_price;
	}

	public int getSales_volume() {
		return sales_volume;
	}

	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFoodintro() {
		return foodintro;
	}

	public void setFoodintro(String foodintro) {
		this.foodintro = foodintro;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public NourishmentFood() {
		super();
	}
	public NourishmentFood(String food_name, String imgurl, double food_price,
			int sales_volume, String flag, String foodintro, int shop_id) {
		super();
		this.food_name = food_name;
		this.imgurl = imgurl;
		this.food_price = food_price;
		this.sales_volume = sales_volume;
		this.flag = flag;
		this.foodintro = foodintro;
		this.shop_id = shop_id;
	}

	public NourishmentFood(int id, String food_name, String imgurl,
			double food_price, int sales_volume, String flag, String foodintro,
			int shop_id) {
		super();
		this.id = id;
		this.food_name = food_name;
		this.imgurl = imgurl;
		this.food_price = food_price;
		this.sales_volume = sales_volume;
		this.flag = flag;
		this.foodintro = foodintro;
		this.shop_id = shop_id;
	}

	@Override
	public String toString() {
		return "NourishmentFood [id=" + id + ", food_name=" + food_name
				+ ", imgurl=" + imgurl + ", food_price=" + food_price
				+ ", sales_volume=" + sales_volume + ", flag=" + flag
				+ ", foodintro=" + foodintro + ", shop_id=" + shop_id + "]";
	}
	
	
}
