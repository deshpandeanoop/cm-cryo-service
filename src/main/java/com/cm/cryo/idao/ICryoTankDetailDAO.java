package com.cm.cryo.idao;

import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;

public interface ICryoTankDetailDAO {
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest);
}
