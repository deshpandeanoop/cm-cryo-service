package com.cm.cryo.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CryoTankDropDownAttributeDTO implements Serializable {
	private List<CryoRoomTypeDTO> roomTypes;
	private List<CryoTankTypeDTO> tankTypes;
	private List<CryoLabelTypeDTO> labelTypes;

	public List<CryoRoomTypeDTO> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<CryoRoomTypeDTO> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<CryoTankTypeDTO> getTankTypes() {
		return tankTypes;
	}

	public void setTankTypes(List<CryoTankTypeDTO> tankTypes) {
		this.tankTypes = tankTypes;
	}

	public List<CryoLabelTypeDTO> getLabelTypes() {
		return labelTypes;
	}

	public void setLabelTypes(List<CryoLabelTypeDTO> labelTypes) {
		this.labelTypes = labelTypes;
	}

}
