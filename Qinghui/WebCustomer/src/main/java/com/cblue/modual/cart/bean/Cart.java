package com.cblue.modual.cart.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Cart implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Column(length=20)
	private String cart_name;//菜品名称
	@Column(length=20)
	private String cart_price;//菜品价格
	@Column(length=20)
	private String cart_number;//菜品数量
	@Column(length=20)
	private int cart_alll;//菜品总价
	public Cart(int id, String cart_name, String cart_price,
			String cart_number, int cart_alll) {
		super();
		this.id = id;
		this.cart_name = cart_name;
		this.cart_price = cart_price;
		this.cart_number = cart_number;
		this.cart_alll = cart_alll;
	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCart_name() {
		return cart_name;
	}
	public void setCart_name(String cart_name) {
		this.cart_name = cart_name;
	}
	public String getCart_price() {
		return cart_price;
	}
	public void setCart_price(String cart_price) {
		this.cart_price = cart_price;
	}
	public String getCart_number() {
		return cart_number;
	}
	public void setCart_number(String cart_number) {
		this.cart_number = cart_number;
	}
	public int getCart_alll() {
		return cart_alll;
	}
	public void setCart_alll(int cart_alll) {
		this.cart_alll = cart_alll;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", cart_name=" + cart_name + ", cart_price="
				+ cart_price + ", cart_number=" + cart_number + ", cart_alll="
				+ cart_alll + "]";
	}
	
	
	
	
}
