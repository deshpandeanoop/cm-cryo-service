package com.cm.cryo.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CryoTankDetailResponseDTO implements Serializable {
	private CryoTankDTO tank;
	private List<CryoClinicianDTO> doctors;

	public CryoTankDTO getTank() {
		return tank;
	}

	public void setTank(CryoTankDTO tank) {
		this.tank = tank;
	}

	public List<CryoClinicianDTO> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<CryoClinicianDTO> doctors) {
		this.doctors = doctors;
	}

}
