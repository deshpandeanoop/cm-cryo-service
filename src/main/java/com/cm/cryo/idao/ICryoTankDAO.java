package com.cm.cryo.idao;

import java.util.List;

import com.cm.cryo.dto.CryoPatientDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;

public interface ICryoTankDAO {
	public CryoTankDropDownAttributeDTO getDropDownValues();
	public List<CryoTankDTO> getTanks();
	public List<CryoPatientDTO> getPatients();

}
