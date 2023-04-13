package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class RootShift {
	private List<Shift> shifts = new ArrayList<Shift>();
	private List<Object> payCodeEdits = new ArrayList<Object>();
	private List<Object> leaveEdits = new ArrayList<Object>();
	private List<Object> availabilities = new ArrayList<Object>();
	private List<Object> holidays = new ArrayList<Object>();
	private List<Object> dayLocks = new ArrayList<Object>();
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Object> openShifts = new ArrayList<Object>();
	private List<Object> scheduleDayList = new ArrayList<Object>();
	private List<Object> expandedJobs = new ArrayList<Object>();
	private List<Object> scheduleTags = new ArrayList<Object>();

	public List<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	public List<Object> getPayCodeEdits() {
		return payCodeEdits;
	}

	public void setPayCodeEdits(List<Object> payCodeEdits) {
		this.payCodeEdits = payCodeEdits;
	}

	public List<Object> getLeaveEdits() {
		return leaveEdits;
	}

	public void setLeaveEdits(List<Object> leaveEdits) {
		this.leaveEdits = leaveEdits;
	}

	public List<Object> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(List<Object> availabilities) {
		this.availabilities = availabilities;
	}

	public List<Object> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Object> holidays) {
		this.holidays = holidays;
	}

	public List<Object> getDayLocks() {
		return dayLocks;
	}

	public void setDayLocks(List<Object> dayLocks) {
		this.dayLocks = dayLocks;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Object> getOpenShifts() {
		return openShifts;
	}

	public void setOpenShifts(List<Object> openShifts) {
		this.openShifts = openShifts;
	}

	public List<Object> getScheduleDayList() {
		return scheduleDayList;
	}

	public void setScheduleDayList(List<Object> scheduleDayList) {
		this.scheduleDayList = scheduleDayList;
	}

	public List<Object> getExpandedJobs() {
		return expandedJobs;
	}

	public void setExpandedJobs(List<Object> expandedJobs) {
		this.expandedJobs = expandedJobs;
	}

	public List<Object> getScheduleTags() {
		return scheduleTags;
	}

	public void setScheduleTags(List<Object> scheduleTags) {
		this.scheduleTags = scheduleTags;
	}
}
