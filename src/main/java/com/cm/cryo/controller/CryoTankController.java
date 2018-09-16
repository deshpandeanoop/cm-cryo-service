package com.cm.cryo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.iservice.ICryoTankService;

@RestController
public class CryoTankController extends CryoMasterBaseController {
	@Autowired
	private ICryoTankService cryoTankService;

	@RequestMapping("/loadApp")
	public CryoMasterDTO loadApp() {
		setResponseParameters();
		return cryoTankService.loadCryoMaster();
	}

	@RequestMapping(value = "/getTankDetail", method = RequestMethod.POST)
	public CryoTankDetailResponseDTO getTankDetail(@RequestBody CryoTankDetailRequestDTO tankDetailRequest) {
		return cryoTankService.getTankDetail(tankDetailRequest);
	}
}
