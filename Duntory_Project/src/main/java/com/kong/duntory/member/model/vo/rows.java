package com.kong.duntory.member.model.vo;

import com.google.gson.annotations.SerializedName;

public class rows implements java.io.Serializable{

	@SerializedName("code")
	private String code;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("date")
	private String date;
	
	@SerializedName("data")
	private data Data;
	
	public data getData() {
		return Data;
	}

	public void setData(data data) {
		Data = data;
	}

	public class data{
		@SerializedName("single")
		private String single;
		
		@SerializedName("raidName")
		private String raidName;
		
		@SerializedName("phaseName")
		private String phaseName;
		
		@SerializedName("hard")	
		private String hard;

		public String getSingle() {
			return single;
		}

		public void setSingle(String single) {
			this.single = single;
		}

		public String getRaidName() {
			return raidName;
		}

		public void setRaidName(String raidName) {
			this.raidName = raidName;
		}

		public String getPhaseName() {
			return phaseName;
		}

		public void setPhaseName(String phaseName) {
			this.phaseName = phaseName;
		}

		public String getHard() {
			return hard;
		}

		public void setHard(String hard) {
			this.hard = hard;
		}

		@Override
		public String toString() {
			return "data [single=" + single + ", raidName=" + raidName + ", phaseName=" + phaseName + ", hard=" + hard
					+ "]";
		}
		
	}

	public rows() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "rows [code=" + code + ", name=" + name + ", date=" + date + ", Data=" + Data + "]";
	}
	
	
	
}
