package com.example.nutrition.nourishment.bean;

public class NourishmentFood {
	
	private int id;
	private String food_name;
	private String imgurl;
	private double food_price;
	private int sales_volume;
	private String flag;
	private String foodintro;
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
	public NourishmentFood() {
		super();
	}
	
}
