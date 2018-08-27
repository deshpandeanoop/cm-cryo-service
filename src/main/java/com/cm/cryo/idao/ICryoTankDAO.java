package com.cm.cryo.idao;

import java.util.List;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;

public interface ICryoTankDAO {
	public List<CryoTankDTO> getTanks();
	public CryoTankDropDownAttributeDTO getDropDownValues();
}
