package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class SearchDistrict implements Serializable{

	private static final long serialVersionUID = -4133306924295063051L;
	@Id @GeneratedValue
	private int id;
	@Column(length = 20)
	private String district;
	@Column(length = 20)
	private int cityid;
	
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public SearchDistrict(int id, String district, int cityid) {
		super();
		this.id = id;
		this.district = district;
		this.cityid = cityid;
	}
	public SearchDistrict() {
		super();
	}
	@Override
	public String toString() {
		return "SearchDistrict [id=" + id + ", district=" + district
				+ ", cityid=" + cityid + "]";
	}
}
