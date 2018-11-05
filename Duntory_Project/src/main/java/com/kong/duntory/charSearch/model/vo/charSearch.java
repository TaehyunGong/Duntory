package com.kong.duntory.charSearch.model.vo;

public class charSearch implements java.io.Serializable{

	private String characterId;
	private String characterName;
	private String level;
	private String jobId;
	private String jobGrowId;
	private String jobName;
	private String jobGrowName;
	private String server;
	private String guildId;
	private String guildName;
	
	public String getGuildId() {
		return guildId;
	}
	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}
	public charSearch(String characterId, String characterName, String level, String jobId, String jobGrowId,
			String jobName, String jobGrowName, String server, String guildId, String guildName) {
		super();
		this.characterId = characterId;
		this.characterName = characterName;
		this.level = level;
		this.jobId = jobId;
		this.jobGrowId = jobGrowId;
		this.jobName = jobName;
		this.jobGrowName = jobGrowName;
		this.server = server;
		this.guildId = guildId;
		this.guildName = guildName;
	}
	public charSearch() {
	}
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
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobGrowId() {
		return jobGrowId;
	}
	public void setJobGrowId(String jobGrowId) {
		this.jobGrowId = jobGrowId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGrowName() {
		return jobGrowName;
	}
	public void setJobGrowName(String jobGrowName) {
		this.jobGrowName = jobGrowName;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getGuildName() {
		return guildName;
	}
	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}
	@Override
	public String toString() {
		return "charSearch [characterId=" + characterId + ", characterName=" + characterName + ", level=" + level
				+ ", jobId=" + jobId + ", jobGrowId=" + jobGrowId + ", jobName=" + jobName + ", jobGrowName="
				+ jobGrowName + ", server=" + server + ", guildName=" + guildName + "]";
	}
	
	
	
}
