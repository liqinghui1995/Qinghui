package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserGift implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;//id
	@Column(length = 20)
	private String name;//名字
	@Column(length = 20)
	private String imgurl;//图片路径
	@Column(length = 20)
	private int price;//价格
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "UserGift [id=" + id + ", name=" + name + ", imgurl=" + imgurl
				+ ", price=" + price + "]";
	}
	public UserGift(int id, String name, String imgurl, int price) {
		super();
		this.id = id;
		this.name = name;
		this.imgurl = imgurl;
		this.price = price;
	}
	public UserGift() {
		super();
	}
	
}
