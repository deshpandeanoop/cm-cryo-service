package com.cm.cryo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.cryo.dto.CryoCanisterDTO;
import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoRoomDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.ibridge.ICryoTankBridge;
import com.cm.cryo.iservice.ICryoTankService;

@Service
public class CryoTankService implements ICryoTankService {
	@Autowired
	private ICryoTankBridge cryoTankBridge;

	@Override
	public CryoMasterDTO loadCryoMaster() {
		CryoMasterDTO cryoMaster = new CryoMasterDTO();
		cryoMaster.setDropDownAttributes(cryoTankBridge.getTankDropDownAttributes());
		List<CryoTankDTO> tanks = cryoTankBridge.getTanks();

		Consumer<CryoTankDTO> consumer = tank -> {
			List<CryoCanisterDTO> canisters = new ArrayList<>();
			CryoCanisterDTO canister = null;
			for (int i = 1; i <= tank.getCanisterCount(); i++) {
				canister = new CryoCanisterDTO();
				canister.setName("Canister " + i);
				canister.setCapacity("0/15");
				canisters.add(canister);
			}
			tank.setCanisters(canisters);
			tank.setCapacity("0/150");
		};
		tanks.forEach(consumer);
		List<CryoRoomDTO> rooms = new ArrayList<>();
		CryoRoomDTO roomType1 = new CryoRoomDTO();
		roomType1.setTanks(
				tanks.stream().filter(tank -> tank.getRoom().equalsIgnoreCase("All")).collect(Collectors.toList()));
		CryoRoomDTO roomType2 = new CryoRoomDTO();
		roomType2.setTanks(
				tanks.stream().filter(tank -> tank.getRoom().equalsIgnoreCase("IUI")).collect(Collectors.toList()));
		CryoRoomDTO roomType3 = new CryoRoomDTO();
		roomType3.setTanks(
				tanks.stream().filter(tank -> tank.getRoom().equalsIgnoreCase("IUI")).collect(Collectors.toList()));
		rooms.add(roomType1);
		rooms.add(roomType2);
		rooms.add(roomType3);
		cryoMaster.setRooms(rooms);
		return cryoMaster;
	}

}
