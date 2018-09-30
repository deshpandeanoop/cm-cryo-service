package com.cm.cryo.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cm.cryo.dto.CryoCanisterDTO;
import com.cm.cryo.dto.CryoCanisterLevelDTO;
import com.cm.cryo.dto.CryoClinicianDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.util.CryoConstants;

public class CryoTankDetailResponseMapper {
	private CryoTankDetailResponseMapper() {
		return;
	}
	@SuppressWarnings("unchecked")
	public static CryoTankDetailResponseDTO formCryoTankDetailResponseFromResponseMap(Map<String, Object> responseMap) {
		CryoTankDetailResponseDTO tankDetailResponse = new CryoTankDetailResponseDTO();
		List<CryoTankDTO> tanks = (List<CryoTankDTO>) responseMap.get(CryoConstants.CRYO_TANKS_RESULTSET);
		// Since tank_id is unique for the tank, there exits only one element in the list.
		// There is also no possibility of getting empty list, since always valid non-deleted tank_id is passed in the request
		CryoTankDTO tank = tanks.get(0);
		List<CryoCanisterDTO> canisters = (List<CryoCanisterDTO>) responseMap
				.get(CryoConstants.CRYO_CANISTER_RESULTSET);
		if (null != canisters && !canisters.isEmpty()) {
			formCanistersFromResponse(canisters,
					(List<CryoCanisterLevelDTO>) responseMap.get(CryoConstants.CRYO_LEVEL_RESULTSET));
		}
		tank.setCanisters(canisters);
		tankDetailResponse.setTank(tank);
		tankDetailResponse
				.setDoctors((List<CryoClinicianDTO>) responseMap.get(CryoConstants.CRYO_CLINICIANS_RESULTSET));
		return tankDetailResponse;
	}

	private static List<CryoCanisterDTO> formCanistersFromResponse(List<CryoCanisterDTO> canisters,
			List<CryoCanisterLevelDTO> levels) {
		if (null != levels && !levels.isEmpty()) {
			List<CryoCanisterLevelDTO> canisterLevels = null;
			for (CryoCanisterDTO canister : canisters) {
				canisterLevels = new ArrayList<>();
				for (CryoCanisterLevelDTO level : levels) {
					if (canister.getCanisterNumber() == level.getCanisterNumber()) {
						canisterLevels.add(level);
					}
				}
				canister.setLevels(canisterLevels);
			}
		}
		return canisters;
	}
}
