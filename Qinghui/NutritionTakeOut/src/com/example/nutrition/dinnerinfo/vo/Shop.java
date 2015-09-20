package com.example.nutrition.dinnerinfo.vo;

import java.io.Serializable;

public class Shop implements Serializable{

	private int id;
	private String name;
	private int price;
	private int number;
	private int dishesid;
	 
	public int getDishesid() {
		return dishesid;
	}
	public void setDishesid(int dishesid) {
		this.dishesid = dishesid;
	}
	public Shop() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", price=" + price
				+ ", number=" + number + "]";
	}
	
	
	
}
