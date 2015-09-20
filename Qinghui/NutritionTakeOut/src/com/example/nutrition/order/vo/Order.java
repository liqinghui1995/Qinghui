package com.example.nutrition.order.vo;

public class Order {
	private int id;
	private String accept;
	private String accept_time;
	private String money;
	private String mun;
	private String icon;
	private String diningroom;
	public Order(int id, String accept, String accept_time, String money,
			String mun, String icon, String diningroom) {
		super();
		this.id = id;
		this.accept = accept;
		this.accept_time = accept_time;
		this.money = money;
		this.mun = mun;
		this.icon = icon;
		this.diningroom = diningroom;
	}


	public Order(String accept, String accept_time, String money, String mun,
			String diningroom) {
		super();
		this.accept = accept;
		this.accept_time = accept_time;
		this.money = money;
		this.mun = mun;
		this.diningroom = diningroom;
	}


	public Order() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getAccept_time() {
		return accept_time;
	}
	public void setAccept_time(String accept_time) {
		this.accept_time = accept_time;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMun() {
		return mun;
	}
	public void setMun(String mun) {
		this.mun = mun;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDiningroom() {
		return diningroom;
	}
	public void setDiningroom(String diningroom) {
		this.diningroom = diningroom;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", accept=" + accept + ", accept_time="
				+ accept_time + ", money=" + money + ", mun=" + mun + ", icon="
				+ icon + ", diningroom=" + diningroom + "]";
	}


}
