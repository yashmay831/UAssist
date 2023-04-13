package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class Leaves {
	private String dimensionKey;
	private String rowKey;
	private CoreEntities coreEntities;
	private List<Attribute> attributes = new ArrayList<Attribute>();

	public String getDimensionKey() {
		return dimensionKey;
	}

	public void setDimensionKey(String dimensionKey) {
		this.dimensionKey = dimensionKey;
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public CoreEntities getCoreEntities() {
		return coreEntities;
	}

	public void setCoreEntities(CoreEntities coreEntities) {
		this.coreEntities = coreEntities;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

}