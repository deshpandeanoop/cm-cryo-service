package com.cm.cryo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.cryo.dto.CryoCanisterDTO;
import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoRoomDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.ibridge.ICryoTankBridge;
import com.cm.cryo.iservice.ICryoTankService;
import com.cm.cryo.util.CryoConstants;

@Service
public class CryoTankService implements ICryoTankService {
	@Autowired
	private ICryoTankBridge cryoTankBridge;
	@Autowired
	private HttpSession session;

	@Override
	public CryoMasterDTO loadCryoMaster() {
		CryoMasterDTO cryoMaster = new CryoMasterDTO();
		if (null == session.getAttribute(CryoConstants.TANK_DROPDOWN_SESSION)) {
			cryoMaster.setDropDownAttributes(cryoTankBridge.getTankDropDownAttributes());
			// setting the drop down values as session attribute to avoid multiple database
			// calls, which eventually boosts up the performance
			session.setAttribute(CryoConstants.TANK_DROPDOWN_SESSION, cryoMaster.getDropDownAttributes());
		} else {
			cryoMaster.setDropDownAttributes(
					(CryoTankDropDownAttributeDTO) session.getAttribute(CryoConstants.TANK_DROPDOWN_SESSION));
		}
		List<CryoTankDTO> tanks = cryoTankBridge.getTanks();
		// Based on level count and canister count, setting capacity of the tank
		// and creating equivalant canister units per tank with calculated capacity
		tanks.forEach(tank -> {
			populateCanisters(tank);
			tank.setCapacity("0/150");
		});
		List<CryoRoomDTO> rooms = new ArrayList<>();
		cryoMaster.getDropDownAttributes().getRoomTypes().stream()
				.forEach(room -> rooms.add(createRoomWithTanks(tanks, room.getName())));
		cryoMaster.setRooms(rooms);
		cryoMaster.setPatients(cryoTankBridge.getPatients());
		return cryoMaster;
	}

	private void populateCanisters(CryoTankDTO tank) {
		List<CryoCanisterDTO> canisters = new ArrayList<>();
		CryoCanisterDTO canister = null;
		for (int i = 1; i <= tank.getCanisterCount(); i++) {
			canister = new CryoCanisterDTO();
			canister.setName("Canister " + i);
			canister.setCapacity("0/15");
			canisters.add(canister);
		}
		tank.setCanisters(canisters);
	}

	private CryoRoomDTO createRoomWithTanks(List<CryoTankDTO> tanks, String roomName) {
		CryoRoomDTO room = new CryoRoomDTO();
		room.setRoomName(roomName);
		room.setTanks(
				tanks.stream().filter(tank -> tank.getRoom().equalsIgnoreCase(roomName)).collect(Collectors.toList()));
		return room;
	}

	@Override
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest) {
		return cryoTankBridge.getTankDetail(tankDetailRequest);
	}

}
