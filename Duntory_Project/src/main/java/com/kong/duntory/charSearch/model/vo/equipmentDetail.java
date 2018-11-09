package com.kong.duntory.charSearch.model.vo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class equipmentDetail implements java.io.Serializable{

	@SerializedName("characterId")
	private String characterId;
	
	@SerializedName("characterName")
	private String characterName;
	
	@SerializedName("level")
	private String level;
	
	@SerializedName("jobId")
	private String jobId;
	
	@SerializedName("jobGrowId")
	private String jobGrowId;
	
	@SerializedName("jobName")
	private String jobName;
	
	@SerializedName("jobGrowName")
	private String jobGrowName;
	
	@SerializedName("adventureName")
	private String adventureName;
	
	@SerializedName("guildId")
	private String guildId;
	
	@SerializedName("guildName")
	private String guildName;
	
	@SerializedName("equipment")
	private ArrayList<Equipment> equipment;
	
	public class Equipment{
		@SerializedName("slotId")
		private String slotId;
		
		@SerializedName("slotName")
		private String slotName;
		
		@SerializedName("itemId")
		private String itemId;
		
		@SerializedName("itemName")
		private String itemName;
		
		@SerializedName("itemType")
		private String itemType;
		
		@SerializedName("itemTypeDetail")
		private String itemTypeDetail;
		
		@SerializedName("itemAvailableLevel")
		private String itemAvailableLevel;
		
		@SerializedName("itemRarity")
		private String itemRarity;
		
		@SerializedName("setItemId")
		private String setItemId;
		
		@SerializedName("setItemName")
		private String setItemName;
		
		@SerializedName("reinforce")
		private String reinforce;
		
		@SerializedName("refine")
		private String refine;
		
		@SerializedName("amplificationName")
		private String amplificationName;
		
		@SerializedName("itemGradeName")
		private String itemGradeName;
		public Equipment(String slotId, String slotName, String itemId, String itemName, String itemType,
				String itemTypeDetail, String itemAvailableLevel, String itemRarity, String setItemId,
				String setItemName, String reinforce, String refine, String amplificationName, String itemGradeName) {
			super();
			this.slotId = slotId;
			this.slotName = slotName;
			this.itemId = itemId;
			this.itemName = itemName;
			this.itemType = itemType;
			this.itemTypeDetail = itemTypeDetail;
			this.itemAvailableLevel = itemAvailableLevel;
			this.itemRarity = itemRarity;
			this.setItemId = setItemId;
			this.setItemName = setItemName;
			this.reinforce = reinforce;
			this.refine = refine;
			this.amplificationName = amplificationName;
			this.itemGradeName = itemGradeName;
		}
		public Equipment() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Equipment [slotId=" + slotId + ", slotName=" + slotName + ", itemId=" + itemId + ", itemName="
					+ itemName + ", itemType=" + itemType + ", itemTypeDetail=" + itemTypeDetail
					+ ", itemAvailableLevel=" + itemAvailableLevel + ", itemRarity=" + itemRarity + ", setItemId="
					+ setItemId + ", setItemName=" + setItemName + ", reinforce=" + reinforce + ", refine=" + refine
					+ ", amplificationName=" + amplificationName + ", itemGradeName=" + itemGradeName + "]";
		}
		public String getSlotId() {
			return slotId;
		}
		public void setSlotId(String slotId) {
			this.slotId = slotId;
		}
		public String getSlotName() {
			return slotName;
		}
		public void setSlotName(String slotName) {
			this.slotName = slotName;
		}
		public String getItemId() {
			return itemId;
		}
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemType() {
			return itemType;
		}
		public void setItemType(String itemType) {
			this.itemType = itemType;
		}
		public String getItemTypeDetail() {
			return itemTypeDetail;
		}
		public void setItemTypeDetail(String itemTypeDetail) {
			this.itemTypeDetail = itemTypeDetail;
		}
		public String getItemAvailableLevel() {
			return itemAvailableLevel;
		}
		public void setItemAvailableLevel(String itemAvailableLevel) {
			this.itemAvailableLevel = itemAvailableLevel;
		}
		public String getItemRarity() {
			return itemRarity;
		}
		public void setItemRarity(String itemRarity) {
			this.itemRarity = itemRarity;
		}
		public String getSetItemId() {
			return setItemId;
		}
		public void setSetItemId(String setItemId) {
			this.setItemId = setItemId;
		}
		public String getSetItemName() {
			return setItemName;
		}
		public void setSetItemName(String setItemName) {
			this.setItemName = setItemName;
		}
		public String getReinforce() {
			return reinforce;
		}
		public void setReinforce(String reinforce) {
			this.reinforce = reinforce;
		}
		public String getRefine() {
			return refine;
		}
		public void setRefine(String refine) {
			this.refine = refine;
		}
		public String getAmplificationName() {
			return amplificationName;
		}
		public void setAmplificationName(String amplificationName) {
			this.amplificationName = amplificationName;
		}
		public String getItemGradeName() {
			return itemGradeName;
		}
		public void setItemGradeName(String itemGradeName) {
			this.itemGradeName = itemGradeName;
		}
		
	}

	public equipmentDetail() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAdventureName() {
		return adventureName;
	}

	public void setAdventureName(String adventureName) {
		this.adventureName = adventureName;
	}

	public String getGuildId() {
		return guildId;
	}

	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	public equipmentDetail(String characterId, String characterName, String level, String jobId, String jobGrowId,
			String jobName, String jobGrowName, String adventureName, String guildId, String guildName,
			ArrayList<Equipment> equipment) {
		super();
		this.characterId = characterId;
		this.characterName = characterName;
		this.level = level;
		this.jobId = jobId;
		this.jobGrowId = jobGrowId;
		this.jobName = jobName;
		this.jobGrowName = jobGrowName;
		this.adventureName = adventureName;
		this.guildId = guildId;
		this.guildName = guildName;
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "equipmentDetail [characterId=" + characterId + ", characterName=" + characterName + ", level=" + level
				+ ", jobId=" + jobId + ", jobGrowId=" + jobGrowId + ", jobName=" + jobName + ", jobGrowName="
				+ jobGrowName + ", adventureName=" + adventureName + ", guildId=" + guildId + ", guildName=" + guildName
				+ ", equipment=" + equipment + "]";
	}

	
	
}
