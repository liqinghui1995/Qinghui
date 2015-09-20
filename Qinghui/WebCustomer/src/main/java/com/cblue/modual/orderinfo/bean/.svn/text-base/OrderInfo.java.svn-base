package com.cblue.modual.orderinfo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderInfo implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Column(length=20)
	private String order_time;//订单时间
	@Column(length=20)
	private String order_restaurant;//订单餐厅名称
	@Column(length=20)
	private String order_money;//订单总金额
	@Column(length=20)
	private int order_number;//订单数量
	@Column(length=20)
	private String order_info;//订单是否成功
	@Column(length=20)
	private String order_logo;//餐厅标志
	
	
	
	public OrderInfo(int id, String order_time, String order_restaurant,
			String order_money, int order_number, String order_info,
			String order_logo) {
		super();
		this.id = id;
		this.order_time = order_time;
		this.order_restaurant = order_restaurant;
		this.order_money = order_money;
		this.order_number = order_number;
		this.order_info = order_info;
		this.order_logo = order_logo;
	}
	
	public OrderInfo() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getOrder_restaurant() {
		return order_restaurant;
	}
	public void setOrder_restaurant(String order_restaurant) {
		this.order_restaurant = order_restaurant;
	}
	public String getOrder_money() {
		return order_money;
	}
	public void setOrder_money(String order_money) {
		this.order_money = order_money;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public String getOrder_info() {
		return order_info;
	}
	public void setOrder_info(String order_info) {
		this.order_info = order_info;
	}
	public String getOrder_logo() {
		return order_logo;
	}
	public void setOrder_logo(String order_logo) {
		this.order_logo = order_logo;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", order_time=" + order_time
				+ ", order_restaurant=" + order_restaurant + ", order_money="
				+ order_money + ", order_number=" + order_number
				+ ", order_info=" + order_info + ", order_logo=" + order_logo
				+ "]";
	}
	
	

}
