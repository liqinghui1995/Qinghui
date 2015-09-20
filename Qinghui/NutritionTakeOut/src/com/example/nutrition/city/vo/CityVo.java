package com.example.nutrition.city.vo;

public class CityVo {
	private int id;
	private String city;
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
		return "CityVo [id=" + id + ", city=" + city + ", districtid="
				+ districtid + "]";
	}
	public CityVo(int id, String city, int districtid) {
		super();
		this.id = id;
		this.city = city;
		this.districtid = districtid;
	}
	public CityVo() {
		super();
	}
	
	
}
