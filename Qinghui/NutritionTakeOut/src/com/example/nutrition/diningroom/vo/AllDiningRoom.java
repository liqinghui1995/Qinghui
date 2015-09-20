package com.example.nutrition.diningroom.vo;

import java.io.Serializable;
import java.util.List;

public class AllDiningRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<DiningRoom> resultlist;
	public List<DiningRoom> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<DiningRoom> resultlist) {
		this.resultlist = resultlist;
	}
	public AllDiningRoom(List<DiningRoom> resultlist) {
		super();
		this.resultlist = resultlist;
	}
	public AllDiningRoom() {
		super();
	}
	@Override
	public String toString() {
		return "AllDiningRoom [resultlist=" + resultlist + "]";
	}
}
