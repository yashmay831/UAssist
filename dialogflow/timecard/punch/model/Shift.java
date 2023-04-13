package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class Shift {
	private Integer id;
	private String startDateTime;
	private String endDateTime;
	private Long version;
	private String label;
	private Employee employee;
	private Boolean locked;
	private Boolean posted;
	private Boolean generated;
	private Boolean deleted;
	private Boolean selfServiced;
	private List<Segment> segments = new ArrayList<Segment>();
	private Boolean postedNotificationPending;
	private List<Object> relations = new ArrayList<Object>();
	private Boolean open;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getPosted() {
		return posted;
	}

	public void setPosted(Boolean posted) {
		this.posted = posted;
	}

	public Boolean getGenerated() {
		return generated;
	}

	public void setGenerated(Boolean generated) {
		this.generated = generated;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Boolean getSelfServiced() {
		return selfServiced;
	}

	public void setSelfServiced(Boolean selfServiced) {
		this.selfServiced = selfServiced;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public Boolean getPostedNotificationPending() {
		return postedNotificationPending;
	}

	public void setPostedNotificationPending(Boolean postedNotificationPending) {
		this.postedNotificationPending = postedNotificationPending;
	}

	public List<Object> getRelations() {
		return relations;
	}

	public void setRelations(List<Object> relations) {
		this.relations = relations;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
}
