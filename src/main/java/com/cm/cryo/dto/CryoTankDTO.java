package com.cm.cryo.dto;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class CryoTankDTO extends CryoBaseDTO {
	private String description;
	private String room;
	private String label;
	private String type;
	private int canisterCount;
	private List<CryoCanisterDTO> canisters;
	private int levelCount;
	private Date manufacturedDate;
	private int deleted;
	private String deletedBy;
	private Date deletedAt;
	private String updatedBy;
	private Date updatedAt;
	private String createdBy;
	private Date createdAt;
	private String capacity;

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCanisterCount() {
		return canisterCount;
	}

	public void setCanisterCount(int canisterCount) {
		this.canisterCount = canisterCount;
	}

	public int getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<CryoCanisterDTO> getCanisters() {
		return canisters;
	}

	public void setCanisters(List<CryoCanisterDTO> canisters) {
		this.canisters = canisters;
	}

}
