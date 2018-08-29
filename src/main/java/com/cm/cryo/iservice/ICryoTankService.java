package com.cm.cryo.iservice;

import java.util.List;

import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankFilterDTO;

public interface ICryoTankService {
	public CryoMasterDTO loadCryoMaster();
	public List<CryoTankDTO> getTanks(CryoTankFilterDTO filter);
}
