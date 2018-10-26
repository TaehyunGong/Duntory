package com.kong.duntory.member.model.vo;

public class Member implements java.io.Serializable{

	private int mid;
	private String userId;
	private String userPwd;
	private String saveId;
	
	public Member() {}

	public Member(int mid, String userId, String userPwd, String saveId) {
		super();
		this.mid = mid;
		this.userId = userId;
		this.userPwd = userPwd;
		this.saveId = saveId;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getSaveId() {
		return saveId;
	}

	public void setSaveId(String saveId) {
		this.saveId = saveId;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", userId=" + userId + ", userPwd=" + userPwd + ", saveId=" + saveId + "]";
	}
	
	
}
