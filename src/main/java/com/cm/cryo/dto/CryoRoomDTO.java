package com.cm.cryo.dto;

import java.util.List;

public class CryoRoomDTO {
	private String roomName;
	private List<CryoTankDTO> tanks;

	public List<CryoTankDTO> getTanks() {
		return tanks;
	}

	public void setTanks(List<CryoTankDTO> tanks) {
		this.tanks = tanks;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
