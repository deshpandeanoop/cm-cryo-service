package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoCanisterDTO implements Serializable {
	private String name;
	private String capacity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

}
