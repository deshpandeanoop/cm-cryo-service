package com.cm.cryo.bridge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cm.cryo.dto.CryoPatientDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTankFilterDTO;
import com.cm.cryo.ibridge.ICryoTankBridge;
import com.cm.cryo.idao.ICryoTankDAO;

@Component
public class CryoTankBridge implements ICryoTankBridge {
	@Autowired
	private ICryoTankDAO cryoTankDAO;

	@Override
	public CryoTankDropDownAttributeDTO getTankDropDownAttributes() {
		return cryoTankDAO.getDropDownValues();
	}

	@Override
	public List<CryoTankDTO> getTanks(CryoTankFilterDTO filter) {
		return null;
	}

	@Override
	public List<CryoTankDTO> getTanks() {
		return cryoTankDAO.getTanks();
	}

	@Override
	public List<CryoPatientDTO> getPatients() {
		return cryoTankDAO.getPatients();
	}

}
