package com.cm.cryo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.cryo.dto.CryoMasterDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.iservice.ICryoTankService;

@RestController
public class CryoTankController {
	@Autowired
	private ICryoTankService cryoTankService;

	@CrossOrigin(origins = "*")
	@GetMapping("/loadApp")
	public CryoMasterDTO loadApp() {
		return cryoTankService.loadCryoMaster();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping("/getTankDetail")
	public CryoTankDetailResponseDTO getTankDetail(@RequestParam("tankId") int tankId,
			@RequestParam("registrationId") int registrationId, @RequestParam("patientLastName") String patName,
			@RequestParam("hrnNumber") String hrn, @RequestParam("nirc") int nirc) {
		CryoTankDetailRequestDTO requestDTO = new CryoTankDetailRequestDTO();
		requestDTO.setTankId(tankId);
		requestDTO.setRegistrationId(registrationId);
		requestDTO.setPatientLastName(patName);
		requestDTO.setHrnNumber(hrn);
		requestDTO.setNirc(nirc);
		return cryoTankService.getTankDetail(requestDTO);
	}
}
