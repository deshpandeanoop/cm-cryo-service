package com.cm.cryo.iservice;


import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;

public interface ICryoTankService {
	public CryoMasterDTO loadCryoMaster();
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest);
}
