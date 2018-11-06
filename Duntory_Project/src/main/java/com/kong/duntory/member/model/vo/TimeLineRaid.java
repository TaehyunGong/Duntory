package com.kong.duntory.member.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TimeLineRaid implements java.io.Serializable{
	
	@SerializedName("characterId")
	private String characterId;
	
	@SerializedName("characterName")
	private String characterName;
	
	@SerializedName("level")
	private String level;
	
	@SerializedName("jobGrowName")
	private String jobGrowName;
	
	@SerializedName("adventureName")
	private String adventureName;
	
	@SerializedName("guildName")
	private String guildName;
	
	@SerializedName("timeline")
	private timeline timeLine;
	
	private String server;
	
	private int singleAntonRaid = 0;	//싱글안톤
	private int antonRaid = 0;			//안톤
	private int singleLukeRaid = 0;		//싱글루크
	private int lukeRaid = 0;			//루크
	private int hardLukeRaid = 0;		//하드루크
	private int fiendWar = 0;			//핀드워
	private int masuDungeon = 0;		//마수던전
	
	public timeline getTimeLine() {
		return timeLine;
	}


	public void setTimeLine(timeline timeLine) {
		this.timeLine = timeLine;
	}


	public class timeline{
		@SerializedName("next")
		private String next;
		
		@SerializedName("rows")
		private List<rows> rowsList = new ArrayList<rows>();

		public String getNext() {
			return next;
		}

		public void setNext(String next) {
			this.next = next;
		}

		public List<rows> getRowsList() {
			return rowsList;
		}

		public void setRowsList(List<rows> rowsList) {
			this.rowsList = rowsList;
		}
	}
	
	public TimeLineRaid() {}


	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}


	public String getCharacterName() {
		return characterName;
	}


	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getJobGrowName() {
		return jobGrowName;
	}


	public void setJobGrowName(String jobGrowName) {
		this.jobGrowName = jobGrowName;
	}


	public String getAdventureName() {
		return adventureName;
	}


	public void setAdventureName(String adventureName) {
		this.adventureName = adventureName;
	}


	public String getGuildName() {
		return guildName;
	}


	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}


	public int getSingleAntonRaid() {
		return singleAntonRaid;
	}


	public void setSingleAntonRaid(int singleAntonRaid) {
		this.singleAntonRaid = singleAntonRaid;
	}


	public int getAntonRaid() {
		return antonRaid;
	}


	public void setAntonRaid(int antonRaid) {
		this.antonRaid = antonRaid;
	}


	public int getSingleLukeRaid() {
		return singleLukeRaid;
	}


	public void setSingleLukeRaid(int singleLukeRaid) {
		this.singleLukeRaid = singleLukeRaid;
	}


	public int getLukeRaid() {
		return lukeRaid;
	}


	public void setLukeRaid(int lukeRaid) {
		this.lukeRaid = lukeRaid;
	}


	public int getHardLukeRaid() {
		return hardLukeRaid;
	}


	public void setHardLukeRaid(int hardLukeRaid) {
		this.hardLukeRaid = hardLukeRaid;
	}


	public int getFiendWar() {
		return fiendWar;
	}


	public void setFiendWar(int fiendWar) {
		this.fiendWar = fiendWar;
	}


	public int getMasuDungeon() {
		return masuDungeon;
	}


	public void setMasuDungeon(int masuDungeon) {
		this.masuDungeon = masuDungeon;
	}


	public String getServer() {
		return server;
	}


	public void setServer(String server) {
		this.server = server;
	}

	@Override
	public String toString() {
		return "TimeLineRaid [characterId=" + characterId + ", characterName=" + characterName + ", level=" + level
				+ ", jobGrowName=" + jobGrowName + ", adventureName=" + adventureName + ", guildName=" + guildName
				+ ", timeLine=" + timeLine + ", server=" + server + ", singleAntonRaid=" + singleAntonRaid
				+ ", antonRaid=" + antonRaid + ", singleLukeRaid=" + singleLukeRaid + ", lukeRaid=" + lukeRaid
				+ ", hardLukeRaid=" + hardLukeRaid + ", fiendWar=" + fiendWar + ", masuDungeon=" + masuDungeon + "]";
	}
	
}
