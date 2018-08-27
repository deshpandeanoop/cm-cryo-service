package com.cm.cryo.idao;

import java.util.List;

import com.cm.cryo.dto.CryoTankDTO;

public interface ICryoTankDAO {

	public List<CryoTankDTO> getTanks();
}
