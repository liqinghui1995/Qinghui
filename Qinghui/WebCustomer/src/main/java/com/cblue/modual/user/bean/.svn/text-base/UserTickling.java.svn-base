package com.cblue.modual.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserTickling implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Column(length = 20)
	private int userid;
	@Column(length = 200)
	private String content;
	@Column(length = 20)
	private String contact;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "UserTickling [id=" + id + ", userid=" + userid + ", content="
				+ content + "]";
	}
	public UserTickling(int id, int userid, String content) {
		super();
		this.id = id;
		this.userid = userid;
		this.content = content;
	}
	public UserTickling() {
		super();
	}
	
}
