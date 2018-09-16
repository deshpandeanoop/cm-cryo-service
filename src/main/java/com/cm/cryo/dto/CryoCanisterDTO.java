package com.cm.cryo.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CryoCanisterDTO implements Serializable {
	private String name;
	private String capacity;
	private List<CryoCanisterLevelDTO> levels;
	private int levelCount;
	private int tankId;
	private int canisterNumber;

	public int getTankId() {
		return tankId;
	}

	public void setTankId(int tankId) {
		this.tankId = tankId;
	}

	public int getCanisterNumber() {
		return canisterNumber;
	}

	public void setCanisterNumber(int canisterNumber) {
		this.canisterNumber = canisterNumber;
	}

	public List<CryoCanisterLevelDTO> getLevels() {
		return levels;
	}

	public void setLevels(List<CryoCanisterLevelDTO> levels) {
		this.levels = levels;
	}

	public int getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

}
