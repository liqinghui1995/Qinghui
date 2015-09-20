package com.cblue.modual.orderfood.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity

public class DiningRoom implements Serializable {
 
	@Id @GeneratedValue
	private int id;
	@Column(length=20)
	private String DiningRoomName; /*餐厅名字*/
	@Column(length=20)
	private String DiningRoomAddress; /*餐厅地址*/
	@Column(length=20)
	private String DiningRoomCurrentDistance; /* 最近餐厅距离*/
	@Column(length=20)
	private String DiningRoomSold;  /* 已售*/
	@Column(length=50)
	private String DiningRoomImage;  /*餐厅图片*/
	@Column(length=50)
	private String DiningRoomLevel; /*餐厅级别 星星*/
	@Column(length=50)
	private String DiningRoomClasses;  /*菜的类别*/
	@Column(length=20)
	private String DiningRoomStartPrice;      /*起步价*/
	@Column(length=50)
	private String DiningRoomFreight;   /*外送费*/
	@Column(length=50)
	private String  DiningRoomSendTime;  /*送餐时间*/
	@Column(length=50)
	private String  DiningRoomUserAppraise;   /*用户评价*/
	@Column(length=50)
	private String  DiningRoomActivityFavorable;    /* 优惠活动*/
	@Column(length=50)
	private  String DiningRoomIDPhoto;   /*餐厅证件照*/
	@Column(length=50)
	private String DiningRoomShopHours;  /* 营业时间*/
	@Column(length=255)
	private String DiningRoomIntroduce;  /*餐厅介绍*/
	@Column(length=50)
	private String  DiningRoomConn;  /*餐厅与菜品关联*/
	public DiningRoom(int id, String diningRoomName, String diningRoomAddress,
			String diningRoomCurrentDistance, String diningRoomSold,
			String diningRoomImage, String diningRoomLevel,
			String diningRoomClasses, String diningRoomStartPrice,
			String diningRoomFreight, String diningRoomSendTime,
			String diningRoomUserAppraise, String diningRoomActivityFavorable,
			String diningRoomIDPhoto, String diningRoomShopHours,
			String diningRoomIntroduce, String diningRoomConn) {
		super();
		this.id = id;
		DiningRoomName = diningRoomName;
		DiningRoomAddress = diningRoomAddress;
		DiningRoomCurrentDistance = diningRoomCurrentDistance;
		DiningRoomSold = diningRoomSold;
		DiningRoomImage = diningRoomImage;
		DiningRoomLevel = diningRoomLevel;
		DiningRoomClasses = diningRoomClasses;
		DiningRoomStartPrice = diningRoomStartPrice;
		DiningRoomFreight = diningRoomFreight;
		DiningRoomSendTime = diningRoomSendTime;
		DiningRoomUserAppraise = diningRoomUserAppraise;
		DiningRoomActivityFavorable = diningRoomActivityFavorable;
		DiningRoomIDPhoto = diningRoomIDPhoto;
		DiningRoomShopHours = diningRoomShopHours;
		DiningRoomIntroduce = diningRoomIntroduce;
		DiningRoomConn = diningRoomConn;
	}
	public DiningRoom() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiningRoomName() {
		return DiningRoomName;
	}
	public void setDiningRoomName(String diningRoomName) {
		DiningRoomName = diningRoomName;
	}
	public String getDiningRoomAddress() {
		return DiningRoomAddress;
	}
	public void setDiningRoomAddress(String diningRoomAddress) {
		DiningRoomAddress = diningRoomAddress;
	}
	public String getDiningRoomCurrentDistance() {
		return DiningRoomCurrentDistance;
	}
	public void setDiningRoomCurrentDistance(String diningRoomCurrentDistance) {
		DiningRoomCurrentDistance = diningRoomCurrentDistance;
	}
	public String getDiningRoomSold() {
		return DiningRoomSold;
	}
	public void setDiningRoomSold(String diningRoomSold) {
		DiningRoomSold = diningRoomSold;
	}
	public String getDiningRoomImage() {
		return DiningRoomImage;
	}
	public void setDiningRoomImage(String diningRoomImage) {
		DiningRoomImage = diningRoomImage;
	}
	public String getDiningRoomLevel() {
		return DiningRoomLevel;
	}
	public void setDiningRoomLevel(String diningRoomLevel) {
		DiningRoomLevel = diningRoomLevel;
	}
	public String getDiningRoomClasses() {
		return DiningRoomClasses;
	}
	public void setDiningRoomClasses(String diningRoomClasses) {
		DiningRoomClasses = diningRoomClasses;
	}
	public String getDiningRoomStartPrice() {
		return DiningRoomStartPrice;
	}
	public void setDiningRoomStartPrice(String diningRoomStartPrice) {
		DiningRoomStartPrice = diningRoomStartPrice;
	}
	public String getDiningRoomFreight() {
		return DiningRoomFreight;
	}
	public void setDiningRoomFreight(String diningRoomFreight) {
		DiningRoomFreight = diningRoomFreight;
	}
	public String getDiningRoomSendTime() {
		return DiningRoomSendTime;
	}
	public void setDiningRoomSendTime(String diningRoomSendTime) {
		DiningRoomSendTime = diningRoomSendTime;
	}
	public String getDiningRoomUserAppraise() {
		return DiningRoomUserAppraise;
	}
	public void setDiningRoomUserAppraise(String diningRoomUserAppraise) {
		DiningRoomUserAppraise = diningRoomUserAppraise;
	}
	public String getDiningRoomActivityFavorable() {
		return DiningRoomActivityFavorable;
	}
	public void setDiningRoomActivityFavorable(String diningRoomActivityFavorable) {
		DiningRoomActivityFavorable = diningRoomActivityFavorable;
	}
	public String getDiningRoomIDPhoto() {
		return DiningRoomIDPhoto;
	}
	public void setDiningRoomIDPhoto(String diningRoomIDPhoto) {
		DiningRoomIDPhoto = diningRoomIDPhoto;
	}
	public String getDiningRoomShopHours() {
		return DiningRoomShopHours;
	}
	public void setDiningRoomShopHours(String diningRoomShopHours) {
		DiningRoomShopHours = diningRoomShopHours;
	}
	public String getDiningRoomIntroduce() {
		return DiningRoomIntroduce;
	}
	public void setDiningRoomIntroduce(String diningRoomIntroduce) {
		DiningRoomIntroduce = diningRoomIntroduce;
	}
	public String getDiningRoomConn() {
		return DiningRoomConn;
	}
	public void setDiningRoomConn(String diningRoomConn) {
		DiningRoomConn = diningRoomConn;
	}
	 
}
