package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoTankFilterDTO implements Serializable{
private int roomTypeId ;
private int tankTypeId ;
private int labelTypeId ;
public int getRoomTypeId() {
	return roomTypeId;
}
public void setRoomTypeId(int roomTypeId) {
	this.roomTypeId = roomTypeId;
}
public int getTankTypeId() {
	return tankTypeId;
}
public void setTankTypeId(int tankTypeId) {
	this.tankTypeId = tankTypeId;
}
public int getLabelTypeId() {
	return labelTypeId;
}
public void setLabelTypeId(int labelTypeId) {
	this.labelTypeId = labelTypeId;
}

}
