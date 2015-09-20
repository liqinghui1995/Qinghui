package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserAddress implements Serializable{
	/**
	 * 用户地址管理表
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;//id
	@Column(length = 255)
	private String address;//地址
	@Column(length = 20)
	private int userid;//用户表id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", address=" + address + ", userid="
				+ userid + "]";
	}
	public UserAddress(int id, String address, int userid) {
		super();
		this.id = id;
		this.address = address;
		this.userid = userid;
	}
	public UserAddress() {
		super();
	}
	
}
