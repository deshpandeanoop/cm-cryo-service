package com.cm.cryo.dto;

import java.util.List;

public class CryoMasterDTO {
	private List<CryoRoomDTO> rooms;
	private CryoTankDropDownAttributeDTO dropDownAttributes;

	public List<CryoRoomDTO> getRooms() {
		return rooms;
	}

	public void setRooms(List<CryoRoomDTO> rooms) {
		this.rooms = rooms;
	}

	public CryoTankDropDownAttributeDTO getDropDownAttributes() {
		return dropDownAttributes;
	}

	public void setDropDownAttributes(CryoTankDropDownAttributeDTO dropDownAttributes) {
		this.dropDownAttributes = dropDownAttributes;
	}

}
