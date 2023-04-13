package com.dialogflow.timecard.punch.model;

import java.util.ArrayList;
import java.util.List;

public class Segment {
	private Integer id;
	private SegmentTypeRef segmentTypeRef;
	private String startDateTime;
	private String endDateTime;
	private LaborCategories laborCategories;
	private Boolean transferLaborCategories;
	private PrimaryLaborCategories primaryLaborCategories;
	private OrgJobRef orgJobRef;
	private Boolean userEnteredOrgJob;
	private Boolean transferOrgJob;
	private PrimaryOrgJobRef primaryOrgJobRef;
	private Boolean userEnteredCostCenter;
	private Boolean transferCostCenter;
	private WorkruleRef workruleRef;
	private Boolean userEnteredWorkrule;
	private Boolean transferWorkrule;
	private PrimaryWorkruleRef primaryWorkruleRef;
	private List<Object> skillCertProfileRefs = new ArrayList<Object>();
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SegmentTypeRef getSegmentTypeRef() {
		return segmentTypeRef;
	}

	public void setSegmentTypeRef(SegmentTypeRef segmentTypeRef) {
		this.segmentTypeRef = segmentTypeRef;
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

	public LaborCategories getLaborCategories() {
		return laborCategories;
	}

	public void setLaborCategories(LaborCategories laborCategories) {
		this.laborCategories = laborCategories;
	}

	public Boolean getTransferLaborCategories() {
		return transferLaborCategories;
	}

	public void setTransferLaborCategories(Boolean transferLaborCategories) {
		this.transferLaborCategories = transferLaborCategories;
	}

	public PrimaryLaborCategories getPrimaryLaborCategories() {
		return primaryLaborCategories;
	}

	public void setPrimaryLaborCategories(PrimaryLaborCategories primaryLaborCategories) {
		this.primaryLaborCategories = primaryLaborCategories;
	}

	public OrgJobRef getOrgJobRef() {
		return orgJobRef;
	}

	public void setOrgJobRef(OrgJobRef orgJobRef) {
		this.orgJobRef = orgJobRef;
	}

	public Boolean getUserEnteredOrgJob() {
		return userEnteredOrgJob;
	}

	public void setUserEnteredOrgJob(Boolean userEnteredOrgJob) {
		this.userEnteredOrgJob = userEnteredOrgJob;
	}

	public Boolean getTransferOrgJob() {
		return transferOrgJob;
	}

	public void setTransferOrgJob(Boolean transferOrgJob) {
		this.transferOrgJob = transferOrgJob;
	}

	public PrimaryOrgJobRef getPrimaryOrgJobRef() {
		return primaryOrgJobRef;
	}

	public void setPrimaryOrgJobRef(PrimaryOrgJobRef primaryOrgJobRef) {
		this.primaryOrgJobRef = primaryOrgJobRef;
	}

	public Boolean getUserEnteredCostCenter() {
		return userEnteredCostCenter;
	}

	public void setUserEnteredCostCenter(Boolean userEnteredCostCenter) {
		this.userEnteredCostCenter = userEnteredCostCenter;
	}

	public Boolean getTransferCostCenter() {
		return transferCostCenter;
	}

	public void setTransferCostCenter(Boolean transferCostCenter) {
		this.transferCostCenter = transferCostCenter;
	}

	public WorkruleRef getWorkruleRef() {
		return workruleRef;
	}

	public void setWorkruleRef(WorkruleRef workruleRef) {
		this.workruleRef = workruleRef;
	}

	public Boolean getUserEnteredWorkrule() {
		return userEnteredWorkrule;
	}

	public void setUserEnteredWorkrule(Boolean userEnteredWorkrule) {
		this.userEnteredWorkrule = userEnteredWorkrule;
	}

	public Boolean getTransferWorkrule() {
		return transferWorkrule;
	}

	public void setTransferWorkrule(Boolean transferWorkrule) {
		this.transferWorkrule = transferWorkrule;
	}

	public PrimaryWorkruleRef getPrimaryWorkruleRef() {
		return primaryWorkruleRef;
	}

	public void setPrimaryWorkruleRef(PrimaryWorkruleRef primaryWorkruleRef) {
		this.primaryWorkruleRef = primaryWorkruleRef;
	}

	public List<Object> getSkillCertProfileRefs() {
		return skillCertProfileRefs;
	}

	public void setSkillCertProfileRefs(List<Object> skillCertProfileRefs) {
		this.skillCertProfileRefs = skillCertProfileRefs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
