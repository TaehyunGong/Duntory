package com.kong.duntory.member.model.vo;

public class WishList implements java.io.Serializable{
	
	private int wid;
	private int mid;
	private String char_id;
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishList(int wid, int mid, String char_id) {
		super();
		this.wid = wid;
		this.mid = mid;
		this.char_id = char_id;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getChar_id() {
		return char_id;
	}
	public void setChar_id(String char_id) {
		this.char_id = char_id;
	}
	@Override
	public String toString() {
		return "WishList [wid=" + wid + ", mid=" + mid + ", char_id=" + char_id + "]";
	}
	
	

}
