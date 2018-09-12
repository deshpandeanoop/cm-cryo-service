package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoPatientDTO implements Serializable {
	private int registrationId;
	private String name;
	private int nric; // considering episode_number associated with a patient as NIRC
	private String hrn;
	private int tankId;
	private int canisterNumber;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNric() {
		return nric;
	}

	public void setNric(int nric) {
		this.nric = nric;
	}

	public String getHrn() {
		return hrn;
	}

	public void setHrn(String hrn) {
		this.hrn = hrn;
	}

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
	
	
}
