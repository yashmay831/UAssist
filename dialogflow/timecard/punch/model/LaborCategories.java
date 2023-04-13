package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class LaborCategories {
	private Integer referenceId;
	private String laborString;
	private List<Entry> entries = new ArrayList<Entry>();

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

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
}
