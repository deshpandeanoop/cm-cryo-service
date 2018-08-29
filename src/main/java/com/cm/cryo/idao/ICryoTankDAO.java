package com.cm.cryo.idao;

import java.util.List;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTankFilterDTO;

public interface ICryoTankDAO {
	public List<CryoTankDTO> getTanks(CryoTankFilterDTO filter);
	public CryoTankDropDownAttributeDTO getDropDownValues();
}
