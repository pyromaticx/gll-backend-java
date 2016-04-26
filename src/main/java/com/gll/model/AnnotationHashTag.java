package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AnnotationHashTag {

	@Id
	private int annotationId;
	private int annotationHashtagId;
	private char useStatus;
	@OneToOne
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public AnnotationHashTag() {
		// TODO Auto-generated constructor stub
	}

	public AnnotationHashTag(int annotationHashtagId, String annotationHashtagDescription, char useStatus,
			String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.annotationHashtagId = annotationHashtagId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getAnnotationHashtagId() {
		return annotationHashtagId;
	}

	public void setAnnotationHashtagId(int annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
	}


	public char isUseStatus() {
		return useStatus;
	}

	public void setUseStatus(char useStatus) {
		this.useStatus = useStatus;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getLocId() {
		return LocId;
	}

	public void setLocId(String locId) {
		LocId = locId;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}



	public int getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public char getUseStatus() {
		return useStatus;
	}

	@Override
	public String toString() {
		return "AnnotationHashTag [annotationHashtagId=" + annotationHashtagId + ", annotationHashtagDescription="
				+ annotationHashtagDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", userId=" + userId + "]";
	}


	
	}