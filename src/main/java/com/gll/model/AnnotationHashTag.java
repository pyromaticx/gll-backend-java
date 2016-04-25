package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AnnotationHashTag {

	@Id
	private int annotationHashtagId;
	private String annotationHashtagDescription;
	private boolean useStatus;
	@OneToOne
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int userId;
	
	public AnnotationHashTag() {
		// TODO Auto-generated constructor stub
	}

	public AnnotationHashTag(int annotationHashtagId, String annotationHashtagDescription, boolean useStatus,
			String programId, String locId, Date timeUpdated, int userId) {
		super();
		this.annotationHashtagId = annotationHashtagId;
		this.annotationHashtagDescription = annotationHashtagDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getAnnotationHashtagId() {
		return annotationHashtagId;
	}

	public void setAnnotationHashtagId(int annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
	}

	public String getAnnotationHashtagDescription() {
		return annotationHashtagDescription;
	}

	public void setAnnotationHashtagDescription(String annotationHashtagDescription) {
		this.annotationHashtagDescription = annotationHashtagDescription;
	}

	public boolean isUseStatus() {
		return useStatus;
	}

	public void setUseStatus(boolean useStatus) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AnnotationHashTag [annotationHashtagId=" + annotationHashtagId + ", annotationHashtagDescription="
				+ annotationHashtagDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", userId=" + userId + "]";
	}


	
	}