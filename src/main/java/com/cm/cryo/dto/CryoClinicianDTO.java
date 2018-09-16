package com.cm.cryo.dto;

@SuppressWarnings("serial")
public class CryoClinicianDTO extends CryoBaseDTO {
	private boolean isDoctor;
	private boolean isEmbryologist;

	public boolean isDoctor() {
		return isDoctor;
	}

	public void setDoctor(boolean isDoctor) {
		this.isDoctor = isDoctor;
	}

	public boolean isEmbryologist() {
		return isEmbryologist;
	}

	public void setEmbryologist(boolean isEmbryologist) {
		this.isEmbryologist = isEmbryologist;
	}

}
