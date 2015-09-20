package com.example.nutrition.user.vo;

import java.io.Serializable;

public class UserAddressVo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String address;
	private int id;
	private int userid;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserAddressVo [address=" + address + ", id=" + id + ", userid="
				+ userid + "]";
	}
	public UserAddressVo(String address, int id, int userid) {
		super();
		this.address = address;
		this.id = id;
		this.userid = userid;
	}
	public UserAddressVo() {
		super();
	}
	

}
