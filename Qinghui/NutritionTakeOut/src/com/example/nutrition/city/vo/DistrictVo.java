package com.example.nutrition.city.vo;

import java.io.Serializable;

public class DistrictVo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int cityid;
	private String district;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "DistrictVo [id=" + id + ", cityid=" + cityid + ", district="
				+ district + "]";
	}
	public DistrictVo(int id, int cityid, String district) {
		super();
		this.id = id;
		this.cityid = cityid;
		this.district = district;
	}
	public DistrictVo() {
		super();
	}
	

}
