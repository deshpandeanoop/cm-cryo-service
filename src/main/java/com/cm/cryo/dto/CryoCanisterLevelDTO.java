package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoCanisterLevelDTO implements Serializable {
	private int levelNumber;
	private int canisterNumber;
	private int strawCount;
	private int vialCount;
	private int embryoCount;
	private CryoPatientDTO patient;
	private CryoGobletDTO goblet;

	public int getLevelNumber() {
		return levelNumber;
	}

	public int getStrawCount() {
		return strawCount;
	}

	public void setStrawCount(int strawCount) {
		this.strawCount = strawCount;
	}

	public int getVialCount() {
		return vialCount;
	}

	public void setVialCount(int vialCount) {
		this.vialCount = vialCount;
	}

	public int getEmbryoCount() {
		return embryoCount;
	}

	public void setEmbryoCount(int embryoCount) {
		this.embryoCount = embryoCount;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public CryoPatientDTO getPatient() {
		return patient;
	}

	public void setPatient(CryoPatientDTO patient) {
		this.patient = patient;
	}

	public int getCanisterNumber() {
		return canisterNumber;
	}

	public void setCanisterNumber(int canisterNumber) {
		this.canisterNumber = canisterNumber;
	}

	public CryoGobletDTO getGoblet() {
		return goblet;
	}

	public void setGoblet(CryoGobletDTO goblet) {
		this.goblet = goblet;
	}

}
