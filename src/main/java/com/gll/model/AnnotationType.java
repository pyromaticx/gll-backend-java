package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnnotationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationTypeId;
	
	private String annotationTypeDescription;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int userId;
	
	
	
	public AnnotationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnotationType(int annotationTypeId, String annotationTypeDescription, boolean useStatus, String programId,
			String locId, Date timeUpdated, int userId) {
		super();
		this.annotationTypeId = annotationTypeId;
		this.annotationTypeDescription = annotationTypeDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}
	public int getAnnotationTypeId() {
		return annotationTypeId;
	}
	public void setAnnotationTypeId(int annotationTypeId) {
		this.annotationTypeId = annotationTypeId;
	}
	public String getAnnotationTypeDescription() {
		return annotationTypeDescription;
	}
	public void setAnnotationTypeDescription(String annotationTypeDescription) {
		this.annotationTypeDescription = annotationTypeDescription;
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
		return "AnnotationType [annotationTypeId=" + annotationTypeId + ", annotationTypeDescription="
				+ annotationTypeDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", LocId="
				+ LocId + ", timeUpdated=" + timeUpdated + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((annotationTypeDescription == null) ? 0 : annotationTypeDescription.hashCode());
		result = prime * result + annotationTypeId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnotationType other = (AnnotationType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (annotationTypeDescription == null) {
			if (other.annotationTypeDescription != null)
				return false;
		} else if (!annotationTypeDescription.equals(other.annotationTypeDescription))
			return false;
		if (annotationTypeId != other.annotationTypeId)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}