package com.dialogflow.timecard.punch.model;

public class Entry {
	private LaborCategory laborCategory;
	private Entry_ entry;

	public LaborCategory getLaborCategory() {
		return laborCategory;
	}

	public void setLaborCategory(LaborCategory laborCategory) {
		this.laborCategory = laborCategory;
	}

	public Entry_ getEntry() {
		return entry;
	}

	public void setEntry(Entry_ entry) {
		this.entry = entry;
	}
}
