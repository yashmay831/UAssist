package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class RootLeaves {
	private List<Leaves> data = new ArrayList<Leaves>();

	public List<Leaves> getData() {
		return data;
	}

	public void setData(List<Leaves> data) {
		this.data = data;
	}
}
