package com.example.nutrition.diningroom.vo;

import java.io.Serializable;

public class DiningRoom implements Serializable {

	/**
	 * 餐厅 信息
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	private String DiningRoomName; /*餐厅名字*/
	private String DiningRoomAddress; /*餐厅地址*/
	private String DiningRoomCurrentDistance; /* 最近餐厅距离*/
	private String DiningRoomSold;  /* 已售*/
	private String DiningRoomImage;  /*餐厅图片*/
	private String DiningRoomLevel; /*餐厅级别 星星*/
	private String DiningRoomClasses;  /*菜的类别*/
	private String DiningRoomStartPrice;      /*起步价*/
	private String DiningRoomFreight;   /*外送费*/
	private String  DiningRoomSendTime;  /*送餐时间*/
	private String  DiningRoomUserAppraise;   /*用户评价*/
	private String  DiningRoomActivityFavorable;    /* 优惠活动*/
	private  String DiningRoomIDPhoto;   /*餐厅证件照*/
	private String DiningRoomShopHours;  /* 营业时间*/
	private String DiningRoomIntroduce;  /*餐厅介绍*/

	public DiningRoom(int id, String diningRoomName,
			String diningRoomAddress,
			String diningRoomCurrentDistance,
			String diningRoomSold, String diningRoomImage,
			String diningRoomLevel, String diningRoomClasses,
			String diningRoomStartPrice,
			String diningRoomFreight,
			String diningRoomSendTime,
			String diningRoomUserAppraise,
			String diningRoomActivityFavorable,
			String diningRoomIDPhoto,
			String diningRoomShopHours,
			String diningRoomIntroduce) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DiningRoom [id=" + id + ", DiningRoomName="
				+ DiningRoomName + ", DiningRoomAddress="
				+ DiningRoomAddress
				+ ", DiningRoomCurrentDistance="
				+ DiningRoomCurrentDistance
				+ ", DiningRoomSold=" + DiningRoomSold
				+ ", DiningRoomImage=" + DiningRoomImage
				+ ", DiningRoomLevel=" + DiningRoomLevel
				+ ", DiningRoomClasses=" + DiningRoomClasses
				+ ", DiningRoomStartPrice="
				+ DiningRoomStartPrice + ", DiningRoomFreight="
				+ DiningRoomFreight + ", DiningRoomSendTime="
				+ DiningRoomSendTime
				+ ", DiningRoomUserAppraise="
				+ DiningRoomUserAppraise
				+ ", DiningRoomActivityFavorable="
				+ DiningRoomActivityFavorable
				+ ", DiningRoomIDPhoto=" + DiningRoomIDPhoto
				+ ", DiningRoomShopHours="
				+ DiningRoomShopHours
				+ ", DiningRoomIntroduce="
				+ DiningRoomIntroduce + "]";
	}


}
