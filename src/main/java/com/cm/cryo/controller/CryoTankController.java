package com.cm.cryo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.iservice.ICryoTankService;

@RestController
public class CryoTankController {
	@Autowired
	private ICryoTankService cryoTankService;

	@RequestMapping("/loadApp")
	public CryoMasterDTO loadApp() {
		return cryoTankService.loadCryoMaster();
	}
}
