package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class PrimaryLaborCategories {
	private Integer referenceId;
	private String laborString;
	private List<Entry__> entries = new ArrayList<Entry__>();

	public Integer getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}

	public String getLaborString() {
		return laborString;
	}

	public void setLaborString(String laborString) {
		this.laborString = laborString;
	}

	public List<Entry__> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry__> entries) {
		this.entries = entries;
	}
}
