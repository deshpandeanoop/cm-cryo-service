package com.cm.cryo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.iservice.ICryoTankService;

@RestController
public class CryoTankController {
	@Autowired
	private ICryoTankService cryoTankService;
	@Autowired
	private HttpServletResponse response;

	@RequestMapping("/loadApp")
	public CryoMasterDTO loadApp() {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return cryoTankService.loadCryoMaster();
	}
}
