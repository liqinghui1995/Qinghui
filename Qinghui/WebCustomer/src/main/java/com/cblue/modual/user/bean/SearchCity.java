package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class SearchCity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private int districtid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	@Override
	public String toString() {
		return "SearchCity [id=" + id + ", city=" + city + ", districtid="
				+ districtid + "]";
	}
	public SearchCity(int id, String city, int districtid) {
		super();
		this.id = id;
		this.city = city;
		this.districtid = districtid;
	}
	public SearchCity() {
		super();
	}
}
