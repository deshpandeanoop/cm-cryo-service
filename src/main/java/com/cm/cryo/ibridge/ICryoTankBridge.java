package com.cm.cryo.ibridge;

import java.util.List;

import com.cm.cryo.dto.CryoPatientDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;

public interface ICryoTankBridge {
	public CryoTankDropDownAttributeDTO getTankDropDownAttributes();
	public List<CryoTankDTO> getTanks();
	public List<CryoPatientDTO> getPatients();
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest);
}
