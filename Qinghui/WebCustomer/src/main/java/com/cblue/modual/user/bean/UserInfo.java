package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int user_id;
	@Column(length=20)
	private String user_name;//账号
	@Column(length=20)
	private String user_password;//密码
	@Column(length=200)
	private String addressid;//地址
	@Column(length=20)
	private String ticklingid;//手机号
	@Column(length=20)
	private String user_nickname;//昵称
	@Column(length=20)
	private int user_coin;//星克币
	@Column(length=20)
	private int user_record;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getTicklingid() {
		return ticklingid;
	}
	public void setTicklingid(String ticklingid) {
		this.ticklingid = ticklingid;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getUser_coin() {
		return user_coin;
	}
	public void setUser_coin(int user_coin) {
		this.user_coin = user_coin;
	}
	public int getUser_record() {
		return user_record;
	}
	public void setUser_record(int user_record) {
		this.user_record = user_record;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", addressid="
				+ addressid + ", ticklingid=" + ticklingid + ", user_nickname="
				+ user_nickname + ", user_coin=" + user_coin + ", user_record="
				+ user_record + "]";
	}

}
