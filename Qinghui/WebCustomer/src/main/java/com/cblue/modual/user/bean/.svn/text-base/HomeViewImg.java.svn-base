package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class HomeViewImg implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Column(length = 20)
	private String viewpagerurl;
	@Column(length = 20)
	private String imgurl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getViewpagerurl() {
		return viewpagerurl;
	}
	public void setViewpagerurl(String viewpagerurl) {
		this.viewpagerurl = viewpagerurl;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public HomeViewImg(int id, String viewpagerurl, String imgurl) {
		super();
		this.id = id;
		this.viewpagerurl = viewpagerurl;
		this.imgurl = imgurl;
	}
	public HomeViewImg() {
		super();
	}
	@Override
	public String toString() {
		return "HomeViewImg [id=" + id + ", viewpagerurl=" + viewpagerurl
				+ ", imgurl=" + imgurl + "]";
	}
	
}
