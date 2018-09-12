package com.cm.cryo.util;

public final class CryoConstants {
	private CryoConstants()
	{
		return;
	}
	public static final String CRYO_TYPE_ID="tankTypeId";
	public static final String CRYO_LABEL_ID="labelTypeId";
	public static  final String CRYO_ROOM_ID="roomTypeId";
	
	public static  final String CRYO_ROOMS_RESULTSET="cryoRooms";
	public static final String CRYO_TYPES_RESULTSET="cryoTypes";
	public static final String CRYO_LABELS_RESULTSET="cryoLabels";
	public static final String CRYO_TANKS_RESULTSET="cryoTanks";
	public static final String CRYO_PATIENT_RESULTSET = "cryoPatients";
	
	// storedproc names
	public static final String CRYO_GET_DROP_DOWN_VALUES="CM_GetTankDropDownValues";
	public static final String CRYO_GET_ALL_TANKS="CM_GetCryoTanks";
	public static final String CRYO_GET_ALL_PATIENTS="CM_GetCryoPatients";
	
	// session attribute names
	public static final String TANK_DROPDOWN_SESSION = "tankDropDownAttributes";
	
	// HTTP request, response header parameter values
	
	// header which allows to responds to multiple clients, in simpler terms, 
	// this header resolves Cross-Origin-Resource-Sharing (CORS) security violation
	public static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
}
