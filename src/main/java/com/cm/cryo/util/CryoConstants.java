package com.cm.cryo.util;

public class CryoConstants {
	private CryoConstants()
	{
		return;
	}
	public static String CRYO_TYPE_ID="cryoTypeId";
	public static String CRYO_LABEL_ID="cryoLabelId";
	public static String CRYO_ROOM_ID="cryoRoomId";
	
	public static String CRYO_ROOMS_RESULTSET="cryoRooms";
	public static String CRYO_TYPES_RESULTSET="cryoTypes";
	public static String CRYO_LABELS_RESULTSET="cryoLabels";
	public static String CRYO_TANKS_RESULTSET="cryoTanks";
	
	// storedproc names
	public static String CRYO_GET_DROP_DOWN_VALUES="CM_GetTankDropDownValues";
	public static String CRYO_GET_TANKS="CM_GetCryoTanks";
}
