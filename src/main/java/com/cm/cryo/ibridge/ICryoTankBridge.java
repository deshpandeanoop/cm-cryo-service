package com.cm.cryo.ibridge;

import java.util.List;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;

public interface ICryoTankBridge {
	public CryoTankDropDownAttributeDTO getTankDropDownAttributes();
	public List<CryoTankDTO> getTanks();
}
