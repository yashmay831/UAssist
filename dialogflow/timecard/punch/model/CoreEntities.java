package com.dialogflow.timecard.punch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class CoreEntities {
	private EMP eMP;

	public EMP getEMP() {
		return eMP;
	}

	public void setEMP(EMP eMP) {
		this.eMP = eMP;
	}
}
