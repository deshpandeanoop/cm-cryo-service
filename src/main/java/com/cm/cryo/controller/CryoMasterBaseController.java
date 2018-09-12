package com.cm.cryo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CryoMasterBaseController {
	@Autowired
	private HttpServletResponse response;

	protected void setResponseParameters() {
		this.response.setHeader("Access-Control-Allow-Origin", "*");
	}
}
