package com.cm.cryo.dto;

import java.util.List;

public class CryoRoomDTO {
	private List<CryoTankDTO> tanks;

	public List<CryoTankDTO> getTanks() {
		return tanks;
	}

	public void setTanks(List<CryoTankDTO> tanks) {
		this.tanks = tanks;
	}

}
