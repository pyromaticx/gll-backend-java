package com.gll.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hashtag {
	
	private int annotationHashtagId;
	private String annotationHashtagDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
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
	public char getUseStatus() {
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
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}