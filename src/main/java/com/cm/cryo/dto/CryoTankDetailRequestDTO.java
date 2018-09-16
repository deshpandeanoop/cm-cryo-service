package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoTankDetailRequestDTO implements Serializable {
	private int tankId;
	private String patientLastName;
	private String hrnNumber; // Since it is a aplha-numeric value, declare it's type as String
	private int nirc; // It holds the value of episode_number of a patient, which is considered as NIRC
							 // for search criteria
	public int getTankId() {
		return tankId;
	}
	public void setTankId(int tankId) {
		this.tankId = tankId;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getHrnNumber() {
		return hrnNumber;
	}
	public void setHrnNumber(String hrnNumber) {
		this.hrnNumber = hrnNumber;
	}
	public int getNirc() {
		return nirc;
	}
	public void setNirc(int nirc) {
		this.nirc = nirc;
	}
	
}
