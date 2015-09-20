package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserGiftRecord implements Serializable{
	/**
	 * 兑换记录
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	@Column(length=20)
	private int userid;
	@Column(length=20)
	private int giftid;
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
	public int getGiftid() {
		return giftid;
	}
	public void setGiftid(int giftid) {
		this.giftid = giftid;
	}
	@Override
	public String toString() {
		return "UserGiftRecord [id=" + id + ", userid=" + userid + ", giftid="
				+ giftid + "]";
	}
	public UserGiftRecord(int id, int userid, int giftid) {
		super();
		this.id = id;
		this.userid = userid;
		this.giftid = giftid;
	}
	
	public UserGiftRecord() {
		super();
	}
	
}
