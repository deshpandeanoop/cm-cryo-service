package com.cm.cryo.ibridge;

import java.util.List;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTankFilterDTO;

public interface ICryoTankBridge {
	public CryoTankDropDownAttributeDTO getTankDropDownAttributes();
	public List<CryoTankDTO> getTanks(CryoTankFilterDTO filter);
}
